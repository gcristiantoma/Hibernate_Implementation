// Version 1 full hibernet solution
// resource used : https://www.youtube.com/watch?v=JR7-EdxDSf0

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Random;

public class AppInsertData {

    public static void main(String[] args) {


        Configuration conf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cars.class);


        // New Version - it works well
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sf= conf.buildSessionFactory(builder.build());
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        // Insert into the table using Objects from the class
//        Cars car= new Cars();
//        car.setModel("Tak");
//        car.setEngine(0.5);
//        session.save(car);

        // Insert some more data using random
        Random r= new Random();
        for (int i = 0; i <50 ; i++) {
            Cars c= new Cars();
            c.setId(i+14);
            c.setModel("Model"+i);
            c.setEngine(0.5+(5-0.5)*r.nextDouble());
            session.save(c);
        }


        tx.commit();
        sf.close();

    }


}
