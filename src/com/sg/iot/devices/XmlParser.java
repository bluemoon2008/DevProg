/**
 * 
 */
package com.sg.iot.devices;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.XmlParser
 * @author ia
 *
 */
public class XmlParser {
	

	public void parserXml(String fileName) {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element devices = document.getRootElement();

			loopElement(devices);
			
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("dom4j parserXml");
	}
	
	
	public void loopElement(Element root) {
		
		System.out.println("NODE:" + root.getName() + " - " + root.getTextTrim());
		
		for (Iterator iterator = root.attributeIterator(); iterator.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();       
			String text=attribute.getText();
			
			System.out.println("ATTR:" + attribute.getName() + " - " + text);
		}
		
		for (Iterator i = root.elementIterator(); i.hasNext();) {
			Element child = (Element) i.next();
			
			loopElement(child);
		}
		
	}
	
	public Map<String, String> getAttributeMap(Element e) {
		
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator iterator = e.attributeIterator(); iterator.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();
			String name = attribute.getName();
			String text=attribute.getText();
			
			map.put(name, text);
//			System.out.println("ATTR:" + attribute.getName() + " - " + text);
		}
		return map;
	}
	
	public List<Element> getChildsList(Element parent) {
		
		List<Element> list = new ArrayList<Element>();
		
		for (Iterator i = parent.elementIterator(); i.hasNext();) {
			Element child = (Element) i.next();
			
			list.add(child);
		}
		
		return list;
	}
	
}
