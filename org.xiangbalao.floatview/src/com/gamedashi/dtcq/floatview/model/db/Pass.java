package com.gamedashi.dtcq.floatview.model.db;

public class Pass {

	private Integer id;
	private String name;
	private Integer instanceid;
	private Integer costCon;
	private Integer getExp;
	private Integer getMoney;
	private  Integer type;
	private String glurl;
	private String icon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInstanceid() {
		return instanceid;
	}
	public void setInstanceid(Integer instanceid) {
		this.instanceid = instanceid;
	}
	public Integer getCostCon() {
		return costCon;
	}
	public void setCostCon(Integer costCon) {
		this.costCon = costCon;
	}
	public Integer getGetExp() {
		return getExp;
	}
	public void setGetExp(Integer getExp) {
		this.getExp = getExp;
	}
	public Integer getGetMoney() {
		return getMoney;
	}
	public void setGetMoney(Integer getMoney) {
		this.getMoney = getMoney;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getGlurl() {
		return glurl;
	}
	public void setGlurl(String glurl) {
		this.glurl = glurl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Pass [id=" + id + ", name=" + name + ", instanceid="
				+ instanceid + ", costCon=" + costCon + ", getExp=" + getExp
				+ ", getMoney=" + getMoney + ", type=" + type + ", glurl="
				+ glurl + ", icon=" + icon + "]";
	}
	public Pass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
	
	
}
