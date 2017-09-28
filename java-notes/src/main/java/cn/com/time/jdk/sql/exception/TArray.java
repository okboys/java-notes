package cn.com.time.jdk.sql.exception;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by TimaNetworks on 2017/8/24.
 */
public interface TArray {

    String getBaseTypeName() throws SQLException;

    int getBaseType() throws SQLException;

    Object getArray() throws SQLException;

    Object getArray(Map<String,Class<?>> map);

    Object getArray(long index,int count);

    ResultSet getResult();

}
