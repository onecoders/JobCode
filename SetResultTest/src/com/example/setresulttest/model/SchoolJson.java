package com.example.setresulttest.model;

public class SchoolJson extends School {

	private AlipayInfoJson alipayInfo;

	@Override
	public AlipayInfo getAlipayInfo() {
		return this.alipayInfo;
	}

	@Override
	public void setAlipayInfo(AlipayInfo alipayInfo) {
		if (alipayInfo instanceof AlipayInfoJson) {
			this.alipayInfo = (AlipayInfoJson) alipayInfo;
		}
	}
}
