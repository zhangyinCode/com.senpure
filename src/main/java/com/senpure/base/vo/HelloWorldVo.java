package com.senpure.base.vo;

import java.io.Serializable;
import java.util.Date;
public class HelloWorldVo implements Serializable {
	private static final long serialVersionUID = 1486464399997L;


	private	Integer id;
	private	String str;
	private	int number;
	private	int version;

	public Integer getId() {
		return id;
	}


	public	void setId(Integer id) {
		this.id=id ;
	}

	public String getStr() {
		return str;
	}


	public	void setStr(String str) {
		this.str=str ;
	}

	public int getNumber() {
		return number;
	}


	public	void setNumber(int number) {
		this.number=number ;
	}

	public int getVersion() {
		return version;
	}


	public	void setVersion(int version) {
		this.version=version ;
	}

}