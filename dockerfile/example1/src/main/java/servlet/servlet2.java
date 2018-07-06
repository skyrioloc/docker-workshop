package servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Hi Chapter! This is servlet2!");
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}