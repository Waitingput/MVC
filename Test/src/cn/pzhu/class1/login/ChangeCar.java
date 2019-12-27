package cn.pzhu.class1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.class1.Bean.Car;
import cn.pzhu.class1.Bean.DealCar;
import service.CarService;
import service.CarServiceimp;

/**
 * Servlet implementation class ChangeCar
 */
@WebServlet("/ChangeCar")
public class ChangeCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String price=request.getParameter("price");
		Car car=new Car();
		PrintWriter out = response.getWriter();
		boolean flag1=new DealCar().DealCar(id, name, type, price, car);
		if(flag1){
			CarService service = new CarServiceimp();
			boolean flag2=service.updataCar(car);
			if(flag2){
				 out.print("<script>alert('添加成功！返回显示页面');window.location.href='SelectAllCar'</script>");
			}else{
				out.print("<script >alert('数据冲突！添加失败');window.location.href='ChangeCar.jsp?id="+id+"&name="+name+"&type="+type+"&price="+price+"'</script>");
			}
		}
		else{
			out.print("<script >alert('数据错误！添加失败');window.location.href='ChangeCar.jsp?id="+id+"&name="+name+"&type="+type+"&price="+price+"'</script>");
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
