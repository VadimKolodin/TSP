package dao;

import dto.RealEstate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EstateDao extends AbstractDao<RealEstate, Integer>{

    private static final String EID_SEQ_NEXTVAL = "select eid_seq.nextval from DUAL";

    private static final String DELETE_FROM_REAL_ESTATE_BY_ID = "delete from real_estate where eid = ?";

    private static final String DELETE_FROM_ESTATE_STATUS_BY_ID = "delete from estate_status where eid = ?";

    @Override
    public List<RealEstate> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(RealEstate entity) throws SQLException {
        return false;
    }

    @Override
    public RealEstate getEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Integer eid) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(DELETE_FROM_REAL_ESTATE_BY_ID);
        pr.setInt(1, eid);

        int result = pr.executeUpdate();
        return result > 0;
    }

    public boolean deleteEstateStatusById(Integer eid) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(DELETE_FROM_ESTATE_STATUS_BY_ID);
        pr.setInt(1, eid);

        int result = pr.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean create(RealEstate entity) throws SQLException {
        return false;
    }

    @Override
    public Integer getNewId() throws SQLException {
        PreparedStatement pr = connection.prepareStatement(EID_SEQ_NEXTVAL);
        ResultSet resultSet = pr.executeQuery();

        Integer eid = null;
        if (resultSet.next()){
            eid = resultSet.getInt(1);
        }
        return eid;
    }
}
