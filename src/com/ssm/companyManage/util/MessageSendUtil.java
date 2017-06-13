package com.ssm.companyManage.util;


public class MessageSendUtil {
	
    /**
     * 获取验证码
     */
	public static String getWord() throws Exception{
		String word  = (int)((Math.random()*9+1)*100000)+"";
	    return word;
	}
}
