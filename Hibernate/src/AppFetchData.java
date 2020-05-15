import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AppFetchData {
    public static void main(String[] args) {

        Configuration conf= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cars.class);
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sf= conf.buildSessionFactory(builder.build());
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();

        // Extract the row where id=1
//          Cars car_byID=(Cars) session.get(Cars.class,1);
//          System.out.println(car_byID);

        // Extract row by row , ALL TABLE
//          Query q1=session.createQuery("from Cars");
//          List<Cars> c=q1.list();
//          for(Cars row:c) System.out.println(row);

        //Select where condtion
//          Query q2=session.createQuery("from Cars where model like 'dacia' ");
//          List<Cars> b=q2.list();
//          System.out.println(b);

        // We can interpolate a variable in the query
//          Query q =session.createQuery("select sum(id) from Cars c where c.id>10");
//          Long idSUm=(Long) q.uniqueResult();
//          System.out.println(idSUm);

        //SQL Proper usage  also called Native queries
//        SQLQuery query=session.createSQLQuery("select * from cars");
//        query.addEntity(Cars.class);
//        List cars= query.list();
//        for (Object c:cars) {
//            System.out.println(c);
//        }
        
         // Extract Some of the columns usingS SQL
           SQLQuery query2=session.createSQLQuery("select model,engine from cars");
           query2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
           List cars= query2.list();
           for (Object c:cars) {
               Map m=(Map)c;                      // With map from java.util
               System.out.println(m.get("model")+" : "+m.get("engine"));
           }
        

        tx.commit();
        sf.close();

    }

}
