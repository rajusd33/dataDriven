package com.paxotech.selenium.framework.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class Utils {

	public String takeScreenshot() {
		
		String path  = System.getProperty("user.dir") +  
				       System.getProperty("file.separator") +
				       "target" + 
				       System.getProperty("file.separator") +
				       "screenShot" + 
				       System.getProperty("file.separator");
		
		if(!new File(path).exists()){
			new File(path).mkdir();
		}
		
		String timeString = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		String fileName = "ApplicationScreen" +  timeString + ".png";
		
		fileName =  path + fileName;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
		
		Robot robot;
		File file = null;
		
		try {
			robot = new Robot();
			BufferedImage image = robot.createScreenCapture(rectangle);
			file = new File(fileName);
			ImageIO.write(image, "png", file);
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}

		//counter +=1;
		return file.getAbsolutePath();
	}
	
public String takeScreenshot(String fileNameWithPath) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
		
		Robot robot;
		File file = null;
		
		try {
			robot = new Robot();
			BufferedImage image = robot.createScreenCapture(rectangle);
			file = new File(fileNameWithPath);
			ImageIO.write(image, "png", file);
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}

		//counter +=1;
		return file.getAbsolutePath();
	}

public String takeScreenshot(String path, String fileName) {
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screenSize = toolkit.getScreenSize();
	Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
	
	Robot robot;
	File file = null;
	
	try {
		robot = new Robot();
		BufferedImage image = robot.createScreenCapture(rectangle);
		file = new File(path + fileName);
		ImageIO.write(image, "png", file);
	} catch (AWTException | IOException e) {
		e.printStackTrace();
	}

	//counter +=1;
	return file.getAbsolutePath();
}

}
