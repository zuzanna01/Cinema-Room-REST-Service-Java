package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@RestController
public class CinemaController {

    private CinemaHall cinemaHall =  new CinemaHall();
    private HashMap<String, Ticket> purchasedTickets= new HashMap<>();

    @GetMapping("/seats")
    public CinemaHall returnAvailableSeats() {
        return cinemaHall;
    }

    @PostMapping("/purchase")
    public ResponseEntity bookTicket(@RequestBody Request request){

        int row = request.getRow();
        int column = request.getColumn();
        int result = cinemaHall.bookSeat(row, column);

        int price;
        if (result == 1){
            if (row <= 4) price = 10;
            else price = 8;
            Ticket ticket = new Ticket(row,column,price);
            PurchaseResponse response = new PurchaseResponse(ticket);
            purchasedTickets.put(response.getToken().toString(),response.getTicket());
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        else if(result == -1){
            Error error = new Error("The ticket has been already purchased!") ;
            return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }
        else{
            Error error = new Error("The number of a row or a column is out of bounds!");
            return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        }
    }

    @PostMapping("/return")
    public ResponseEntity returnTicket(@RequestBody TokenHelper token_helper){

        String token = token_helper.toString();
        if (purchasedTickets.containsKey(token)){
            Ticket ticket = purchasedTickets.get(token);
            purchasedTickets.remove(token);
            cinemaHall.freeSeat(ticket.getRow(), ticket.getColumn());
            ReturnedTicketResponse response = new ReturnedTicketResponse(ticket);
            return new ResponseEntity<Object>(response,HttpStatus.OK);
        }
        else{
            Error error = new Error("Wrong token!");
            return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/stats")
    public ResponseEntity getStatistics(@RequestParam(required = false) String  password){

            if(password == null){
                Error error = new Error("The password is wrong!");
                return new ResponseEntity<Object>(error,HttpStatus.UNAUTHORIZED);
            }
            if(password.equals("super_secret")){
                return new ResponseEntity<Object>(cinemaHall.getStatistics(),HttpStatus.OK);
            }
            else{
                Error error = new Error("The password is wrong!");
                return new ResponseEntity<Object>(error,HttpStatus.UNAUTHORIZED);
            }

    }

}
