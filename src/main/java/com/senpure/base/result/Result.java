package com.senpure.base.result;

import com.senpure.base.annotation.Message;

import java.io.Serializable;


public abstract interface Result extends Serializable {


	@Message(message = "失败")
	public static final int FAILURE = 0;
	@Message(message = "成功")
	public static final int SUCCESS = 1;

	@Message(message = "未知错误")
	public static final int ERROR_UNKNOWN = 10;
	@Message(message = "服务器发送错误")
	public static final int ERROR_SERVER= 11;
	@Message(message ="服务器繁忙，请稍后再试")
	public static final int ERROR_DIM= 12;

	@Message
	public static final int ACCOUNT_ALREADY_EXISTS = 100;
	@Message
	public static final int ACCOUNT_NOT_EXIST = 101;
	@Message
	public static final int ACCOUNT_BANED = 102;
	@Message
	public static final int PASSWORD_INCORRECT = 103;
	@Message
	public static final int FORMAT_INCORRECT = 104;
	@Message
	public static final int ACCOUNT_OTHER_LOGIN = 105;
	@Message
	public static final int ACCOUNT_NOT_LOGIN = 106;
	@Message
	public static final int ACCOUNT_NOT_LOGIN_OR_SESSION_TIMEOUT = 107;
	
	


	

}
