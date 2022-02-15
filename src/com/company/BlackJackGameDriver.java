package com.company;
import java.util.Scanner;

public class BlackJackGameDriver {
    public static void main(String[] args) {
        //import scanner library to a variable to allow for user input
        Scanner decision = new Scanner(System.in);
        //initialize variable to count player hit times
        int playerHitTimes=0;

        //print introductory messages
        System.out.println("Welcome To BlackJack");
        System.out.println("The Rules are as follows:");
        System.out.println("  -The player is dealt 2 cards. The dealer is dealt 2 cards one face up and other face down");
        System.out.println("  -Each card is equal to the face value and with Ace being 1");
        System.out.println("  -The goal is to get the closest to 21 without going over");
        System.out.println("  -The player is able to hit as much as they like but going over 21 is instant lose and loss of bet");

        //inform player that deck has been shuffled
        System.out.println("The deck has been shuffled");
        BlackJackGame deck = new BlackJackGame();
        deck.shuffle();

        //automatically draw card for player
        System.out.println("Card you draw:");
        BlackJackGame hand = new BlackJackGame();
        String player = "hand";
        hand.assign(deck, hand, player);

        //automatically draw card for dealer
        System.out.println("Card dealer draws:");
        BlackJackGame dealerHand = new BlackJackGame();
        String dealer = "dealerHand";
        dealerHand.assign(deck, dealerHand, dealer);

        //automatically draw second card for player
        System.out.println("Card you draw:");
        hand.assign(deck, hand, player);

        System.out.println("Dealer has one face down card");
        playerHitTimes++;
        System.out.println("Would you like to hit for another card enter y or n");
        //store players decision in answer variable
        String answer = decision.next();

        //continue to ask player for their choice and only exit till answer is n
        if(answer.equals("y")) {
            do {
                System.out.println("Card you draw:");
                hand.assign(deck, hand, player);
                playerHitTimes++;
                System.out.println("Would you like to hit for another card enter y or n");
                answer = decision.next();
            } while (!answer.equals("n"));
        }

        //dealer reveals the card drawn earlier
        System.out.println("Dealer reveals his cards");
        dealerHand.assign(deck, dealerHand, dealer);

        //deal will make  player hit amount if the dealer score is less than 17
        //17 is a uniform number used by alot of blackjack games
        for(int i=0; i<playerHitTimes; i++){
            if(dealerHand.returnScore(dealerHand, dealer)<17) {
                System.out.println("Card dealer draws:");
                dealerHand.assign(deck, dealerHand, dealer);
            }
        }

        //win conditions
        //if dealer hand is higher than player and less than 21, dealer wins
        if(dealerHand.returnScore(dealerHand, dealer)>hand.returnScore(hand, player)&&dealerHand.returnScore(dealerHand, dealer)<=21) {
            System.out.println("You Lose!");
        }
        //if player hand is higher than dealer and less than 21, player wins
        else if(hand.returnScore(hand, player)> dealerHand.returnScore(dealerHand, dealer) && hand.returnScore(hand, player)<= 21 ){
            System.out.println("You Win!");
        }
        //if dealer has higher than 21, player wins
        else if(dealerHand.returnScore(dealerHand, dealer)>21){
            System.out.println("You Win!");
        }
        //if the scores are the same, player and dealer tie
        else{
            System.out.println("Tied!");
        }
    }
}
