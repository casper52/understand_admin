package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import domain.PageDTO;
import domain.QBoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class QBoardDAO {

	private String prefix = "mapper.boardMapper";

	public List<QBoardVO> getList(PageDTO pageDTO) {

		log.debug(pageDTO);

		List<QBoardVO> list = new ArrayList<>();
		QBoardVO vo = new QBoardVO();

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("page", pageDTO.getPage());
			paramMap.put("size", pageDTO.getSize());

			list = session.selectList(prefix + ".list", paramMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int countList() {
		int total = 0;
		
		try(SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)){
			
			total = session.selectOne(prefix+".count");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public void create(QBoardVO vo) {

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			session.insert(prefix + ".write", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public QBoardVO read(int bno) throws Exception {
		QBoardVO vo = null;

		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			vo = session.selectOne(prefix + ".read", bno);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public void remove(int bno) {
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			session.delete(prefix + ".remove", bno);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modify(QBoardVO vo) {
		try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {

			session.update(prefix + ".modify",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}