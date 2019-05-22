package com.example.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardEndPoint {

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;

    //@Autowired
    //CarDaoImpl cardDao;

    @RequestMapping("/cards")
    public Iterable<Card> cards() {
        return cardRepository.findAll();
    }


    @RequestMapping("/cards/search")
    public Iterable<Card> searchCards(@RequestParam(required = false) String type) {
        System.out.println("type="+type);

        return cardRepository.findAll();
    }

    @RequestMapping("/card")
    public Iterable<Card> card() {
        return cardService.getCardList();
    }

    @RequestMapping("/cards/add")
    public Card addCard(@RequestParam double bal){
        Card card = new Card(bal);
        return cardService.addCard(card);
    }




}
