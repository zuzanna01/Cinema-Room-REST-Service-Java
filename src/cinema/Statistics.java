package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    public Statistics() {
        this.currentIncome = 0;
        this.numberOfAvailableSeats = 0;
        this.numberOfPurchasedTickets = 0;
    }

    @JsonProperty("current_income")
    int currentIncome;

    @JsonProperty("number_of_available_seats")
    int numberOfAvailableSeats;

    @JsonProperty("number_of_purchased_tickets")
    int numberOfPurchasedTickets;

    public void addIncome(int price){
        this.currentIncome += price;
    }

    public void deleteIncome(int price){
        this.currentIncome -= price;
    }

    public void incrementNumberOfAvailableSeats(){
        this.numberOfAvailableSeats++;
    }

    public void decrementNumberOfAvailableSeats(){
        this.numberOfAvailableSeats--;
    }

    public void incrementNumberPurchasedTickets(){
        this.numberOfPurchasedTickets++;
    }

    public void decrementNumberPurchasedTickets(){
        this.numberOfPurchasedTickets--;
    }




}
