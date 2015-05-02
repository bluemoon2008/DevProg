/**
 * 
 */
package com.sg.iot.devices;

import com.sg.iot.devices.variable.type.IType;
import com.sg.iot.devices.variable.type.TypeFactory;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.Variable
 * @author ia
 *
 */
public class Variable {

	private String name;
	private String type;
	private String format;
	private String defaultValue;
	
	public String getValue() {
		String rtn = "";
		IType var = TypeFactory.creator(type);
		
		rtn = var.getValue(format);
		
		return rtn;
	}
	
}
