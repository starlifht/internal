package com.interapi.open;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * @author kaizhao
 *
 */
public class SignatureUtils {
 
    /**
     * open api 的签名算法
     * @param parameterMap
     * @param secret
     * @return
     */
    public static String signatureMultiValue(Map<String, String[]> parameterMap, String secret) {
        List<String> list = new ArrayList<String>();

        // (1)connecting all parameters
        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            StringBuilder values = new StringBuilder();
            for(String v : entry.getValue()){
                values.append(v);
                values.append(",");
            }
            values.replace(values.lastIndexOf(","), values.length(), "");
            list.add(entry.getKey() + "=" + values);
        }

        // (2)sort all strings
        Collections.sort(list);

        StringBuilder buf = new StringBuilder();
        for (String s : list) {
            buf.append(s);
        }
        // (3)append secret key
        buf.append(secret);

        // (4)md5 your code with utf8 encoding
        return getMD5MessageDigest(buf.toString());
    }
    
    /**
     * open api 的签名算法
     * @param parameterMap
     * @param secret
     * @return
     */
    public static String signature(Map<String, String> parameterMap, String secret) {
        List<String> list = new ArrayList<String>();

        // (1)connecting all parameters
        for (Entry<String, String> entry : parameterMap.entrySet()) {
            list.add(entry.getKey() + "=" + entry.getValue());
        }

        // (2)sort all strings
        Collections.sort(list);

        StringBuilder buf = new StringBuilder();
        for (String s : list) {
            buf.append(s);
        }
        // (3)append secret key
        buf.append(secret);

        // (4)md5 your code with utf8 encoding
        return getMD5MessageDigest(buf.toString());
    }

    /**
     * 按照UTF-8生成md5摘要
     * @param sourceStr
     * @return
     */
    public static String getMD5MessageDigest(String sourceStr) {

        String result = null;
        try {
            result = DigestUtils.md5Hex(sourceStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
      
        }
        
        return result;
    }
    
    /**
     * 按照指定的字符编码集生成md5摘要
     * @param sourceStr
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getMD5MessageDigest(String sourceStr, String charset) throws UnsupportedEncodingException {

        return DigestUtils.md5Hex(sourceStr.getBytes(charset));
    }
}
