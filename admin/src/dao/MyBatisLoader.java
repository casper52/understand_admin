
	package dao;

	import java.io.InputStream;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.apache.ibatis.io.Resources;
	import org.apache.ibatis.session.SqlSession;
	import org.apache.ibatis.session.SqlSessionFactory;
	import org.apache.ibatis.session.SqlSessionFactoryBuilder;

	public class MyBatisLoader {
		
		static SqlSessionFactory sqlSessionFactory;
		
		static {
			try {
				String resource = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
