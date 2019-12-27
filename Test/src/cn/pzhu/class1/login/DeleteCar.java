package cn.pzhu.class1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarService;
import service.CarServiceimp;

/**
 * Servlet implementation class DeleteCar
 */
@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sid= request.getParameter("id");
		int id= Integer.parseInt(sid);
		CarService service=new CarServiceimp();
		boolean flag=service.deleteCar(id);
		PrintWriter out = response.getWriter();
		if(flag){
			out.print("<script>alert('删除成功！返回显示页面');window.location.href='SelectAllCar';</script>");
		}else{
			out.print("<script>alert('删除失败！返回显示页面');window.location.href='SelectAllCar';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
