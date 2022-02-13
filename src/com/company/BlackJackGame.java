package com.company;
import java.util.Random;

public class BlackJackGame {
    private Card[] cards;
    private int cardLeft;
    private int playerCounter=0;
    private int playerIndex=0;
    private int dealerCounter=0;
    private int dealerIndex=0;


    public int getCardLeft(){
        return cardLeft;
    }

    public BlackJackGame(){
        cardLeft = 0;
        String[] suit = {"Hearts","Spades","Clubs","Diamonds"};
        String[] value = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        cards = new Card[suit.length * value.length];

        for(int i=0; i < suit.length; i++) {
            for (int k = 0; k < value.length; k++) {
                cards[cardLeft] = new Card(suit[i], value[k]);
                cardLeft++;
            }
        }
    }

    public void setCards(int index, String s,String f){
        if(index>=0 && index < cards.length) {
            cards[index].setCard(s, f);
        }
    }

    public void shuffle(){
        Random rand = new Random();
        int r1, r2;
        for(int i =0; i<cardLeft/2;){
            r1 = rand.nextInt(cardLeft);
            r2 = rand.nextInt(cardLeft);

            if(r1 != r2){
                Card holder = cards[r1];
                cards[r1] = cards[r2];
                cards[r2] = holder;
                i++;
            }
        }
    }

    public int Score(int x){
        int score = 0;
        for(int i=0; i<x; i++){
            if(cards[i].getValue().equals("Ace"))
                score+=1;
            else if(cards[i].getValue().equals("Two"))
                score+=2;
            else if(cards[i].getValue().equals("Three"))
                score+=3;
            else if(cards[i].getValue().equals("Four"))
                score+=4;
            else if(cards[i].getValue().equals("Five"))
                score+=5;
            else if(cards[i].getValue().equals("Six"))
                score+=6;
            else if(cards[i].getValue().equals("Seven"))
                score+=7;
            else if(cards[i].getValue().equals("Eight"))
                score+=8;
            else if(cards[i].getValue().equals("Nine"))
                score+=9;
            else
                score+=10;
        }
        return score;
    }

    public Card deal(){
        cardLeft--;
        return cards[cardLeft];
    }

    public void assign(BlackJackGame deck, BlackJackGame hand, String type){
        if(type=="hand"){
            playerCounter++;
            Card card = deck.deal();
            hand.setCards(playerIndex, card.getSuit(), card.getValue());
            System.out.println(card);

            System.out.println("Score of Hand: " + hand.Score(playerCounter));
            checkBlackJack(hand.Score(playerCounter));
            System.out.println();
            playerIndex++;
        }
        else if(type=="dealerHand"){
            dealerCounter++;
            Card card = deck.deal();
            hand.setCards(dealerIndex, card.getSuit(), card.getValue());
            System.out.println(card);
            System.out.println("Score of Dealer's Hand: " + hand.Score(dealerCounter));

            System.out.println();
            dealerIndex++;
        }
    }

    public void checkBlackJack(int x){
        if(x==21){
            System.out.println("You win!");
            System.exit(0);
        }
        if(x>21){
            System.out.println("You Lose!");
            System.exit(0);
        }
    }

    public int returnScore(BlackJackGame hand, String type){
        int h=0;
        if(type=="hand"){
            h = hand.Score(playerCounter);
        }
        else if(type=="dealerHand"){
            h = hand.Score(dealerCounter);
        }
        return h;
    }
}
