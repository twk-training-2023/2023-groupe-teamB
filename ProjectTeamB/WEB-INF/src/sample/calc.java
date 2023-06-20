package sample;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calc")
public class calc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public calc() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException { //エンコーディング方式の設定
        request.setCharacterEncoding("UTF-8");
        int num1;
        String jdg;
        //リクエストデータの取得
        if(null == request.getParameter("num1") || "".equals(request.getParameter("num1"))) {
            num1 = 10;
        }else {
            num1 = Integer.parseInt(request.getParameter("num1"));
        }
        //100倍にする。
        num1 = num1 * 3;
        //奇数・偶数判定
        if (num1 % 2 == 0){
            jdg = "偶数";            
          }else{
            jdg = "奇数";
        }
        //リクエストオブジェクトへの設定
        request.setAttribute("num", num1);
        request.setAttribute("Jdg", jdg);

        //JSPへのフォワード処理
        //"/sample/answer.jsp"に/viewを追加2023/5/26
        RequestDispatcher rd = request.getRequestDispatcher("/view/sample/answer.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
