package junit.daoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bean.MessageBean;
import dao.MessageDAO;
import dto.MessageDTO;

public class MessageDAOTest {
	
	String name = "鈴木恵美";
	String message = "Junitテスト中";
	
	@Test
	@DisplayName("社員連絡入力")
	public void test1() {
		MessageDAO dao = new MessageDAO();
		
		int ans = 1;
		int say = dao.insertMessage(name,message);
		
		assertEquals(say,ans);
	}
	@Test
	@DisplayName("社員連絡確認")
	public void test2() {
		
		MessageDAO dao = new MessageDAO();
		MessageBean bean = new MessageBean();
		
		MessageDTO sdto = dao.selectMessage();
		int a = sdto.size();
		a = a - 1;
		bean = sdto.get(a);
		assertEquals(message,bean.getMessage());
	}
}
