import java.util.Objects;

public class Square {

    private ValueOfSquare valueOfSquare;

    Square(ValueOfSquare valueOfSquare) {
        this.valueOfSquare = valueOfSquare;
    }

    void setValueOfSquare(ValueOfSquare valueOfSquare) {
        this.valueOfSquare = valueOfSquare;
    }

    ValueOfSquare getValueOfSquare() {
        return valueOfSquare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square aSquare = (Square) o;
        return Objects.equals(valueOfSquare, aSquare.valueOfSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOfSquare);
    }

    public enum ValueOfSquare {

        EMPTY("X"),
        BOAT("B"),
        SUNK_BOAT("S");

        private String representationOnTheBoard;

        ValueOfSquare(String representationOnTheBoard) {
            this.representationOnTheBoard = representationOnTheBoard;
        }

        public String getRepresentationOnTheBoard() {
            return representationOnTheBoard;
        }
    }
}


