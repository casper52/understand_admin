package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.PageDTO;
import domain.QuestionVO;
import domain.ResponseVO;

public class UnderstandDAO {

	private String preFix = "mapper.UnderstandMapper";

	static SqlSessionFactory sqlSessionFactory;

	public List<QuestionVO> getList(PageDTO pageDTO) {

		List<QuestionVO> list = new ArrayList<>();
		QuestionVO vo = new QuestionVO();

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("page", pageDTO.getPage());
			paramMap.put("size", pageDTO.getSize());

			list = session.selectList(preFix + ".qlist", paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void write(QuestionVO vo) {
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			session.insert(preFix + ".write", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ResponseVO> getResult(Integer qno) {
		List<ResponseVO> list = new ArrayList<>();
		ResponseVO vo = new ResponseVO();
		
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("qno", qno);

			list = session.selectList(preFix + ".result", paramMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countList() {
		int total = 0;
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			total = session.selectOne(preFix+".count");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}