package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;


public class LoginActionController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NewMember newmember = null;
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		NewMemberMybatisDao dao  = NewMemberMybatisDao.getInstance();
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("password", password);
		dao.login(map);
		
		
		
		HttpSession session = request.getSession();
			session.setAttribute("user", id);
			
			response.sendRedirect(request.getContextPath());

		}

}
