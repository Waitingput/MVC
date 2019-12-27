package cn.pzhu.class1.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.class1.Bean.Car;
import service.CarService;
import service.CarServiceimp;
import util.pageUtil;

/**
 * Servlet implementation class SelectAllCar
 */
@WebServlet("/FuzzyCar")
public class FuzzyCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuzzyCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("str");
		CarService service = new CarServiceimp();
		ArrayList<Car> list = service.fuzzyquery(string);
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("showfuzzyCar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
