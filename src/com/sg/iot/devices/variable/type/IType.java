/**
 * 
 */
package com.sg.iot.devices.variable.type;

/**
 * 功能描述：
 *
 * @category: com.sg.iot.devices.variable.type.IType
 * @author ia
 *
 */
public interface IType {
	
	public void setFormat(String format);
	
	public String getValue(String format);

}
