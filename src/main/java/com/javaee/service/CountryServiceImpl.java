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
	public List<Country> findAll(String search, int offset, int recordPerPage) {
		return countryDAO.findAll(search, offset, recordPerPage);
	}

	@Override
	public void save(Country country) {
		countryDAO.save(country);
	}

	@Override
	public void update(Country country) {
		countryDAO.update(country);
	}

	@Override
	public void delete(int id) {
		countryDAO.delete(id);
	}

	@Override
	public Country findById(int id) {
		return countryDAO.findById(id);
	}

	@Override
	public int count(String search) {
		return countryDAO.count(search);
	}
}
