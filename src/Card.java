import java.util.Random;

public class Card {
    private Suits suit;
    private Values value;

    // create arrays for values and suits - need these to generate random cards
    private Values[] values = Values.values();
    private Suits[] suits = Suits.values();
    private Random randomValues = new Random();
    private Random randomSuits = new Random();


    // Constructor here, going to pass the 2 values thru here
    public Card(Values value, Suits suit) {
        this.value = value;
        this.suit = suit;
    }

    // random card generated
    public Card() {
        this.suit = getRandomSuit();
        this.value = getRandomValue();
    }


    // This combines heart,diamond,clover,spade with the 2,3,4,5,6,7,8,9,10,j,q,k,a
    // Use getSymbol() method since suit text was converted to symbols
    public String toString() {
        return  this.value.toString() + "-" + this.suit.getSymbol();
    }

    // This returns the 2,3,4,5,6,7,8,9,10,J,Q,K,A
    public Values getValue() {
        return this.value;
    }


    public Values getRandomValue() {
        return values[randomValues.nextInt(values.length)];
    }

    public Suits getRandomSuit() {
        return suits[randomSuits.nextInt(values.length)];
    }


}
