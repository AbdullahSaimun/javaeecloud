package com.javaee.controller;

import com.javaee.dao.CountryDAO;
import com.javaee.dao.CountryDAOImpl;
import com.javaee.entity.Country;
import com.javaee.service.CountryService;
import com.javaee.service.CountryServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/details")
public class DetailsController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	private CountryService countryService;

	public DetailsController() {
	}

	@Override
	public void init() {
		CountryDAO countryDAO = new CountryDAOImpl();
		countryService = new CountryServiceImpl(countryDAO);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int countryId = Integer.parseInt(request.getParameter("countryId"));
			Country country = countryService.findById(countryId);
			request.setAttribute("country", country);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		request.setAttribute("details", "Details Page");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/details.jsp");
		requestDispatcher.forward(request,response);
	}
}
