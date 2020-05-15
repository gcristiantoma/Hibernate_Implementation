import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class AppFetchData {
    public static void main(String[] args) {

        Configuration conf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cars.class);
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sf= conf.buildSessionFactory(builder.build());
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        // Extract the row where id=1
//        for (int i = 0; i < 10; i++) {
//            Cars check_car=(Cars) session.get(Cars.class,i);
//            System.out.println(check_car);
//        }

        tx.commit();
        sf.close();

    }

}
