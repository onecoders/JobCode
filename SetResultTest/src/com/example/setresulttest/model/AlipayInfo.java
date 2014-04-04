package com.example.setresulttest.model;

public abstract class AlipayInfo {

	// 合作身份者id，以2088开头的16位纯数字
	protected String partnerId;
	// 收款支付宝账号
	protected String sellerAccount;
	// 商户私钥，自助生成
	protected String privateKey;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getSellerAccount() {
		return sellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("partnerId:" + this.partnerId + "\n");
		sb.append("sellerAccount:" + this.sellerAccount + "\n");
		sb.append("privateKey:" + this.privateKey);
		return sb.toString();
	}
}
