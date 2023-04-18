package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.MarksCard;

public class MarksCardDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public MarksCard find(int id) {
		return entityManager.find(MarksCard.class, id);
	}


	public void update(MarksCard card) {
		entityTransaction.begin();
		entityManager.merge(card);
		entityTransaction.commit();
	}
}
