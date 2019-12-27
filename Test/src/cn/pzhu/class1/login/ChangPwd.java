package cn.pzhu.class1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.pzhu.class1.Bean.User;
import service.UserService;
import service.UserServiceImp;
import util.Conver2MD5;

/**
 * Servlet implementation class ChangPwd
 */
@WebServlet("/ChangPwd")
public class ChangPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name= (String)request.getSession().getAttribute("name");
		String oldpwd=request.getParameter("oldpwd");
		String pwd=request.getParameter("pwd");
		String time = (String)request.getSession().getAttribute("time");
		
		pwd = Conver2MD5.getMD5(pwd);//加密
		//oldpwd=Conver2MD5.getMD5(oldpwd).toLowerCase();
		User user = new User(name,pwd);
		UserService service=new UserServiceImp();
		boolean flag = service.changePwd(user);
		PrintWriter out = response.getWriter();
		if(oldpwd.equals(request.getSession().getAttribute("orgpwd"))){
			if(flag){
				 request.getSession().invalidate();
				 out.print("<script>alert('密码修改成功！返回登录');window.location.href='index.jsp'</script>");
			}
			else {
				out.print("<script>alert('修改失败');window.location.href='ChangePwd.jsp'</script>");
			}
		}else {
			out.print("<script>alert('修改失败,密码错误！');window.location.href='ChangePwd.jsp'</script>");
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
