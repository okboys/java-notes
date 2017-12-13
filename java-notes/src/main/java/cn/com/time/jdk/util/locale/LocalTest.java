package cn.com.time.jdk.util.locale;

import cn.com.time.jdk.base.BaseTest;

import java.util.Locale;

public class LocalTest extends BaseTest{

    public static void t1(){
        //获取操作系统的本地信息
        Locale locale=Locale.getDefault();
        //国家信息
        print("country:"+locale.getCountry());
        print("displayCountry:"+locale.getDisplayCountry());
        //语言信息
        print("language:"+locale.getLanguage());
        print("displayLanguage:"+locale.getDisplayLanguage());
        //
        print("extensionKeys:"+locale.getExtensionKeys());
    }

}
