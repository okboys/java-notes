package cn.com.time.jdk.sql.exception;

import sun.misc.Cache;

import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Iterator;

public class TSqlException extends Exception implements Iterable<Throwable>{

    private String sqlState;

    private int vendorCode;

    public TSqlException(String reason,String SQLState,int vendorCode){
//        super(reason);
//        this.sqlState=SQLState;
//        this.vendorCode=vendorCode;
//        if (!(this instanceof SQLWarning)) {
//            if(DriverManager.getLogWriter()!=null){
//                DriverManager.println("SQLState("+sqlState+") vendor code("+vendorCode+")");
//
//            }
//        }
    }

    @Override
    public Iterator<Throwable> iterator() {
        return null;
    }


}
