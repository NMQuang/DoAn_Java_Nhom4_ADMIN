package foodGroup4Quanly.config;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil2 {

	private static final SessionFactory sessionFactory ;

	static {
		try {
		    // Create the SessionFactory from hibernate.cfg.xml
		    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
		    // Make sure you log the exception, as it might be swallowed
		    System.err.println("Initial SessionFactory creation failed." + ex);
		    throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}

}