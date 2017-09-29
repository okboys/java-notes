package cn.com.time.jdk.encrypt.rsa;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;

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

    /**
     * 公钥加密
     * @param content
     * @param publicKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(content);
    }

    /**
     * 私钥解密
     * @param content
     * @param privateKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decrypt(byte[] content,PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return cipher.doFinal(content);
    }

    /**
     * 将被Base64编码的字符串转换为PublicKey
     * @param publicKey
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes=Base64.decode(publicKey);
        //对密钥字节进行编码
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static PrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes=Base64.decode(privateKey);
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 取模
     * @param publicKey
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static BigInteger getPublicModule(String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPublicKey rsaPublicKey= (RSAPublicKey) getPublicKey(publicKey);
        return rsaPublicKey.getModulus();
    }

    /**
     * 取指数
     * @param publicKey
     * @return
     */
    public static BigInteger getPublicExeponent(String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPublicKey rsaPublicKey= (RSAPublicKey) getPublicKey(publicKey);
        return rsaPublicKey.getPublicExponent();
    }

    /**
     * 取模
     * @param privateKey
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static BigInteger getPrivateModule(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPrivateKey rsaPrivateKey= (RSAPrivateKey) getPublicKey(privateKey);
        return rsaPrivateKey.getModulus();
    }

    /**
     * 取指数
     * @param privateKey
     * @return
     */
    public static BigInteger getPrivateExeponent(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPrivateKey rsaPublicKey= (RSAPrivateKey) getPublicKey(privateKey);
        return rsaPublicKey.getPrivateExponent();
    }

    /**
     * 通过模和指数来获取公钥
     * @param modulesStr
     * @param exponentStr
     * @return
     */
    public static PublicKey getPublicKey(String modulesStr,String exponentStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        BigInteger modules=new BigInteger(modulesStr);
        BigInteger exponent=new BigInteger(exponentStr);
        RSAPublicKeySpec publicKeySpec=new RSAPublicKeySpec(modules,exponent);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicKeySpec);
    }

    /**
     * 通过模和指数来获取私钥
     * @param modulesStr
     * @param exponentStr
     * @return
     */
    public static PrivateKey getPrivateKey(String modulesStr,String exponentStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        BigInteger modules=new BigInteger(modulesStr);
        BigInteger exponent=new BigInteger(exponentStr);
        RSAPrivateKeySpec privateKeySpec=new RSAPrivateKeySpec(modules,exponent);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(privateKeySpec);
    }

}
