package servlets;

import control.Controller;
import models.dto.Income;
import models.dto.Outcome;
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

@WebServlet("EditSpendingServlet")
public class EditSpending extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User)req.getSession().getAttribute("user");
        RealEstate estate=Controller.getInstance().getRealEstate(user.getUid(),Integer.parseInt(req.getParameter("eid")));
        Income income;
        Outcome outcome;
        String name=req.getParameter("name");
        Double value=Double.parseDouble(req.getParameter("value"));
        String description=req.getParameter("description_come");
        LocalDate date=LocalDate.parse(req.getParameter("date"));

        try{

            if(name==""){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nДанные поля \"Название\" должны быть заполнены. Попробуйте снова.\n");
            }
            if(!name.matches("[^\\[\\]\\?\\*\\-\\+\\\\\\/ \\n\\=]+")){
                throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Название\" не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                        " Попробуйте снова.\n");
            }
            if(description!=null){
                if(!description.isEmpty()&&!(description.matches("[^\\[\\]\\?\\*\\-\\+\\\\\\/ \\n\\=]+"))) {
                    throw new IllegalArgumentException("Вы ввели некорректные данные.\nПоле \"Описание\" не должно содержать\"[],?,*,-,+,\\,/,=\"." +
                            " Попробуйте снова.\n");
                }
            }
            if(req.getParameter("iid")!=null){
                income=new Income(Integer.parseInt(req.getParameter("iid")),estate.getEid(),date,name,value,description);
                Controller.getInstance().changeIncome(user.getUid(),income);
                resp.sendRedirect("estate?eid="+estate.getEid());
            }
            else{
                outcome=new Outcome(Integer.parseInt(req.getParameter("oid")),estate.getEid(),date,name,value,description);
                Controller.getInstance().changeOutcome(user.getUid(),outcome);
                resp.sendRedirect("estate?eid="+estate.getEid());
            }

        }catch(IllegalArgumentException|SQLException message){
            req.setAttribute("error", message.getMessage());
            getServletContext().getRequestDispatcher("/WrongEditSpending").forward(req, resp);
        }

    }
}
