// version 2
// resources used : https://www.youtube.com/watch?v=KHohVibqePw


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        Cars car= new Cars();
        car.setModel("Renault");
        car.setEngine(2.0);

        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();


    }


}
