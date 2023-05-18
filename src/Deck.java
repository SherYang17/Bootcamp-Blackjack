import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public void createFullDeck() {
        // 13:51 https://www.youtube.com/watch?v=xLhgqPUHoVs&t=2s
        for (Values cardValue : Values.values()) {  // loop into enum class Values
             for (Suits cardSuit : Suits.values()) { // loop into enum class Suits
                this.deck.add(new Card(cardValue, cardSuit)); // add those into our current deck
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck); // utilize Collections shuffle() method
    }

    public Card getCard(int i) {
        return this.deck.get(i);
    }

    public void removeCard(int i) {
        this.deck.remove(i);
    }

    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }

    public int deckSize() {
        return this.deck.size();
    }

    public Card draw() {
        Card card = getCard(0);
        removeCard(0);
        return card;
    }

    public void moveAllToDeck(Deck moveTo) {
        int deckSize = this.deck.size();

        for (int i = 0; i < deckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }

        for (int i = 0; i < deckSize; i++) {
            this.removeCard(0);
        }
    }

    public int getHandValue() {
        int value = 0;
        int aces = 0;

        for (Card card : deck) { // Loop for each card in the deck
            Values cardValue = card.getValue(); // assign each card's getValue method from card class and assign it to variable
            if (cardValue == Values.ACE) {
                aces++;
                value = value + 11;
            } else if (cardValue == Values.JACK || cardValue == Values.QUEEN || cardValue == Values.KING) {
                value = value + 10;
            } else {
                value = value + cardValue.ordinal() + 2;
            }
        }

        // Make Ace equal +1 if the hand value is greater than 21
        while (value > 21 && aces > 0) {
            value = value - 10;
            aces--;
        }

        return value;
    }

    @Override

    // put everything together and separate it by commas
    public String toString() {
        StringBuilder cardList = new StringBuilder();

        for (int i = 0; i < deck.size(); i++) {
            cardList.append(deck.get(i).toString());

            if (i < deck.size() - 1) {
                cardList.append(", ");
            }
        }
        return cardList.toString();
    }
}













//    public String toString() {
//        String cardList = "";
//
//        for (Card card : this.deck) {
//            cardList += card.toString() + "\n";
//        }
//
//        return cardList;
//    }





//
//    public void createFullDeck() {
//        for (Suits cardSuit : Suits.values()) {
//            for (Values cardValue : Values.values()) {
//                this.deck.add(new Card(cardSuit, cardValue));
//            }
//        }
//    }