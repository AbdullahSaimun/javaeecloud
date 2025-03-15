package com.javaee.dao;

import com.javaee.entity.Country;
import com.javaee.utils.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> findAll(String search, int offset, int recordPerPage) {
		Session session = HibernateConfig.getSession();
		String searchPattern = "%"+search+"%";
		String SQL = "SELECT c FROM Country c WHERE c.name LIKE :searchName OR c.continent LIKE :searchContinent ORDER BY c.countryId ASC";
		return session.createQuery(SQL, Country.class)
				.setParameter("searchName", searchPattern )
				.setParameter("searchContinent", searchPattern)
				.setFirstResult(offset)
				.setMaxResults(recordPerPage)
				.getResultList();
	}

	@Override
	public void save(Country country) {
		Session session = HibernateConfig.getSession();
		session.getTransaction().begin();
		session.persist(country);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void update(Country country) {
		Session session = HibernateConfig.getSession();
		session.getTransaction().begin();
		session.merge(country);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = HibernateConfig.getSession();
		Country country = session.find(Country.class, id);
		session.getTransaction().begin();
		session.remove(country);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Country findById(int id) {
		Session session = HibernateConfig.getSession();
		return session.find(Country.class, id);
	}

	@Override
	public int count(String search) {
		Session session = HibernateConfig.getSession();
		String SQL = "SELECT COUNT(c) FROM Country c WHERE c.name LIKE :searchName OR c.continent LIKE :searchContinent";
		return session.createQuery(SQL, Long.class)
				.setParameter("searchName", "%" + search + "%")
				.setParameter("searchContinent", "%" + search + "%")
				.getSingleResult().intValue();
	}
}
