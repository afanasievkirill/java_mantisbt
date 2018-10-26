package ru.home.pft.mantisbt.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.home.pft.mantisbt.model.UserData;
import ru.home.pft.mantisbt.model.Users;

import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;


  public DbHelper() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

  public void refresh(Object o){
    Session session = sessionFactory.openSession();
    session.refresh(o);
    session.close();
  }
}

