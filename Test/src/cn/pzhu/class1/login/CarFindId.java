package cn.pzhu.class1.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.class1.Bean.Car;
import cn.pzhu.class1.Bean.DealCar;
import generidao.CarDAOimp;
import service.CarService;
import service.CarServiceimp;

/**
 * Servlet implementation class CarFindId
 */
@WebServlet("/CarFindId")
public class CarFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarFindId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		Car car = new Car();
		Integer id=new DealCar().DealCar(sid);
		if(id!=0){
			CarService service = new CarServiceimp();
			car = service.idquery(id);
		}
		request.getSession().setAttribute("car", car);
		request.getRequestDispatcher("showidCar.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
