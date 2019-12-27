package cn.pzhu.class1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import cn.pzhu.class1.Bean.LoginService;
import cn.pzhu.class1.Bean.User;
import service.UserService;
import service.UserServiceImp;
import util.Conver2MD5;

/**
 * Servlet implementation class Register
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				String username = request.getParameter("username");
				UserService service=new UserServiceImp();
				Boolean flag = service.findUser(username);
				PrintWriter out= response.getWriter();
				if(flag){
					out.print("此用户不可用");
				}else{
					out.print("此用户可用");
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
