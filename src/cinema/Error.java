package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("error")
    String desciption;

    public Error() {
    }

    public Error(String desciption) {
        this.desciption = desciption;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }






}
