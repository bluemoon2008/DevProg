/**
 * 
 */
package com.sg.tools.test;

import java.awt.EventQueue;

import com.sg.iot.devices.XmlCreator;
import com.sg.iot.devices.XmlParser;
import com.sg.tools.win.MainWindow;

/**
 * 功能描述：
 *
 * @category: com.sg.tools.test.TestMain
 * @author ia
 *
 */
public class TestMain {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		XmlCreator xmlCreator = new XmlCreator();
//		xmlCreator.createXml("test.xml");
		XmlParser xmlParser = new XmlParser();
		xmlParser.parserXml("test.xml");
		//window
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow window = new MainWindow();
//					window.setFrameVisible();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

}
