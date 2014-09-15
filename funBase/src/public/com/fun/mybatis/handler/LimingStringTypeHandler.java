package com.fun.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

@SuppressWarnings("rawtypes")
public class LimingStringTypeHandler implements TypeHandler {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {

		System.out.println("setParameter - parameter: " + ((String) parameter)
				+ ", jdbcType: " + jdbcType.TYPE_CODE);
		ps.setString(i, ((String) parameter));

	}

	@Override
	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		System.out.println("getResult - columnName: " + columnName);
		return rs.getString(columnName);

	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		System.out.println("getResult - columnIndex: " + columnIndex);
		return rs.getString(columnIndex);

	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		System.out.println("getResult - columnIndex: " + columnIndex);
		return cs.getString(columnIndex);

	}

}