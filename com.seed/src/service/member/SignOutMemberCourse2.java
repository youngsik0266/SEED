package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import model.MemberDTO;
import service.SeedAction;
import service.SeedActionForward;

public class SignOutMemberCourse2 implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SignOutMemberCourse2");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_name = (String) session.getAttribute("user_name");
		String pw = request.getParameter("pw");
		
		System.out.println("user_name : " + user_name );
		System.out.println("pw : " + pw);
		
		QnADAO dao = QnADAO.getInstance();
		MemberDTO memberIdPw = dao.getMemberIdPw(user_name);
		
		int days = dao.getMemberDays(user_name);
		System.out.println("days : " + days);
		
		if(memberIdPw.getPw().equals(pw)) {
			System.out.println("비밀번호 확인 및 가입일수 불러오기 성공");
			request.setAttribute("days", days);
		} else {
			System.out.println("비밀번호 확인 실패");
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			out.close();
			
			return null;
		}
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/member_SignOutMemberCourse2.jsp");
		
		return forward;
	}

}
