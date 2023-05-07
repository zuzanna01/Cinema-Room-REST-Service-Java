package cinema;

public class TokenHelper {
    String token;

    @Override
    public String toString() {
        return  token ;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenHelper(String token) {
        this.token = token;
    }

    public TokenHelper() {
    }



}
