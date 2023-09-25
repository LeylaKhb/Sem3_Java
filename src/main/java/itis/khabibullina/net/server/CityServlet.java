package itis.khabibullina.net.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("city.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityName = req.getParameter("cityName");

        if (cityName != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("cityName", cityName);
            httpSession.setMaxInactiveInterval(60 * 60);

            Cookie cookie = new Cookie("cityName", cityName);
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);

            resp.sendRedirect("/weather");
        } else {
            resp.sendRedirect("/city");
        }
    }
}
