package cinema;

public class Request {
    int row;
    int column;

    public Request(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Request(){
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





}
