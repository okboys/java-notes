package cn.com.time.jdk.collection.map;

import cn.com.time.jdk.base.BaseTest;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TimaNetworks on 2017/8/15.
 */
public class MapTest extends BaseTest{

    public static void hashMap(){
        Map<String,String> m=new HashMap<>();
        m.put("a","b");
        m.forEach((k,v)->{
            System.out.println("k="+k);
            System.out.println("v="+v);
        });
        m.replaceAll((k,v)->{
            return v+"a";
        });
        m.forEach((k,v)->{
            System.out.println("k="+k);
            System.out.println("v="+v);
        });
        System.out.println(m.toString());
    }

}

