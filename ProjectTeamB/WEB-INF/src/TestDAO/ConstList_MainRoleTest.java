package TestDAO;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dao.ConstList_Main;
import dao.ConstList_RoleUser;

public class ConstList_MainRoleTest {

	@Test
	@DisplayName("ログインユーザー")
	public void CLRoleUser(){
		ConstList_Main clm = new ConstList_Main();
		String test1 = "jdbc:postgresql://localhost:5432/exam";
		String test2 = "login";
		String test3 = "abc";
		String result1 = clm.getUrl();
		String result2 = clm.getUser();
		String result3 = clm.getPass();
		assertEquals(test1,result1);
		assertEquals(test2,result2);
		assertEquals(test3,result3);
	}
	
	@Test
	@DisplayName("ログイン後ユーザー")
	public void CLMain(){
		ConstList_RoleUser clr = new ConstList_RoleUser();
		String test1 = "jdbc:postgresql://localhost:5432/exam";
		String test2 = "teamb";
		String test3 = "abc";
		String result1 = clr.getUrl();
		String result2 = clr.getUser();
		String result3 = clr.getPass();
		assertEquals(test1,result1);
		assertEquals(test2,result2);
		assertEquals(test3,result3);
	}

}