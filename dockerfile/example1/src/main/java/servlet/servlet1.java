package servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Hi Chapter! This is servlet1!");
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}