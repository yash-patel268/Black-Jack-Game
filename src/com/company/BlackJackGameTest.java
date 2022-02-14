package com.company;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BlackJackGameTest {
    public static void main(String[] arg){

    }

    //Test if players are different
    @Test
    public void testPlayers() {
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        System.out.println("Card you draw:");
        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        String player2 = "dealerHand";

        String hand1 = hand.assign(deck, hand, player);
        String hand2 = hand.assign(deck, hand, player2);

        assertNotEquals(hand1, hand2);
    }

    //Test if scores are different
    @Test
    public void testScores(){
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        hand.assign(deck, hand, player);


        System.out.println("Card dealer draws:");
        BlackJackGame dealerHand = new BlackJackGame();
        String dealer = "dealerHand";
        dealerHand.assign(deck, dealerHand, dealer);
        assertNotEquals(dealerHand.returnScore(dealerHand, dealer), hand.returnScore(hand, player));
    }
}
