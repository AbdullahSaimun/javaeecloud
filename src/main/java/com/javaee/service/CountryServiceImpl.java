package com.javaee.service;

import com.javaee.dao.CountryDAO;
import com.javaee.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryServiceImpl implements CountryService{

	private final CountryDAO countryDAO;

	public CountryServiceImpl(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	@Override
	public List<Country> findAll(String search, int offset, int recordPerPage) throws SQLException {
		return countryDAO.findAll(search,offset,recordPerPage);
	}

	@Override
	public boolean save(Country country) throws SQLException {
		return countryDAO.save(country);
	}

	@Override
	public boolean update(Country country) throws SQLException {
		return countryDAO.update(country);
	}

	@Override
	public boolean delete(int id) throws SQLException {
		return countryDAO.delete(id);
	}

	@Override
	public Country findById(int id) throws SQLException {
		return countryDAO.findById(id);
	}

	@Override
	public int count() throws SQLException {
		return countryDAO.count();
	}
}
