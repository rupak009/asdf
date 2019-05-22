package com.example.card;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface CardDao {
    public List<Card> getCards();

    public Card addCard(Card card);
}

@Repository
class CarDaoImpl implements CardDao {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Card> getCards() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from Card c");
        List<Card> resultList = query.getResultList();
        return resultList;
    }
    @Transactional
    public Card addCard(Card card) throws DataAccessException {
        getEntityManager().persist(card);
        return card;
    }
}
