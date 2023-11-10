package UnivServices;

import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//This class manages the Hibernate session factory, which provides database connections and handles sessions
public class HibernateUtil {
	// Builds the session factory based on the Hibernate configuration
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Configuration configuration = new Configuration();
			// return configuration.buildSessionFactory(new
			// StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
			
			 // Builds the session factory using the Hibernate configuration file 'hibernate.cfg.xml'
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata mdata = new MetadataSources(ssr).getMetadataBuilder().build();
			return mdata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("An error occurred in the construction of the Session Factory.");
		}
	}// end of buildSessionFactory

	// Retrieves the session factory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
