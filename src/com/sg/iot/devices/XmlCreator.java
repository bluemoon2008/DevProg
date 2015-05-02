/**
 * 
 */
package com.sg.iot.devices;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.XmlCreator
 * @author ia
 *
 */
public class XmlCreator {

	public void createXml(String fileName) {
		
		Document document = DocumentHelper.createDocument();
		Element devices = document.addElement("DEVICES");
		
		Element device = devices.addElement("device");
		device.addAttribute("name", "devcie1");
		
		Element connect = device.addElement("connect");
		Element type = connect.addElement("type");
		type.setText("http|socket");
		Element IP = connect.addElement("IP");
		IP.setText("IP address|URL");
		Element port = connect.addElement("port");
		port.setText("port");
//		device.addAttribute("connectType","http|socket");
//		device.addAttribute("IP","IP address|URL");
//		device.addAttribute("port","port");
		
		Element authorize = device.addElement("authorize");
		authorize.addAttribute("always", "true|false(whether for every control)");
		
		
		Element variable = device.addElement("variable");
		variable.addAttribute("name", "variable name");
		variable.addAttribute("type", "date|float");
		variable.addAttribute("format", "format");
		variable.setText("default value");
		
		Element control = device.addElement("control");
		control.addAttribute("name","ctrl1");
		control.addAttribute("canExec","(can execute cmd)true|false");
		control.addAttribute("canProg","(can program by user)true|false");
		
		
		Element prefix = control.addElement("prefix");
		prefix.addAttribute("sendType", "(for http)post(default)|get");
		prefix.addAttribute("alone", "(send alone)true|false");
		prefix.setText("prefix for safety or sth. ");
		
		Element hyphen = control.addElement("hyphen");
		hyphen.setText("hyphen between values");
		
		Element value = control.addElement("value");
		value.addAttribute("name", "valueName");
		value.addAttribute("hyphen", "hyphen between name and value");
		value.setText("value(static or use variable upside)");
		
		Element rtnElement = control.addElement("return");
		
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();//缩减型格式
			//OutputFormat format = OutputFormat.createCompactFormat();//紧凑型格式
			format.setEncoding("utf-8");//设置编码
			//format.setTrimText(false);//设置text中是否要删除其中多余的空格
			
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

}
