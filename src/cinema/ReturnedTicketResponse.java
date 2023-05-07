package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnedTicketResponse {
    public ReturnedTicketResponse(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Ticket getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public ReturnedTicketResponse() {
    }

    @JsonProperty("returned_ticket")
    Ticket returnedTicket ;

}
