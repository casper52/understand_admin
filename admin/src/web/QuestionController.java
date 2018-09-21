package web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UnderstandDAO;
import domain.PageDTO;
import domain.PageMaker;
import domain.QuestionVO;
import domain.ResponseVO;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/question/*")
public class QuestionController extends AbstractController{

	UnderstandDAO dao = new UnderstandDAO();

	//list
	 public String qlistGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 	System.out.println("qlistget.....");
	        PageDTO dto = PageDTO.of()
	                .setPage(Converter.getInt(req.getParameter("page"), 1))
	                .setSize(Converter.getInt(req.getParameter("size"), 10));

	        int total = dao.countList();
	        PageMaker pageMaker = new PageMaker(total, dto);

	        req.setAttribute("pageMaker", pageMaker);
	        req.setAttribute("qlist", dao.getList(dto));

	        return "qlist";
	    }

	 public String resultGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{
	        System.out.println("resultGET...........................");

	        String qnoStr = req.getParameter("qno");
	        int qno = Converter.getInt(qnoStr,-1);

	        int page = Converter.getInt(req.getParameter("page"),-1);

 	        if (dao.getResult(qno).isEmpty() ) {
 	        	return "wait";
	        }
	        
	        if (qno == -1) {
	            throw new Exception("invalid data");
	        }
	        
	        req.setAttribute("page", page);
	        req.setAttribute("result", dao.getResult(qno));

	        return "result";
	    }
	 
	    public String qwriteGET(HttpServletRequest req, HttpServletResponse resp) throws Exception{

	        req.setCharacterEncoding("UTF-8");

	        System.out.println("qwriteGET...........................");
	        return "qwrite";
	    }
	    
	    public String qwritePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception{
	        System.out.println("qwritePOST...........................");

	        req.setCharacterEncoding("UTF-8");

	        QuestionVO vo = new QuestionVO();
	        vo.setQuestion(req.getParameter("question"));
	        vo.setLimittime(Converter.getInt(req.getParameter("limittime"), 1));
	        
	        
	        dao.write(vo);
	       
	        return "redirect:/admin/question/qlist";

	    }
	 //result
	 
/*	    public String readGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	        String bnoStr = req.getParameter("bno");
	        int bno = Converter.getInt(bnoStr, -1);
	        String pageStr = req.getParameter("page");
	        int page = Converter.getInt(pageStr, -1);
	        boolean updateable = false;
	        if (bno == -1) {
	            throw new Exception("invalid data");
	        }
	
	        return "read";
	    }*/

	    public String getBasic() {
	        return "/admin/question/";
	    }
}