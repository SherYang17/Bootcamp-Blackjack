// Enums

public enum Suits {
    SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u2666"), HEARTS("\u2665");

    //converted text to the symbols
    private final String symbol;

    Suits(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


}
