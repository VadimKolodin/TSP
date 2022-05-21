import control.Controller;
import control.db.UploadService;
import control.stat.DayDeltaValue;
import control.stat.DeltaValue;
import control.stat.MonthDeltaValue;
import control.stat.StatisticsHandler;
import models.dto.User;


import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {
        List<DeltaValue> l = Controller.getInstance().getUserStat(1, LocalDate.of(2021, 1, 15), LocalDate.of(2021, 2,15), StatisticsHandler.DAY);
    System.out.println(l);
    }
}


