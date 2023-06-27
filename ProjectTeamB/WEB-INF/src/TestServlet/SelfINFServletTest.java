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

import bean.StaffBean;
import dto.StaffDTO;
import general_servlet.SelfINFServlet;

public class SelfINFServletTest {

	@Test
	@DisplayName("個人情報全出力")
	public void SelfINF() throws ServletException, IOException {
		SelfINFServlet chngser = new SelfINFServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = "鈴木恵美";
		session.setAttribute("name", name);

		chngser.doGet(req, resp);

		StaffDTO stdto = (StaffDTO) req.getAttribute("value");
		for (int a = 0; a < stdto.size(); a++) {
			StaffBean stbe = stdto.get(a);
			assertThat("0000", is(stbe.getId()));
			assertThat("java", is(stbe.getSkill_name()));
			assertThat(8, is(stbe.getSkill_lv()));
			assertThat("前職は総理大臣です。対戦ありがとうございました。", is(stbe.getSkill_appeal()));
			assertThat("申請中", is(stbe.getStatus()));
			assertThat("対戦ありがとうございました", is(stbe.getMyself()));
			assertThat("/view/GeneralView/SelfINF.jsp", is(resp.getForwardedUrl()));
		}

	}

	@Test
	@DisplayName("個人情報全出力/セッションが期限切れ")
	public void SelfINFsession() throws ServletException, IOException {
		SelfINFServlet chngser = new SelfINFServlet();
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse resp = new MockHttpServletResponse();

		HttpSession session = req.getSession();
		String name = null;
		session.setAttribute("name", name);

		chngser.doGet(req, resp);

		assertThat("/view/VersView/Timeout.jsp", is(resp.getForwardedUrl()));
	}
}
