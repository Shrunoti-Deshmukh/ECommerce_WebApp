package com.ecommerece.controller;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.tools.javac.util.List;
import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.exception.UserIdNotFoundException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;
 
/**
* Servlet implementation class RegisterServlet
*/
@WebServlet(urlPatterns = "/register", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/registerPage.jsp");
		dispatcher.forward(request, response);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println("apple");
 
		User user = new User();
		String userId = req.getParameter("userId");
		if (userId.isEmpty()) {
			// somthing
		} else {
			try {
				user.setUserId(userId);
			} catch (InvalidUserIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
		String userEmail = req.getParameter("email");
		if (userEmail.isEmpty()) {
			// somthing
		} else {
			user.setEmail(userEmail);
		}
 
		String userPassword = req.getParameter("password");
		if (userPassword.isEmpty()) {
			// somthing
		} else {
			user.setPassword(userPassword);
		}
 
		UserService userService = UserServiceImpl.getInstanve();
		ProductService productService = ProductServiceImpl.getInstance();
 
		User user2 = null;
		try {
			user2 = userService.addUser(user);
			System.out.println(user2);
			if (user2 != null) {
				ArrayList<Product> productList = new ArrayList<Product>();
				productList = (ArrayList<Product>) productService.getProducts();
				System.out.println("ProductLIST : "+productList);
				
				ServletContext servletContext = req.getServletContext();
				servletContext.setAttribute("productList", productList);
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("user", user2);
//				httpSession.setAttribute("productList", productList);
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");
				dispatcher.forward(req, resp);
			}
 
		} catch (SQLException | DataNotFoundException | InvalidIdException | InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
 
}