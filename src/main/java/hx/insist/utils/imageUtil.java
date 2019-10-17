package hx.insist.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class imageUtil {
	
	 static BASE64Encoder encoder = new BASE64Encoder();
	 static BASE64Decoder decoder = new BASE64Decoder();
	
	 //图片转base64编码
	 public static String getImageBinary(String filepath){    
        File f = new File(filepath);
        BufferedImage bi;    
        try {    
            bi = ImageIO.read(f);    
            ByteArrayOutputStream baos = new ByteArrayOutputStream();    
            ImageIO.write(bi, "jpg", baos);    
            byte[] bytes = baos.toByteArray();    
                
            return encoder.encodeBuffer(bytes).trim();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return null;    
    }    
	
	//base64编码转图片 这个色调会出问题
	 /*public static void base64StringToImage(String base64String,String filepath,String filename){
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 =ImageIO.read(bais);
            File w2 = new File(filepath+filename);//jpg,png,gif
            System.out.println(base64String);
            System.out.println(filepath);
            System.out.println(filename);
            ImageIO.write(bi1, "jpg", w2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    //base64编码转图片
    public static boolean generateImage(String base64String,String filepath,String filename ) {
        String imgFilePath = filepath+"\\"+filename;
        if (base64String == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(base64String);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
