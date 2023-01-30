package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mybatis.SqlSessionBean;

class MybatisSQLTest {

	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();

	@DisplayName("sqlSession 연결 테스트")
	@Test
	void session() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}

	@DisplayName("select 전체 조회 테스트-현재예상값 2")
	@Test
	void selectList() {
		assertEquals(dao.selectAll().size(), 2);
	}

	@DisplayName("insert 테스트 - id(PK) : momo 로 추가") // 첫번째 테스트 성공, 두번째 실패
	@Test
	void insert() {
		int result = dao.insert(NewMember.builder().id("momo").name("이모모").password("1212").email("momo@naver.com")
				.age(23).gender("2").hobbies("달리기").build());
		assertEquals(result, 1);
	}

	
	
	
	
	 @DisplayName("로그인 테스트")
	   @Test
	   void login() {
	      String id="momo";
	      String pw="1234";
	      Map <String,String>map=new HashMap<String,String>();
	      map.put("id", id);
	      map.put("password", pw);
	      NewMember vo=dao.login(map);
	      System.out.printf(vo.getId());
	      assertNotNull(vo.getId());
	   }
}
