//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;
import java.util.Scanner;

// 2 players
// face
// no betting (yet)
// Aces = 1
// no splitting
public class Main {

    static int dealerTotal = 0;
    static ArrayList<Card> DealerCards = new ArrayList<Card>();
    static ArrayList<Card> PlayerCards = new ArrayList<Card>();
    static String optionsoptions = "x";
    static Scanner PlayerInput = new Scanner(System.in);
    static int cardDrawingIndex = (int) (Math.random() * 53); //0 to 52



    public static void main(String[] args) throws InterruptedException {

        Deck d = new Deck();


        for (var i = 0; i < d.drawableCards.size(); i++) {
            System.out.println(d.drawableCards.get(i).displayValue + " of " + d.drawableCards.get(i).suit);
        }

        System.out.println("The Dealer's first card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit);
        DealerCards.add(d.drawableCards.get(cardDrawingIndex));
        d.drawableCards.remove(cardDrawingIndex);
        cardDrawingIndex = (int) (Math.random() * d.drawableCards.size());
        Thread.sleep(1500);
        System.out.println("The Dealer's second card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit);
        DealerCards.add(d.drawableCards.get(cardDrawingIndex));
        d.drawableCards.remove(cardDrawingIndex);
        System.out.println("[DEALER TOTAL]\n" + (DealerCards.get(0).value + DealerCards.get(1).value + "\n\n\n"));

        cardDrawingIndex = (int) (Math.random() * d.drawableCards.size());
        Thread.sleep(1500);
        System.out.println("Your first card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit) ;
        PlayerCards.add(d.drawableCards.get(cardDrawingIndex));
        cardDrawingIndex = (int) (Math.random() * 10); //0 to 9
        Thread.sleep(1500);
        System.out.println("Your second card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit);
        PlayerCards.add(d.drawableCards.get(cardDrawingIndex));
        System.out.println("[PLAYER TOTAL]\n" + (PlayerCards.get(0).value + PlayerCards.get(1).value) + "\n\n");



        System.out.println("Would you like to hit or stand?");
        optionsoptions = PlayerInput.nextLine();

        for (; optionsoptions.equals("hit"); ) {

            System.out.println("Your current total is  " + playerTotalFunc());
            cardDrawingIndex = (int) (Math.random() * 10); //0 to 9
            Thread.sleep(500);
            System.out.println("Your new hit card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit);
            PlayerCards.add(d.drawableCards.get(cardDrawingIndex));
            Thread.sleep(500);
            System.out.println("[PLAYER TOTAL]\n" + (playerTotalFunc() + "\n\n"));

            if (playerTotalFunc() < 22) {
                System.out.println("Would you like to hit or stand?");
                optionsoptions = PlayerInput.nextLine();
            } else {
                optionsoptions = "bust";
            }
        }

        if (optionsoptions.equals("bust")) {
            Thread.sleep(500);
            System.out.println("Bust! Tough Luck! You were so close!");
            Thread.sleep(500);
            System.out.println("THE DEALER IS VICTORIOUS!");
        }


        if (optionsoptions.equals("stand")) {
            dealerTotal = dealerTotalFunc();
            for (; dealerTotal < 17; ) {
                System.out.println("[PLAYER TOTAL]\n" + (playerTotalFunc() + "\n\n"));
                System.out.println("[DEALER TOTAL]\n" + dealerTotal + "\n\n");
                System.out.println("The Dealer Hits Again!");
                cardDrawingIndex = (int) (Math.random() * 10); //0 to 9
                Thread.sleep(1500);
                System.out.println("Their new hit card is... a " + d.drawableCards.get(cardDrawingIndex).value + " of " + d.drawableCards.get(cardDrawingIndex).suit);
                DealerCards.add(d.drawableCards.get(cardDrawingIndex));
                dealerTotal = dealerTotalFunc();
                Thread.sleep(1500);
                System.out.println("[NEW DEALER TOTAL]\n" + (dealerTotalFunc()) + "\n\n\n");


            }

            if (dealerTotal > 21) { // dealer bust
                Thread.sleep(500);
                System.out.println("The Dealer Busts! Congratulations!");
                Thread.sleep(500);
                System.out.println("YOU WIN!!!");
            } else if (playerTotalFunc() > dealerTotalFunc()) {  // you score higher
                Thread.sleep(500);
                System.out.println("You scored higher than the dealer! NICE! Congratulations!");
                Thread.sleep(500);
                System.out.println("YOU WIN!!!");
            } else if (dealerTotalFunc() > playerTotalFunc()) {  //dealer higher
                Thread.sleep(500);
                System.out.println("OOF! Tough Luck! The dealer scored higher than you did!");
                Thread.sleep(500);
                System.out.println("THE DEALER IS VICTORIOUS!");
            } else if (dealerTotalFunc() == playerTotalFunc()) { //draw
                Thread.sleep(500);
                System.out.println("WHAAAAAAAAAAT!!! You and the Dealer have the same score!");
                Thread.sleep(500);
                System.out.println("DRAW!");
            }


        }


    }

    public static int playerTotalFunc() {
        int total = 0;
        for (var i = 0; i < PlayerCards.size(); i++) {
            total = PlayerCards.get(i).value + total;

        }
        return total;
    }

    public static int dealerTotalFunc() {
        int total = 0;
        for (var i = 0; i < DealerCards.size(); i++) {
            total = DealerCards.get(i).value + total;

        }

        return total;
    }


}