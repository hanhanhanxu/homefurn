package hx.insist.utils;

import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class WebUtil {
    /**
     * 网址访问
     * @param url  网址
     * @return urlDate 对象网址时间
     */
    public static String VisitURL(String url){//获取网络时间
        String urlDate = null;

        try {
            URL url1 = new URL(url);
            URLConnection conn = url1.openConnection();  //生成连接对象
            conn.connect();  //连接对象网页
            Date date = new Date(conn.getDate());  //获取对象网址时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //设置日期格式
            urlDate = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlDate;
    }


    /**
     * 获取ip
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {//获取访问者的真实ip
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    //字符串加密方法
    public static String md5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(message.getBytes());

            BASE64Encoder encoder = new BASE64Encoder();
            return  encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成6位随机数
    public static String randomNum(int n){
        String  result = "";
        String  result2= "";
        for(int i = 1;i <=n; i++)                  //6次执行输出6个不同字符
        {
            //判断产生的随机数是0还是1，是0进入if语句用于输出数字，是1进入else用于输出字符
            int rd = Math.random() >= 0.5 ? 1 : 0;

            if(rd == 0)
            {
                Random r = new Random();
                result = r.nextInt(9) +1 + "";      //产生1-9数字

            }
            else{
                //'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
                char[] A_z = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                Random sc = new Random();
                int sub = sc.nextInt(A_z.length);
                result = A_z[sub] + "";      //产生A——z字符

            }
            result2 +=result;
        }
        return result2;
    }

}
