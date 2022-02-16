package edu.ycp.cs320.lab02a.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a.controller.NumbersController;
import edu.ycp.cs320.lab02a.model.Numbers;

public class AddNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("AddNumbers Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("AddNumbers Servlet: doPost");
		
		// setting numbers model
		Numbers model = new Numbers();
		
		// setting controller model
		System.out.println("\tSetting numbers model");
		NumbersController controller = new NumbersController();
		
		controller.setModel(model);

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		Double result = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));
			Double third = getDoubleFromParameter(req.getParameter("third"));
			
			System.out.println("\tSending parameters to model");
			// Sets first second and third numbers in model 
			model.setFirst(first);
			model.setSecond(second);
			model.setThrid(third);

			// check for errors in the form data before using is in a calculation
			if (first == null || second == null || third == null) {
				errorMessage = "Please specify three numbers";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {

				result = controller.add();
				
				System.out.println("\tCalculating result and sending it to model");
				model.setResult(result);
			}
		} catch (NumberFormatException e) {
			String firstS = req.getParameter("first");
			String secondS = req.getParameter("second");
			String thirdS = req.getParameter("third");
			
			model.setFirstString(firstS);
			model.setSecondString(secondS);
			model.setThridString(thirdS);
			errorMessage = "Invalid double"; // its not a bug, its an undocumented feature
		}
		
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		System.out.println("\tPosting AddNumbers results");
		req.setAttribute("result", model.getResult());
		
		req.setAttribute("add", model);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
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
