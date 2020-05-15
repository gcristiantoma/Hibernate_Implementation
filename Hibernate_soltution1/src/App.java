// Version 1
// resource used : https://www.youtube.com/watch?v=JR7-EdxDSf0

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        Cars car= new Cars();
        car.setModel("Lada");
        car.setEngine(1.0);

        Configuration conf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cars.class);
        SessionFactory sf= conf.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(car);
        tx.commit();
        sf.close();

    }


}
