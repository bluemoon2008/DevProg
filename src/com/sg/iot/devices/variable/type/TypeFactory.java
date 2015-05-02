/**
 * 
 */
package com.sg.iot.devices.variable.type;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.variable.type.TypeFactory
 * @author ia
 *
 */
public class TypeFactory {
	
	public final static String DATETYPE = "date";
	
	public static IType creator(String type) {
		
		if (DATETYPE.equals(type)) {
			return new DateType();
		}
		
		return null;
	}

}
