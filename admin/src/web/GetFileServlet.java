package web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * Servlet implementation class GetFileServlet
 */
@WebServlet("/getfile")
public class GetFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("fname");
		
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		
//		if(ext.equals("jpg")) {
//			response.setContentType("Image/jpeg");
//		}else {	// jpg 확장자가 아닐 경우 다운로드를 받는다.
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment; filename="+ fileName);
//		}
		

		
		OutputStream os = response.getOutputStream();
		InputStream in = new FileInputStream("C:\\zzz\\upload\\" + fileName);
		
		IOUtils.copy(in,os);
	}

}
