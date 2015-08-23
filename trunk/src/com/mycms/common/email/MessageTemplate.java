package com.mycms.common.email;

/**
 * 邮件模板
 * 
 * 
 * 
 */
public interface MessageTemplate {
	/**
	 * 邮件主题
	 * 
	 * @return
	 */
	public String getSubject();

	/**
	 * 邮件内容
	 * 
	 * @return
	 */
	public String getText();
}
