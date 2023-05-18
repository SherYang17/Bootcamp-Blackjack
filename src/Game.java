
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck playingDeck = new Deck();

        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* * * * * Welcome to Blackjack!* * * * *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(" ");
        System.out.print("Enter your Name: ");
        String playerName = scanner.next();

        System.out.print("Enter your balance: ");
        int balance = scanner.nextInt();
        int originalValue = balance;

        // Begin Loop to Play The Game
        boolean playAnotherRound = true;
        while (playAnotherRound) {

            // Method getBetAmount to ask user their bet
            int bet = getBetAmount(scanner);


            System.out.println(" ");
            playingDeck.createFullDeck(); // System.out.println(playingDeck);
            playingDeck.shuffleDeck();

            // Create hands for the player and the dealer
            Deck playerHand = new Deck();
            Deck dealerHand = new Deck();

            // Deal initial cards
            playerHand.addCard(playingDeck.draw());
            dealerHand.addCard(playingDeck.draw());
            playerHand.addCard(playingDeck.draw());
            dealerHand.addCard(playingDeck.draw());

            // Display initial hands
            System.out.println("The deck has been shuffled and the cards have been passed out.");
            System.out.println(playerName + "'s Hand: " + playerHand);
            System.out.println("Dealer's Hand: " + dealerHand.getCard(0) + ", [Hidden Card]");
            System.out.println(" ");


            boolean playerTurn = true;
            boolean gameIsOver = false;

            while (!gameIsOver) { // While NOT false
                // So if player action
                if (playerTurn) {
                    // Player's turn
                    System.out.println("Do you want to Hit or Stand?");
                    String userChoice = scanner.next().toLowerCase();
                    System.out.println(" ");

                    // Hit = 1
                    if (userChoice.equals("hit")) {
                        playerHand.addCard(playingDeck.draw());
                        System.out.println(playerName + "'played Card: " + playerHand);

                        // Busts if over 21
                        if (playerHand.getHandValue() > 21) {
                            System.out.println(playerName + " busts! Dealer wins.");
                            gameIsOver = true;
                            balance = balance - bet;
                        }

                        // Stand = 2
                    } else if (userChoice.equals("stand")) {
                        playerTurn = false;
                    }

                    // Else Dealer turn
                } else {
                    System.out.println("Dealer's turn.");
                    System.out.println("Dealer's Hand: " + dealerHand);
                    suspense();


                    // Dealer keeps hitting until hand value is 18 or higher
                    while (dealerHand.getHandValue() < 17 || dealerHand.getHandValue() < playerHand.getHandValue()) {
                        dealerHand.addCard(playingDeck.draw());
                        System.out.println("Dealer hits.");
                        System.out.println("Dealer's Hand: " + dealerHand);
                        suspense();
                    }


                    // Dealer busts if over 21
                    if (dealerHand.getHandValue() > 21) {
                        System.out.println("Dealer busts! " + playerName + " wins.");
                        balance = balance + bet;
                    } else {
                        // Compare player and dealer hands to determine the winner
                        int playerHandValue = playerHand.getHandValue();
                        int dealerHandValue = dealerHand.getHandValue();

                        if (playerHandValue > dealerHandValue) {
                            System.out.println(playerName + " wins!");
                            balance = balance + bet;
                        } else if (playerHandValue < dealerHandValue) {
                            System.out.println("Dealer wins!");
                            balance = balance - bet;
                        } else {
                            System.out.println("It's a tie!");
                        }
                    }
                   gameIsOver = true;
                }
            }//gameIsOver loop ends

            playAnotherRound = playAgain(balance, scanner);

        } //while playround loop ends
        closingMessage(balance, originalValue);
    }



public static int getBetAmount (Scanner scanner) {
    int bet = 0;
    boolean betValue = true;

        System.out.println("Bets are 5, 10, 50, and 100");
        System.out.print("Place your bet: ");

        while (betValue) {
        bet = scanner.nextInt();
        if (bet == 5 || bet == 10 || bet == 50 || bet == 100) {
            betValue = false;
        } else {
            System.out.println("Invalid bet. Please enter 5, 10, 50, or 100.");
            System.out.print("Place your bet: ");
        }
    }

        return bet;
}


    public static boolean playAgain(int balance, Scanner scanner) {
        // After a round ends, ask if the user wants to play again
        System.out.println("Your current balance is now " + balance);
        System.out.println(" ");
        System.out.println("Do you want to play again? Yes/No");
        String playAgain = scanner.next().toLowerCase();
        System.out.println(" ");

        // Check user response
        if (playAgain.equals("yes")) {
            return true;
        } else if (playAgain.equals("no")) {
            return false;
        } else {
            System.out.println("Invalid input, please enter Yes or No");
            // Return the original value if the input is invalid
            return playAgain(balance, scanner);
        }
    }

    public static void closingMessage (int balance, int originalValue){

        System.out.println("You came in originally with $" + originalValue);

        int totalProfit = originalValue - balance;

        if (balance < 0) {
            System.out.println("Your account balance is negative: $" + balance);
            System.out.println("You reach into your pockets and realize you didn't bring your wallet.");
            System.out.println("Unfortunately, the police have been called.");
            System.out.println("Joking aside, please do not gamble more than what you can afford.");
        } else {
            System.out.println("Your account balance is: $" + balance);
//            System.out.println("You made a profit of: " + totalProfit);
        }
        System.out.println("Thank you for playing at Sher's Casino. Have a great day! ");
    }


    public static void suspense() {
        // Building the suspense..
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


















// Wished I could've added more lines from the psvm into methods to make it cleaner.
// why does this statement not work? I've added scanner after the int but it skips over it
//        System.out.println("Bets are 5, 10, 50, and 100");
//        System.out.print("Place your bet: ");
//        int bet = 0;
//        boolean betValue = true;
//
//        while (!betValue) {
//        bet = scanner.nextInt();
//        scanner.nextLine();
//        if (bet == 5 || bet == 10 || bet == 50 || bet == 100) {
//        betValue = true;
//        } else {
//        System.out.println("Invalid bet. Please enter 5, 10, 50, or 100.");
//        System.out.print("Place your bet: ");
//        }
//        }
//