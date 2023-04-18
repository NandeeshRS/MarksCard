package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;
import dto.Teacher;

public class TeacherDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void Teacher1(Teacher teacher){
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
	}

	public Teacher find(String email) {
		List<Teacher> list=entityManager.createQuery("select x from Teacher x where email=?1").setParameter(1, email)
				.getResultList();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	public Teacher find(int empid) {
		return entityManager.find(Teacher.class, empid);
	}

	public Teacher find(long mobile) {
		List<Teacher> list=entityManager.createQuery("select x from Teacher x where p_no=?1").setParameter(1, mobile)
				.getResultList();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	

}


