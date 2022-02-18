package edu.ycp.cs320.lab02a_bsimmons1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a_bsimmons1.controller.NumbersController;
import edu.ycp.cs320.lab02a_bsimmons1.model.Numbers;

public class MultiplyNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("MultiplyNumbers Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("MultiplyNumbers Servlet: doPost");

		// holds the error message text, if there is any
		String errorMessage = null;
		
		// creates a numbers model
		System.out.println("\tSetting numbers model");
		Numbers model = new Numbers();
		
		// creates a controller
		NumbersController controller = new NumbersController();
		
		// sets model in controller
		controller.setModel(model);

		// result of calculation goes here
		Double result = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));
			
			// setting first and second variables to model
			System.out.println("\tSending parameters to model");
			model.setFirst(first);
			model.setSecond(second);

			// check for errors in the form data before using is in a calculation
			if (first == null || second == null) {
				errorMessage = "Please specify two numbers";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {

				result = controller.multiply();
				// set result in model
				System.out.println("\tCalculating result and sending it to model");
				model.setResult(result);
			}
		} catch (NumberFormatException e) {
			System.out.println("Setting Error");
			errorMessage = "Invalid double";
		}
		
		req.setAttribute("first", req.getParameter("first"));
		req.setAttribute("second", req.getParameter("second"));
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		System.out.println("\tPosting MultiplyNumbers results");
		req.setAttribute("result", model.getResult());
		
		req.setAttribute("multiply", model);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
