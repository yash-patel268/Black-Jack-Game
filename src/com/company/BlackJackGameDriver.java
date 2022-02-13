package com.company;
import java.util.Scanner;

public class BlackJackGameDriver {
    public static void main(String[] args) {
        Scanner decision = new Scanner(System.in);
        int playerHitTimes=0;

        System.out.println("Welcome To BlackJack");
        System.out.println("The Rules are as follows:");
        System.out.println("  -The player is dealt 2 cards. The dealer is dealt 2 cards one face up and other face down");
        System.out.println("  -Each card is equal to the face value and with Ace being 1");
        System.out.println("  -The goal is to get the closest to 21 without going over");
        System.out.println("  -The player is able to hit as much as they like but going over 21 is instant lose and loss of bet");

        System.out.println("The deck has been shuffled");
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        System.out.println("Card you draw:");
        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        hand.assign(deck, hand, player);


        System.out.println("Card dealer draws:");
        BlackJackGame dealerHand = new BlackJackGame();
        String dealer = "dealerHand";
        dealerHand.assign(deck, dealerHand, dealer);

        System.out.println("Card you draw:");
        hand.assign(deck, hand, player);

        System.out.println("Dealer has one face down card");
        playerHitTimes++;
        System.out.println("Would you like to hit for another card enter y or n");
        String answer = decision.next();

        if(answer.equals("y")) {
            do {
                System.out.println("Card you draw:");
                hand.assign(deck, hand, player);
                playerHitTimes++;
                System.out.println("Would you like to hit for another card enter y or n");
                answer = decision.next();
            } while (!answer.equals("n"));
        }

        System.out.println("Dealer reveals his cards");
        dealerHand.assign(deck, dealerHand, dealer);

        for(int i=0; i<playerHitTimes; i++){
            if(dealerHand.returnScore(dealerHand, dealer)<17) {
                System.out.println("Card dealer draws:");
                dealerHand.assign(deck, dealerHand, dealer);
            }
        }

        if(dealerHand.returnScore(dealerHand, dealer)>hand.returnScore(hand, player)&&dealerHand.returnScore(dealerHand, dealer)<=21) {
            System.out.println("You Lose!");
        }
        else if(hand.returnScore(hand, player)> dealerHand.returnScore(dealerHand, dealer) && hand.returnScore(hand, player)<= 21 ){
            System.out.println("You Win!");
        }
        else if (dealerHand.returnScore(dealerHand, dealer)>21){
            System.out.println("You Win!");
        }
        else{
            System.out.println("Tied!");
        }
    }
}
