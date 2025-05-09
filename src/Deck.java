import java.util.ArrayList;

public class Deck {
  ArrayList<String> cardSuitHolderSwitcherThing = new ArrayList<String>();
  int cardSuitSwitcher = 0;
 ArrayList<Card> drawableCards = new ArrayList<>();
    ArrayList<Card> fullDeck = new ArrayList<Card>();





    public Deck(){



             cardSuitHolderSwitcherThing.add("❤️");
             cardSuitHolderSwitcherThing.add("♠️");
             cardSuitHolderSwitcherThing.add("♦️");
             cardSuitHolderSwitcherThing.add("♣️");


             for (int k = 0; k < 4; k++) {


                 for (var i = 1; i < 14; i++) {
                     if (i == 1) {
                         Card c = new Card(i, cardSuitHolderSwitcherThing.get(cardSuitSwitcher), "Ace");
                         drawableCards.add(c);

                     }

                     if (i > 1 && i < 11) {
                         Card c = new Card(i, cardSuitHolderSwitcherThing.get(cardSuitSwitcher), String.valueOf(i));
                         drawableCards.add(c);

                     }

                     if (i == 11) {
                         Card c = new Card(i, cardSuitHolderSwitcherThing.get(cardSuitSwitcher), "Jack");
                         drawableCards.add(c);

                     }

                     if (i == 12) {
                         Card c = new Card(i, cardSuitHolderSwitcherThing.get(cardSuitSwitcher), "Queen");
                         drawableCards.add(c);

                     }

                     if (i == 13) {
                         Card c = new Card(i, cardSuitHolderSwitcherThing.get(cardSuitSwitcher), "King");
                         drawableCards.add(c);

                     }


                 }
                 cardSuitSwitcher = cardSuitSwitcher + 1;
             }


        for (var i = 0; i < drawableCards.size(); i++) {
            System.out.println(drawableCards.get(i).displayValue + " of " + drawableCards.get(i).suit);
        }



        }

        public Card draw (){

            int cardDrawingIndex = (int) (Math.random() * drawableCards.size() + 1);
            System.out.println("The [entity] draws a " + drawableCards.get(cardDrawingIndex).value);
            Card returnValue = drawableCards.get(cardDrawingIndex);
            drawableCards.remove(cardDrawingIndex);
            return returnValue;
        }

    }
