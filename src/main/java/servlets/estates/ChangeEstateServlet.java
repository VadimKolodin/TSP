package servlets.estates;

import control.Controller;
import models.dto.EstateStatus;
import models.dto.RealEstate;
import models.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("ChangeEstateServlet")
public class ChangeEstateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        try {
            if(req.getParameter("typeEstate")==null||req.getParameter("typeEstate").isEmpty()){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Тип\" не должно быть пустым. ");
            }
            if(!req.getParameter("typeEstate").matches("[^\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Тип\" не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                        " Попробуйте снова.\n");
            }
            String type=req.getParameter("typeEstate");
            if(req.getParameter("addressEstate")==null||req.getParameter("addressEstate").isEmpty()){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Адрес\" не должно быть пустым. ");
            }
            if(!req.getParameter("addressEstate").matches("[^\\[\\]\\?\\*\\-\\+\\\\\\n\\=]+")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Адрес\" не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                        " Попробуйте снова.\n");
            }
            String address=req.getParameter("addressEstate");
            if(req.getParameter("status")==null){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Адрес\" не должно быть пустым. ");
            }
            String status=req.getParameter("status");
            if(req.getParameter("purchasePrice")==null||req.getParameter("purchasePrice").isEmpty()){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Стоимость покупки\" не должно быть пустым. ");
            }
            if(!req.getParameter("purchasePrice").matches("[^a-zA-Z\\[\\]\\?\\*\\-\\+\\ \\\\\\n\\=]+")){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Стоимость покупки\" не являтся числом. ");
            }
            Integer purchasePrice=Integer.parseInt(req.getParameter("purchasePrice"));
            if(req.getParameter("purchaseDate")==null){
                throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Дата покупки\" не должно быть пустым. ");
            }
            LocalDate purchaseDate=LocalDate.parse(req.getParameter("purchaseDate"));
            if(purchasePrice<1){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Стоимость покупки\" должно быть больше 1");
            }
            RealEstate estate = new RealEstate(Integer.parseInt(req.getParameter("eid")),user.getUid(),type,address);
            EstateStatus statusEstate;
            if(status.equals("Продана")) {
                if(req.getParameter("soldPrice")==null||req.getParameter("soldDate")==null||req.getParameter("soldPrice").isEmpty()){
                    throw new IllegalArgumentException("Вы ввели некорректные данные.Если недвижимость продана, поля\"Стоимость продажи\" и \"Дата продажи\" должны быть заполнены.");
                }
                if(!req.getParameter("soldPrice").matches("[^a-zA-Z\\[\\]\\?\\*\\-\\+\\ \\\\\\n\\=]+")){
                    throw new NumberFormatException("Вы ввели некорректные данные.\nПоле \"Стоимость продажи\" не являтся числом. ");
                }
                Integer soldPrice=Integer.parseInt(req.getParameter("soldPrice"));
                if(soldPrice<1){
                    throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Сумма\" должно быть больше 1");
                }
                LocalDate soldDate=LocalDate.parse(req.getParameter("soldDate"));
                statusEstate = new EstateStatus(estate.getEid(), purchasePrice, purchaseDate,true,soldPrice,soldDate );
            }
            else{
                statusEstate=new EstateStatus(estate.getEid(),purchasePrice,purchaseDate,false,null,null);
            }
            Controller.getInstance().changeEstate(user.getUid(),estate,statusEstate);
            //избражение
            //Part file=req.getPart("file");
            //String filename=file.getSubmittedFileName();
            //Controller.getInstance().createEstateImage();
            resp.sendRedirect("estate?eid="+estate.getEid());
        }catch (NumberFormatException message){
            req.setAttribute("error", message.getMessage());
            getServletContext().getRequestDispatcher("/ChangeEstateError").forward(req, resp);
        }
        catch (IllegalArgumentException| SQLException message){
            req.setAttribute("error", message.getMessage());
            getServletContext().getRequestDispatcher("/ChangeEstateError").forward(req, resp);
        }
    }
}
