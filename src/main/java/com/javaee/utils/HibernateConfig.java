package com.javaee.utils;

import com.javaee.entity.Country;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HibernateConfig {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(Country.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("Error initializing Hibernate: " + e.getMessage());
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getSession() {
		if (sessionFactory == null) {
			throw new HibernateException("SessionFactory is not initialized!");
		}
		return sessionFactory.openSession();
	}
}
