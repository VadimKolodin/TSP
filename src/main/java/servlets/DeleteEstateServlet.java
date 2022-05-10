package servlets;

import control.Controller;
import models.dto.RealEstate;
import models.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("DeleteEstate")
public class DeleteEstateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int eid=Integer.parseInt(req.getParameter("deleteEst"));
        //User user = Controller.getInstance().getUser();
        //Controller.getInstance().deleteEstate();
    }
}
