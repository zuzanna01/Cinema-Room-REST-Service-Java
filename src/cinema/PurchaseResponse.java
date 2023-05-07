package cinema;

import java.util.UUID;

public class PurchaseResponse {
    UUID token ;
    Ticket ticket;

    public PurchaseResponse() {
    }

    public PurchaseResponse(Ticket ticket) {
        this.token = UUID.randomUUID();
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}