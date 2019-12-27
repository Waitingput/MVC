package cn.pzhu.class1.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.pzhu.class1.Bean.LoginService;
import cn.pzhu.class1.Bean.User;
import service.UserService;
import service.UserServiceImp;
import util.Conver2MD5;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")//注解路径，关联java-servlet(url)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String passwords = request.getParameter("password");
		String save = request.getParameter("save");
		
		
		//String password=Conver2MD5.getMD5(passwords);
		//进行必要的数据转换
		request.getSession().setAttribute("name",username);
		request.getSession().setAttribute("orgpwd", passwords);
		//进行数据封装
		//User user = new User(username,passwords);
		//进行数据处理
		UserService servise=new UserServiceImp();
		//定义变量接受工具类JavaBean的处理结果
		String db_passwd=servise.findpasswd(username);
		boolean flag=false;
		String time = (String)request.getSession().getAttribute("time");
		if(passwords.equalsIgnoreCase(Conver2MD5.getMD5(db_passwd+time)))
			flag=true;
		//Boolean flag = servise.login(user);
		if(flag){
			if(save != null){
				Cookie cookienmae = new Cookie("username", username);
				Cookie cookiepwd = new Cookie("password", passwords);
				Cookie cookiesave = new Cookie("save", save);
				cookienmae.setMaxAge(7*24*60*60);
				cookiepwd.setMaxAge(7*24*60*60);
				cookiesave.setMaxAge(7*24*60*60);
				response.addCookie(cookienmae);
				response.addCookie(cookiepwd);
				response.addCookie(cookiesave);
			}
			else{
				Cookie cookienmae = new Cookie("username", "");
				Cookie cookiepwd = new Cookie("password", "");
				Cookie cookiesave = new Cookie("save", "");
				cookienmae.setMaxAge(0);
				cookiepwd.setMaxAge(0);
				cookiesave.setMaxAge(0);
				response.addCookie(cookienmae);
				response.addCookie(cookiepwd);
				response.addCookie(cookiesave);
			}
			//保存必要信息（视图层需要的信息）username
			request.getSession().setAttribute("name",username);
			//通过请求转发重定向返回v视图层
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			response.sendRedirect("Error.jsp");
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
