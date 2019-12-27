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
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理必要头信心（编码）
				//request.setCharacterEncoding("utf-8");
				//接受v参数
				response.setContentType("text/html;charset=utf-8");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String code = request.getParameter("checkcode");
				String scode = (String)request.getSession().getAttribute("code");
				PrintWriter out= response.getWriter();
				if(code!=null&&code.contentEquals(scode)){
					password = Conver2MD5.getMD5(password);
					User user = new User(username,password);
					UserService service=new UserServiceImp();
					Boolean flag = service.regist(user);
					if(flag){
						out.print("<script>alert('注册成功，返回登陆');window.location.href='index.jsp'</script>");
						//request.getRequestDispatcher("index.jsp").forward(request, response);
					}else{
						out.print("<script>alert('注册失败，重新注册');window.location.href='Register.jsp'</script>");
						//response.sendRedirect("index.jsp");
					}
				}else{
					out.print("<script>alert('验证码输入错误');window.location.href='Register.jsp'</script>");
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
