package com.myt.test;

import java.io.*;

/**
 * @author
 * @create 2019-08-15 9:36
 **/
public class AA {
    /**
     * 读取图片  返回一个图片的字节数组
     * @param path
     * @return
     */
    public static byte[] imgArray(String path) {
        //字节输入流
        InputStream inputStream = null;
        //字节缓冲流数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(path);
            byte[] b = new byte[1024];
            int len = -1;
            //循环读取
            while ((len = inputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, len);
            }
            //返回byteArrayOutputStream数组
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void writeImg(byte[]array,String path){
        //创建一个字节输出流
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(path));
            //将字节数组
            dataOutputStream.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取二进制保存的图片  放到数组里
     * @param path
     * @return
     */
    public static byte[] imageIn(String path){
        //创建一个字节输出流
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(path));
            //创建一个字节数组  byte的长度等于二进制图片的返回的实际字节数
            byte[] b = new byte[dataInputStream.available()];
            //读取图片信息放入这个b数组
            dataInputStream.read(b);
            return b;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 读取二进制保存的图片 输出图片
     * @param img
     * @param path
     */
    public static void writImg(byte[]img,String path){
        //创建一个字节输出流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            //将图片输处到流中
            outputStream.write(img);
            //刷新
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        //获取图片  将图片信息把存到数组b中
//        byte[] b = AA.imgArray("D:\\360Downloads\\11.jpg");
//        //通过数组B写到文件中
//        AA.writImg(b,"img.txt");
//        //读取二进制文件保存到一个数组中
//        byte[] c = AA.imageIn("img.txt");
//        System.out.println(c);
//        //通过数组c  输出图片
//        AA.writImg(c,"img.jpg");
    }
}