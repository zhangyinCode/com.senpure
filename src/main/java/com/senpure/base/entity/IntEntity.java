package com.senpure.base.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IntEntity  extends VersionEntity  {

	private static final long serialVersionUID = 7719639280400675479L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}







}
