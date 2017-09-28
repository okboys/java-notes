package cn.com.time.jdk.sql.driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by TimaNetworks on 2017/8/28.
 */
public class TDriver implements Driver{
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
//        connect
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
//        acceptsURL url
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
//        getPropertyInfo url info
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
//        getMajorVersion
        return 0;
    }

    @Override
    public int getMinorVersion() {
//        getMinorVersion
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
//        jdbcCompliant
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//        getParentLogger
        return null;
    }
}
