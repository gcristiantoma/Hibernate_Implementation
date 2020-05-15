// Version 1
// resource used : https://www.youtube.com/watch?v=JR7-EdxDSf0

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppInsertData {

    public static void main(String[] args) {
        Cars car= new Cars();
        car.setModel("Tak");
        car.setEngine(0.5);

        Configuration conf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cars.class);

        // Depracated version
//        SessionFactory sf= conf.buildSessionFactory();

        // New Version - it works well
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(
                conf.getProperties());

        SessionFactory sf= conf.buildSessionFactory(builder.build());

        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(car);
        tx.commit();
        sf.close();

    }


}
