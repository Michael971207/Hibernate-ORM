import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDao {

  private SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(User.class)
      .buildSessionFactory();

  public void save(User user) {
    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();
    }
  }

}


