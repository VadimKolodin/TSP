package servlets.estates;

import control.Controller;
import models.dto.RealEstate;
import models.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("ChangeEstateServlet")
public class ChangeEstateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User)req.getSession().getAttribute("user");
        RealEstate estate= Controller.getInstance().getRealEstate(user.getUid(), Integer.parseInt(req.getParameter("eid")));
        String type=req.getParameter("typeEstate");
        String address=req.getParameter("addressEstate");
        String status=req.getParameter("status");
        LocalDate date_purchase=LocalDate.parse(req.getParameter("date_purchase"));
        LocalDate date_sold=LocalDate.parse(req.getParameter("date_sold"));
        // try{
            if(!req.getParameter("price_purchase").matches("[^a-zA-z\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле с суммой о приобретении недвижимости  не являтся числом. ");
            }
            Double price_purchase=Double.parseDouble(req.getParameter("price_sold"));
            if(!req.getParameter("price_sold").matches("[^a-zA-z\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле с суммой о продаже недвижимости не являтся числом. ");
            }
            Double price_sold=Double.parseDouble(req.getParameter("price_sold"));
            if(price_purchase<1||price_sold<1){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоля с суммой должны быть больше 1");
            }
            if(!type.matches("[^a-zA-z\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Тип\"не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                        " Попробуйте снова.\n");
            }
            if(!address.matches("[^a-zA-z\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Тип\"не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                        " Попробуйте снова.\n");
            }
            if(status.equals("продан")){
                estate.getStatus().setSold(true);
            }
            if(status.equals("в собственности")){
                estate.getStatus().setSold(false);
            }
            if(!status.equals("продан")&&!status.equals("в собственности")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Статус\" должно содержать \"продан\" или \"в собственности\".\n");
            }




    }
}
