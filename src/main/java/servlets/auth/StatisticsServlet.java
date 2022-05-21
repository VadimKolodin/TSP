package servlets.auth;

import control.Controller;
import control.stat.DeltaValue;
import control.stat.StatisticsHandler;
import models.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@WebServlet("statistics/getstat")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate from = LocalDate.parse(req.getParameter("from"));
        LocalDate to = LocalDate.parse(req.getParameter("to"));
        String mode = req.getParameter("mode");
        int period = Integer.parseInt("period");
        List<DeltaValue> vals = null;
        int usid = ((User)req.getSession().getAttribute("user")).getUid();
        if (mode == "user"){
            vals = Controller.getInstance().getUserStat(usid, from,to,period);
        } else if (mode=="estate"){
            vals=Controller.getInstance().getEstateStat(usid, Integer.parseInt(req.getParameter("eid")), from, to, period);
        } else {
            throw new IllegalArgumentException("Неправильный тип запроса");
        }
        resp.setContentType("text/plain");
        Writer out =resp.getWriter();
        out.write("[");
        for(DeltaValue value: vals){
            out.write("[");
            out.write("\'"+stringifyDate(value.getDate())+"\', "+value.getIncome()+", "+value.getOutcome());
            out.write("]");
        }
        out.write("]");
        out.close();
    }
    private String stringifyDate(LocalDate date){

        return (date.getDayOfMonth()<10?"0":"")+date.getDayOfMonth()+"."+(date.getMonthValue()<10?"0":"")+date.getMonthValue()+date.getYear();
    }
}
