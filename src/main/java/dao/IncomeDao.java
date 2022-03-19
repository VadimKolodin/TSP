package dao;

import dto.Income;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeDao extends AbstractDao<Income, Integer>{

    private static final String IID_SEQ_NEXTVAL = "select iid_seq.nextval from DUAL";

    private static final String SELECT_ALL_INCOME = "select * from income order by date desc";
    private static final String SELECT_INCOME_BY_ID = "select * from income where iid = ?";
    private static final String INSERT_INCOME = "insert into income values (?,?,?,?,?,?)";
    private static final String UPDATE_INCOME_BY_ID = "update income set idate = ?, name = ?, value = ?, icomment = ? where iid = ?";
    private static final String DELETE_INCOME_BY_ID = "delete from income where iid = ?";

    @Override
    public List<Income> getAll() throws SQLException {
        PreparedStatement pr = connection.prepareStatement(SELECT_ALL_INCOME);
        ResultSet resultSet = pr.executeQuery();

        List<Income> incomes = new ArrayList<Income>();
        while(resultSet.next()){
            incomes.add(new Income(
                    resultSet.getInt("IID"),
                    resultSet.getInt("EID"),
                    resultSet.getDate("IDATE").toLocalDate(),
                    resultSet.getString("NAME"),
                    resultSet.getDouble("VALUE"),
                    resultSet.getString("ICOMMENT")
            ));
        }
        pr.close();
        return incomes;
    }

    @Override
    public boolean update(Income income) throws SQLException {
        if (income.getIid() == 0){
            throw new IllegalArgumentException("Null id");
        }
        Income oldIncome = getEntityById(income.getIid());
        PreparedStatement pr = connection.prepareStatement(UPDATE_INCOME_BY_ID);

        if (income.getIdate() != null){
            pr.setDate(1, Date.valueOf(income.getIdate()));
        } else {
            pr.setDate(1, Date.valueOf(oldIncome.getIdate()));
        }

        if (income.getName() != null){
            pr.setString(2, income.getName());
        } else {
            pr.setString(2, oldIncome.getName());
        }

        if (income.getValue() != null){
            pr.setDouble(3, income.getValue());
        } else {
            pr.setDouble(3, oldIncome.getValue());
        }

        if (income.getComment() != null){
            pr.setString(4, income.getComment());
        } else {
            pr.setString(4, oldIncome.getComment());
        }

        pr.setInt(5, income.getIid());

        int result = pr.executeUpdate();
        pr.close();
        return result > 0;
    }

    @Override
    public Income getEntityById(Integer iid) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(SELECT_INCOME_BY_ID);
        pr.setInt(1, iid);
        ResultSet resultSet = pr.executeQuery();

        Income income = null;
        if(resultSet.next()){
            income = new Income(
                    resultSet.getInt("IID"),
                    resultSet.getInt("EID"),
                    resultSet.getDate("IDATE").toLocalDate(),
                    resultSet.getString("NAME"),
                    resultSet.getDouble("VALUE"),
                    resultSet.getString("ICOMMENT")
            );
        }

        pr.close();
        return income;
    }

    @Override
    public boolean delete(Integer iid) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(DELETE_INCOME_BY_ID);
        pr.setInt(1, iid);

        int result = pr.executeUpdate();
        pr.close();
        return result > 0;
    }

    @Override
    public boolean create(Income income) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(INSERT_INCOME);
        pr.setInt(1, income.getIid());
        pr.setInt(2, income.getEid());
        pr.setDate(3, Date.valueOf(income.getIdate()));
        pr.setString(4, income.getName());
        pr.setDouble(5, income.getValue());
        pr.setString(6, income.getComment());

        int result = pr.executeUpdate();
        pr.close();
        return result > 0;
    }

    @Override
    public Integer getNewId() throws SQLException {
        PreparedStatement pr = connection.prepareStatement(IID_SEQ_NEXTVAL);
        ResultSet rs = pr.executeQuery();
        Integer iid = null;
        if(rs.next()) {
            iid = rs.getInt(1);
        }
        pr.close();
        return iid;
    }
}
