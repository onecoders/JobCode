package com.example.setresulttest.model;

import java.io.Serializable;

public class SchoolSerializable implements Serializable {

	private static final long serialVersionUID = 850729583042935264L;

	private AlipayInfoSerializable alipay;

	// 学校id，唯一
	protected int id;
	// 学校名称
	protected String name;
	// 学校校徽图片地址
	protected String icon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public AlipayInfoSerializable getAlipayInfo() {
		return alipay;
	}

	public void setAlipayInfo(AlipayInfoSerializable alipayInfo) {
		this.alipay = alipayInfo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + this.id + "\n");
		sb.append("name:" + this.name + "\n");
		sb.append("icon:" + this.icon + "\n");
		sb.append(getAlipayInfo().toString());
		return sb.toString();
	}

}
