package servlets;

import control.Controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("estates/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileInputStream in = new FileInputStream(Controller.getInstance().getEstateImage(Integer.parseInt(req.getParameter("eid"))));
        BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
        resp.setContentType("image/jpg");
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        out.write(bytes);
        out.flush();
        out.close();
        in.close();
    }
}
