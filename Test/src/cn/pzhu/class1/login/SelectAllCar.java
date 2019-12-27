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
@WebServlet("/SelectAllCar")
public class SelectAllCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarService service = new CarServiceimp();
		ArrayList<Car> list = service.showAllcar();
		//接收控制层传递过来的参数
		String spage= request.getParameter("page");
		String snum= request.getParameter("num");
		int page=1;
		int num=5;
		try {
			page=Integer.parseInt(spage);
			if(page<1){
				throw new Exception();
			}
		} catch (Exception e) {
			page=1;
		}
		try {
			num=Integer.parseInt(snum);
			if(num<1){
				throw new Exception();
			}
		} catch (Exception e) {
			num=10;
		}
		//希望得到导航条,交给m
		StringBuffer bar=pageUtil.creatBar(list,page,num);//m产生
		request.getSession().setAttribute("bar",bar);
		
		//分页处理，拆分list
		list=pageUtil.pageCars(list, page,num);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("num", num);
		request.getRequestDispatcher("showinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
