package com.javaee.dao;

import com.javaee.entity.Country;
import com.javaee.utils.DatabaseConfig;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CountryDAOImpl implements CountryDAO {

	@Override
	public List<Country> findAll(String search, int offset, int recordPerPage) throws SQLException{
		List<Country> countries = new ArrayList<>();
		Connection connection = DatabaseConfig.getConnection();
		String SQL = "SELECT * FROM country WHERE name LIKE ? OR continent LIKE ? ORDER BY country_id ASC LIMIT ?,?";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setString(1, "%"+search+"%");
		preparedStatement.setString(2, "%"+search+"%");
		preparedStatement.setInt(3, offset);
		preparedStatement.setInt(4, recordPerPage);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Country country = Country.builder()
					.countryId(resultSet.getInt("country_id"))
					.name(resultSet.getString("name"))
					.continent(resultSet.getString("continent"))
					.build();
			countries.add(country);

		}
		return countries;
	}

	@Override
	public boolean save(Country country) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConfig.getConnection();
			String SQL = "INSERT INTO country(name, continent) VALUES(?, ?)";
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, country.getName());
			preparedStatement.setString(2, country.getContinent());

			return preparedStatement.executeUpdate() > 0;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}


	@Override
	public boolean update(Country country) throws SQLException {
		Connection connection = DatabaseConfig.getConnection();
		String SQL = "UPDATE country SET name = ?, continent = ? WHERE country_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setString(1, country.getName());
		preparedStatement.setString(2, country.getContinent());
		preparedStatement.setInt(3, country.getCountryId());
		return preparedStatement.executeUpdate() > 0;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		Connection connection = DatabaseConfig.getConnection();
		String SQL = "DELETE FROM country WHERE country_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate() > 0;
	}


	@Override
	public Country findById(int id) throws SQLException {
		Country country = null;
		Connection connection = DatabaseConfig.getConnection();
		String SQL = "SELECT * FROM country WHERE country_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			int countryId = resultSet.getInt("country_id");
			String name = resultSet.getString("name");
			String continent = resultSet.getString("continent");
			country = new Country(countryId, name, continent);
		}
		return country;
	}

	@Override
	public int count() throws SQLException {
		int count = 0;
		Connection connection = DatabaseConfig.getConnection();
		String SQL = "SELECT COUNT(*) AS total FROM country";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			count = resultSet.getInt("total");
		}
		return count;
	}
}
