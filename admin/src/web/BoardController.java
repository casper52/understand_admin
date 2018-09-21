package web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.imgscalr.Scalr;

import dao.QBoardDAO;
import domain.PageDTO;
import domain.PageMaker;
import domain.QBoardVO;
import web.util.Converter;

@WebServlet(urlPatterns = "/admin/board/*")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, location = "C:\\zzz\\upload")
public class BoardController extends AbstractController {

	private QBoardDAO dao = new QBoardDAO();
	private static final long serialVersionUID = 1L;

	public String listGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("BoardGET............");

		PageDTO dto = PageDTO.of().setPage(Converter.getInt(req.getParameter("page"), 1))
				.setSize(Converter.getInt(req.getParameter("size"), 10));

		int total = dao.countList();

		System.out.println(total);
		PageMaker pageMaker = new PageMaker(total, dto);

		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("list", dao.getList(dto));

		return "list";
	}

	public String bwriteGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("writeGET..................");

		return "bwrite";

	}

	public String bwritePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("writePOST..................");

		req.setCharacterEncoding("UTF-8");
		QBoardVO vo = new QBoardVO();

		int page = Converter.getInt(req.getParameter("page"), -1);
		req.setAttribute("page", page);

		String title = req.getParameter("title");
		String writer = req.getParameter("name");
		String content = req.getParameter("content");
		

		System.out.println("-------파일업로드----------");

		Collection<Part> parts = req.getParts();

		parts.stream().filter(part -> part.getContentType() != null) // 한번 필터링 해줌 (not null인 애들만 받아서 처리해줄 수 있도록)
				.forEach(part -> {

					System.out.println(part.getContentType());
					System.out.println(part.getSubmittedFileName());
					System.out.println("------------------------------");

					String addfile = UUID.randomUUID() + "_" + part.getSubmittedFileName();

					try {
						InputStream in = part.getInputStream(); // 파일의 인풋스트림을 구한다
						FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + addfile); // 아웃풋스트림을 만든다

						IOUtils.copy(in, fos); // 원본파일 저장
						
						vo.setAddfile(addfile);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});

		System.out.println("----------업로드 끝-----------");
		vo.setTitle(title);
		vo.setName(writer);
		vo.setCnt(content);

		dao.create(vo);

		return "redirect/list";

	}

	public String breadGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("readGET............");
		QBoardDAO dao = new QBoardDAO();
		QBoardVO vo = dao.read(Converter.getInt(req.getParameter("bno"), -1));
		

		System.out.println(vo);
		req.setAttribute("board", vo);

		return "bread";

	}

	public String bremovePOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("removePOST...........");

		int bno = Converter.getInt(req.getParameter("bno"), -1);

		dao.remove(bno);

		System.out.println("removeEND.....");
		return "redirect/list";
	}

	public String bmodifyGET(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("modifyGET...........");

		int bno = Converter.getInt(req.getParameter("bno"), -1);
		String pageStr = req.getParameter("page");

		req.setAttribute("board", dao.read(bno));
		req.setAttribute("page", pageStr);

		return "bmodify";
	}

	public String bmodifyPOST(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		System.out.println("modifyPOST..............");

		QBoardVO vo = new QBoardVO();
		int bno = Converter.getInt(req.getParameter("bno"), -1);

		vo.setBno(bno);
		vo.setTitle(req.getParameter("title"));
		vo.setCnt(req.getParameter("content"));
		
		System.out.println("-------파일업로드----------");

		Collection<Part> parts = req.getParts();

		parts.stream().filter(part -> part.getContentType() != null) // 한번 필터링 해줌 (not null인 애들만 받아서 처리해줄 수 있도록)
				.forEach(part -> {

					System.out.println(part.getContentType());
					System.out.println(part.getSubmittedFileName());
					System.out.println("------------------------------");

					String addfile = UUID.randomUUID() + "_" + part.getSubmittedFileName();

					try {
						InputStream in = part.getInputStream(); // 파일의 인풋스트림을 구한다
						FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + addfile); // 아웃풋스트림을 만든다

						IOUtils.copy(in, fos); // 원본파일 저장
						
						vo.setAddfile(addfile);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});

		System.out.println("----------업로드 끝-----------");

		dao.modify(vo);

		req.setAttribute("board", dao.read(bno));

		int page = Converter.getInt(req.getParameter("page"), -1);
		req.setAttribute("page", page);

		return "redirect/list";
	}

	@Override
	public String getBasic() {

		return "/admin/board/";
	}

}