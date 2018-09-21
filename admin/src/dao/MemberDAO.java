package dao;

import org.apache.ibatis.session.SqlSession;

import domain.MemberVO;

public class MemberDAO {

	private String prefix = "mapper.memberMapper";
	//로그인
	public MemberVO login(String id) {
	
	      
	   System.out.println("---------------------로그인 dao");
	      try (SqlSession session = MyBatisLoader.sqlSessionFactory.openSession(true)) {
	         System.out.println("---------------------로그인 dao2");
	         return session.selectOne(prefix + ".login", id);


	      } catch (Exception e) {
	         e.printStackTrace();

	      }
	      return null;
	   }   
}
