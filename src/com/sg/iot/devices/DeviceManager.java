/**
 * 
 */
package com.sg.iot.devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.Devices
 * @author ia
 *
 */
public class DeviceManager {
	
	private List<Device> devices = new ArrayList<Device>();

	public Device addDevice(Element deviceXML) {
		
		Device device = new Device();
		devices.add(device);
		
		return device;
	}
}
