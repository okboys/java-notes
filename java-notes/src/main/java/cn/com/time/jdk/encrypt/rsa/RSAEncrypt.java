package cn.com.time.jdk.encrypt.rsa;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created on 202017/9/22 16:15 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class RSAEncrypt {

    private static final char[] HEX_CHAR={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    /**
     * 生成公钥私钥
     * @param filePath
     * @throws IOException
     */
    public static void genKeyPair(String filePath) throws IOException {
        KeyPairGenerator generator=null;
        try {
            generator=KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        generator.initialize(1024,new SecureRandom());
        KeyPair keyPair=generator.generateKeyPair();
        RSAPrivateKey privateKey= (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey= (RSAPublicKey) keyPair.getPublic();

        String publicKeyString = Base64.encode(publicKey.getEncoded());
        String privateKeyString=Base64.encode(privateKey.getEncoded());

        FileWriter frPub=new FileWriter(filePath+"/publicKey.keystone");
        FileWriter frPri=new FileWriter(filePath+"/privateKey.keystone");
        BufferedWriter pubWr=new BufferedWriter(frPub);
        BufferedWriter priWr=new BufferedWriter(frPri);

        pubWr.write(publicKeyString);
        priWr.write(privateKeyString);

        pubWr.flush();
        pubWr.close();
        frPub.close();

        priWr.flush();
        priWr.close();
        frPri.close();
    }

}
