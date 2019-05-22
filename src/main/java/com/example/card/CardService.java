package com.example.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CarDaoImpl carDao;

    public List<Card>getCardList(){ return carDao.getCards();}
    public Card addCard(Card card){ return carDao.addCard(card);}

    public void createCard(double balance){
        cardRepository.save(new Card(balance));
    }

    public void removeCard(int cardNo){
        cardRepository.deleteById(cardNo);
    }

    public void updateCard(int cardNo, double balance){
        cardRepository.save(new Card(cardNo,balance));
    }

    public double getCardBalance(int cardNo){
        return cardRepository.findById(cardNo).get().getBalance();
    }
}
