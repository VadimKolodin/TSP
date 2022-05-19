package servlets.estates;

import control.Controller;
import models.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("AddEstateServlet")
public class AddEstateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User)req.getSession().getAttribute("user");
        String type=req.getParameter("typeEstate");
        String address=req.getParameter("addressEstate");
        //избражение

    }
}
