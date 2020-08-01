package com.myt.test;

import java.io.*;

/**
 * @author
 * @create 2019-08-15 9:36
 **/
public class AA {
    /**
     * ��ȡͼƬ  ����һ��ͼƬ���ֽ�����
     * @param path
     * @return
     */
    public static byte[] imgArray(String path) {
        //�ֽ�������
        InputStream inputStream = null;
        //�ֽڻ���������
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(path);
            byte[] b = new byte[1024];
            int len = -1;
            //ѭ����ȡ
            while ((len = inputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, len);
            }
            //����byteArrayOutputStream����
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //�ر���
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void writeImg(byte[]array,String path){
        //����һ���ֽ������
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(path));
            //���ֽ�����
            dataOutputStream.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //�ر�
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��ȡ�����Ʊ����ͼƬ  �ŵ�������
     * @param path
     * @return
     */
    public static byte[] imageIn(String path){
        //����һ���ֽ������
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(path));
            //����һ���ֽ�����  byte�ĳ��ȵ��ڶ�����ͼƬ�ķ��ص�ʵ���ֽ���
            byte[] b = new byte[dataInputStream.available()];
            //��ȡͼƬ��Ϣ�������b����
            dataInputStream.read(b);
            return b;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //�ر���
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * ��ȡ�����Ʊ����ͼƬ ���ͼƬ
     * @param img
     * @param path
     */
    public static void writImg(byte[]img,String path){
        //����һ���ֽ������
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            //��ͼƬ�䴦������
            outputStream.write(img);
            //ˢ��
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //�ر�
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main����
     * @param args
     */
    public static void main(String[] args) {
        //��ȡͼƬ  ��ͼƬ��Ϣ�Ѵ浽����b��
//        byte[] b = AA.imgArray("D:\\360Downloads\\11.jpg");
//        //ͨ������Bд���ļ���
//        AA.writImg(b,"img.txt");
//        //��ȡ�������ļ����浽һ��������
//        byte[] c = AA.imageIn("img.txt");
//        System.out.println(c);
//        //ͨ������c  ���ͼƬ
//        AA.writImg(c,"img.jpg");
    }
}