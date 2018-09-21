package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import domain.MemberVO;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/login/*")
public class MemberController extends AbstractController {

   MemberDAO dao = new MemberDAO();


   public String loginPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
     
	   System.out.println("loginPOST....................");
	   
	  req.setCharacterEncoding("UTF-8");

      String id = req.getParameter("id");
      int password = Converter.getInt((req.getParameter("password")), -1);

      MemberVO vo = dao.login(id);

      if(password==vo.getPassword()) {
         req.getSession().setAttribute("mno", vo.getMno());
         req.setAttribute("mno", vo.getMno());
         return "redirect:/admin/question/qlist";
         
      }else {
         return "redirect:/";
      }

   }

   
   
   public String getBasic() {
      return "/admin/login/";
   }
}