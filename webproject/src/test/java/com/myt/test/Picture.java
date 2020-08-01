package com.myt.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_highgui;
import org.bytedeco.javacpp.opencv_imgcodecs;

public class Picture {
	public static void load() throws IOException {
		opencv_core.Mat src = opencv_imgcodecs.imread("D:\\360Downloads\\loadingpic302.png");
		opencv_highgui.imshow("picture", src);
		int width = src.cols();
		int height = src.rows();
		int channels = src.channels();
		int type = src.type();
		System.out.println(width+ ":" + height+":"+channels);
		BytePointer ptr = src.ptr();
		byte[] data = new byte[width*height*channels];
		ptr.get(data);
		//–¥»Î”≤≈Ã
		FileUtils.writeByteArrayToFile(new File("data.bin"), data);
		while(true) {
			opencv_highgui.cvWaitKey(20);
		}
	
	}
	public static void load_data() throws IOException, InterruptedException {
		byte[] data = FileUtils.readFileToByteArray(new File("data.bin"));
		opencv_core.Mat src = new opencv_core.Mat(data);
		opencv_core.Mat src_reshape = src.reshape(3,640);
		System.out.println(src_reshape.cols());
		System.out.println(src_reshape.rows());
		System.out.println(src_reshape.channels());
		opencv_core.MatVector vctor = new opencv_core.MatVector();
		opencv_core.split(src_reshape,vctor);
		opencv_highgui.cvNamedWindow("win_reshape",opencv_highgui.CV_WINDOW_NORMAL);
		opencv_highgui.imshow("win_reshape", src_reshape);
		opencv_highgui.cvNamedWindow("win_reshape1",opencv_highgui.CV_WINDOW_NORMAL);
		opencv_highgui.imshow("win_reshape1", vctor.get(0));
		opencv_highgui.cvNamedWindow("win_reshape2",opencv_highgui.CV_WINDOW_NORMAL);
		opencv_highgui.imshow("win_reshape2", vctor.get(1));
		opencv_highgui.cvNamedWindow("win_reshape3",opencv_highgui.CV_WINDOW_NORMAL);
		opencv_highgui.imshow("win_reshape3", vctor.get(2));
		int key = 0;
		while((key & 0xFF) != 27) {
			key = opencv_highgui.cvWaitKey(20);
		}
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
//		load();
	}
}
