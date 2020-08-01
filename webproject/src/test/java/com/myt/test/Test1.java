package com.myt.test;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myt.entity.User;
import com.myt.serviceImpl.UserServiceImpl;

public class Test1 {
	public static void main(String[] args) throws Exception{
		
//		PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//		Point point = pointerInfo.getLocation();
//		Robot robot = new Robot();
//		int x = point.x;
//		int y = point.y;
//		for(int i = 0;i<500;i++) {
//			robot.mouseMove(x, y);
//			x++;
//			y++;
//			Thread.sleep(240000);
//		}
		
	}
	
	public void t1() throws PropertyVetoException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl userService = context.getBean("userService",UserServiceImpl.class);
//		jdbc.update("insert into t_user (username,userpwd) values(?,?)", "dog","6784");
		List<User> list = userService.queryAll();
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	public void t2() {
		String st = "'a','b','c'";
		System.out.println(st);
		String regex = "['][,]?[']?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(st);
        String s = matcher.replaceAll(" ");
        System.out.println(s);
         
	}
	
	public void testout() throws AWTException {
		Robot robot = new Robot();  //1366,768
		robot.delay(10000);
//		PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//		Point p = pointerInfo.getLocation();
//		System.out.println(p.x+":"+p.y);
//		robot.mouseMove(1141, 632);
		Random ran = new Random();
//		while(true) {
//			robot.delay((int)(ran.nextDouble()*3000+2000));
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //按下鼠标左键
//			robot.delay((int)(ran.nextDouble()*100+200)); 
//			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		}
		int i = 0;
		try {
			while(true) {
				if(i % 3 == 0) {
					robot.keyPress(KeyEvent.VK_A);
				}else if(i % 4 == 0){ 
					robot.keyPress(KeyEvent.VK_D);
				}
				robot.keyPress(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*400+600));
				robot.keyPress(KeyEvent.VK_O);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_O);
				robot.delay((int)(ran.nextDouble()*500+500));
				robot.keyPress(KeyEvent.VK_I);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_I);
				robot.delay((int)(ran.nextDouble()*600+400));
				robot.keyRelease(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyPress(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*100+100));
				robot.keyRelease(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*500+700));
				robot.keyPress(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyPress(KeyEvent.VK_J);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_J);
				robot.delay((int)(ran.nextDouble()*700+300));
				robot.keyPress(KeyEvent.VK_E);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_E);
				robot.delay((int)(ran.nextDouble()*800+200));
				robot.keyPress(KeyEvent.VK_R);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_R);
				robot.delay((int)(ran.nextDouble()*200+800));
				robot.keyRelease(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyPress(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*100+100));
				robot.keyRelease(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*500+700));
				robot.keyPress(KeyEvent.VK_K);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.delay((int)(ran.nextDouble()*300+200));
				robot.keyRelease(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_K);
				if(i % 3 == 0) {
					robot.keyRelease(KeyEvent.VK_A);
				}else if(i % 4 == 0){
					robot.keyRelease(KeyEvent.VK_D);
				}
				i++;
				
				//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //按下鼠标左键
//				robot.delay((int)(ran.nextDouble()*100+200));
//				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			
		}catch(Exception e) {
			
		}finally {
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_K);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_E);
		}
		
	}
}
