package com.doctor.practice01;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * @author sdcuike
 *
 * @time 2016年2月10日 下午9:58:23
 */

@Component("Timestamp")
public class SqlTimestampTypeHandler implements TypeHandler<Timestamp> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Timestamp parameter, Object jdbcType) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Timestamp getResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Timestamp getResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Timestamp getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
