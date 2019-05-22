package com.example.card;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue
    int cardNo;
    double balance;

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card() {
    }

    public Card(double balance) {
        this.balance = balance;
    }

    public Card(int cardNo, double balance) {
        this.cardNo = cardNo;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card : "+cardNo+" Bal : "+balance;
    }
}
