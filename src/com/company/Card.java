package com.company;

public class Card {
    private String suit;
    private String value;

    public Card() {

    }

    public String getSuit(){
        return suit;
    }

    public String getValue(){
        return value;
    }

    public Card(String value,String suit){
        this.suit = suit;
        this.value = value;
    }

    public void setCard(String value,String suit){
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        String name = value + " of " + suit;
        return name;
    }
}
