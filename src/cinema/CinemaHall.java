package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class CinemaHall {



    private class Seat {

        int row;
        int column;


        int price;
        boolean isTaken;




        Seat() {
            this.row = 0;
            this.column = 0;
            this.price = 0;
            this.isTaken = false;

        }

        Seat(int row, int column) {
            this.row = row;
            this.column = column;
            this.isTaken =false;
            if (row <= 4) this.price = 10;
            else this.price = 8;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @JsonIgnore
        public boolean isTaken() {
            return isTaken;
        }
        @JsonIgnore
        public void setTaken(boolean taken) {
            isTaken = taken;
        }

    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    @JsonProperty("available_seats")
    public ArrayList<Seat> seats;

    @JsonProperty("total_rows")
    int totalRows;

    @JsonProperty("total_columns")
    int totalColumns;

    @JsonIgnore
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonIgnore
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }


    Statistics statistics;

    public void numerSeats() {
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    CinemaHall(){
        totalColumns = totalRows = 9;
        seats = new ArrayList<>(totalColumns * totalRows);
        numerSeats();
        this.statistics = new Statistics();
        this.statistics.setCurrentIncome(0);
        this.statistics.setNumberOfAvailableSeats(totalRows*totalColumns);
        this.statistics.setNumberOfPurchasedTickets(0);
    }

    public int bookSeat(int row, int column) {
        if (row>totalRows || column> totalColumns ||row<1||column<1)
            return 0;

        int index = row*totalRows+column;

        if (seats.get(index).isTaken()==false){
            seats.get(index).setTaken(true);
            int price = seats.get(index).getPrice();
            statistics.addIncome(price);
            statistics.decrementNumberOfAvailableSeats();
            statistics.incrementNumberPurchasedTickets();
            return 1;
        }
        else
            return -1;

    }

    public int freeSeat(int row, int column){
        if (row>totalRows || column> totalColumns ||row<1||column<1)
            return 0;

        int index = row*totalRows+column;

        if (seats.get(index).isTaken()==true){
            seats.get(index).setTaken(false);
            int price = seats.get(index).getPrice();
            statistics.deleteIncome(price);
            statistics.incrementNumberOfAvailableSeats();
            statistics.decrementNumberPurchasedTickets();
            return 1;
        }
        else
            return -1;
    }
}
