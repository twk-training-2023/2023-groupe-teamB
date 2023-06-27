package TestServlet;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import admin_servlet.CmpAddServlet;

public class CmpAddServletTest {

	@Test
	@DisplayName("単体社員追加送信完了")
	public void CmpAdd() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String nam = "ルイス";
		String email = "locusno1";
		String password = "locus";
		String lv = "1";

		session.setAttribute("name", name);
		req.setParameter("name", nam);
		req.setParameter("email", email);
		req.setParameter("pass", password);
		req.setParameter("lv", lv);
		
		chngser.doGet(req, resp);

		assertThat("社員一覧ページ", is(req.getAttribute("botton")));
		assertThat("/ManagerServlet", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Complete.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("単体社員追加送信失敗")
	public void ChngMyfaild() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String nam = "ルイスああああああああああああああああああああああああああああああああああああああああああ";
		String email = "locusno1";
		String password = "locus";
		String lv = "1";

		session.setAttribute("name", name);
		req.setParameter("name", nam);
		req.setParameter("email", email);
		req.setParameter("pass", password);
		req.setParameter("lv", lv);

		chngser.doGet(req, resp);

		assertThat("社員一覧ページ", is(req.getAttribute("botton")));
		assertThat("/ManagerServlet", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Error.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("単体社員追加/セッションが期限切れ")
	public void CmpAddsession() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doGet(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("複数社員追加送信完了")
	public void CmpAddmanyClear() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String fpass = "C:\\Users\\KAMUI-NEMOTO\\Documents\\社員追加の例.csv";

		session.setAttribute("name", name);
		req.setParameter("fpass", fpass);

		chngser.doPost(req, resp);

		assertThat("社員一覧ページ", is(req.getAttribute("botton")));
		assertThat("/ManagerServlet", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Complete.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("単体社員追加送信失敗")
	public void CmpAddmanyfaild() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String fpass = "C:\\Users\\KAMUI-NEMOTO\\Documen.csv";

		session.setAttribute("name", name);
		req.setParameter("fpass", fpass);

		chngser.doPost(req, resp);

		assertThat("社員一覧ページ", is(req.getAttribute("botton")));
		assertThat("/ManagerServlet", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Error.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("単体社員追加sql失敗")
	public void CmpAddmanysqlfaild() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		String fpass = "C:\\Users\\\\KAMUI-NEMOTO\\Documents\\社員追加の悪例.csv";

		session.setAttribute("name", name);
		req.setParameter("fpass", fpass);

		chngser.doPost(req, resp);

		assertThat("社員一覧ページ", is(req.getAttribute("botton")));
		assertThat("/ManagerServlet", is(req.getAttribute("URL")));
		assertThat("/view/VersView/Error.jsp", is(resp.getForwardedUrl()));
	}

	@Test
	@DisplayName("単体社員追加/セッションが期限切れ")
	public void CmpAddmanysession() throws ServletException, IOException {
		CmpAddServlet chngser = new CmpAddServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doPost(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}
}
