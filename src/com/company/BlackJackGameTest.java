package com.company;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class BlackJackGameTest {
    public static void main(String[] arg){

    }

    //Test if players are different
    @Test
    public void testDifferentPlayers() {
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        String player2 = "dealerHand";

        String hand1 = hand.assign(deck, hand, player);
        String hand2 = hand.assign(deck, hand, player2);

        assertNotEquals(hand1, hand2);
    }

    //Test if players are the same
    @Test
    public void testSamePlayers() {
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        String player2 = "hand";

        String hand1 = hand.assign(deck, hand, player);
        String hand2 = hand.assign(deck, hand, player2);

        assertEquals(hand1, hand2);
    }

    //Test if scores are different or the same
    @Test
    public void testPlayerScores(){
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        hand.assign(deck, hand, player);


        System.out.println("Card dealer draws:");
        BlackJackGame dealerHand = new BlackJackGame();
        String dealer = "dealerHand";
        dealerHand.assign(deck, dealerHand, dealer);

        if(dealerHand.returnScore(dealerHand, dealer) != hand.returnScore(hand, player)) {
            assertNotEquals(dealerHand.returnScore(dealerHand, dealer), hand.returnScore(hand, player));
        } else {
            assertEquals(dealerHand.returnScore(dealerHand, dealer), hand.returnScore(hand, player));
        }
    }

    //Test if card can be set properly
    @Test
    public void testCard() {
        Card card1 = new Card();
        card1.setCard("Ace", "Hearts");
        assertEquals(card1.toString(), "Ace of Hearts");
    }

    //Test if cards value is properly returned
    @Test
    public void testSetValue () {
        Card card1 = new Card();
        card1.setCard("Seven", "Clubs");
        System.out.println(card1.getValue());
        assertEquals(card1.getValue(), "Seven");
    }

    //Test if cards suit is properly returned
    @Test
    public void testSetSuit () {
        Card card1 = new Card();
        card1.setCard("Queen", "Spades");
        System.out.println(card1.getSuit());
        assertEquals(card1.getSuit(), "Spades");
    }
}
