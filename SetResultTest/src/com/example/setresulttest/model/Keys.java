/*
 * Copyright (C) 2010 The MobileSecurePay Project
 * All right reserved.
 * author: shiqun.shi@alipay.com
 * 
 *  提示：如何获取安全校验码和合作身份者id
 *  1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *  2.点击“商家服务”(https://b.alipay.com/order/myorder.htm)
 *  3.点击“查询合作者身份(pid)”、“查询安全校验码(key)”
 */

package com.example.setresulttest.model;

//
// 请参考 Android平台安全支付服务(msp)应用开发接口(4.2 RSA算法签名)部分，并使用压缩包中的openssl RSA密钥生成工具，生成一套RSA公私钥。
// 这里签名时，只需要使用生成的RSA私钥。
// Note: 为安全起见，使用RSA私钥进行签名的操作过程，应该尽量放到商家服务器端去进行。
public final class Keys {

	// 合作身份者id，以2088开头的16位纯数字
	public static final String DEFAULT_PARTNER = "2088211178228932";

	// 收款支付宝账号
	public static final String DEFAULT_SELLER = "2088211178228932";

	// 商户私钥，自助生成
	public static final String PRIVATE = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALSh3KLj/m07nqvehbgL5guYN+gagUQ7zTWME9N62Bf7EmHknWK0momVIGTxZ97eCtq2bg19j1/As2/IGqUzIGHdEw/cQY91a7GPMWNbPIVFj7LoiVnwTpEpEa3y4aE5JenwvfTpj8/Ge9l14N8b+h8xngbz+A4FCaR/u+GEmZmdAgMBAAECgYEAsYarK8Rb18tSpKPsU/gNvbN6rrjt9ru3cTsceSowm1D8vg1LySirATD5R3wik90yWcYV31hZwsfHEsNdvKLE3QMO2m9WrDCukzD+9jA1OWu4GOQUh91r6PyV02RPmd9VOhqu3LCirVsKr9CZXuXi6F1hC2lUWDeejdK5m3AJMsECQQDY/WiqdjISXkemdGKGOZcPneqyY6KfAkaRph6UTSKCV56TX+ltUWHRZCAeCxQHmx7jN5Bn2RWc4kwy6NBlueEFAkEA1Rsn57p7mpr+xe/G+VthoKefaoi2zxvjSIfBaIlLQ5JYPhmM17dmCo4VFAprDLuZVznfofVDahspRK3PFMKZuQJBAMg2mbqfMHhOUaI+xSHARaf9N669zDEXcnG1a4W+3laR7hlhaAqcCrufvRq7chHKiWdxv2ZyoUSOcWyP8KnMJtkCQQCLlq4c69nq+3vGy7jZvTHFugaCEess3meSKtpVTxktub5zbukCo+8DGu5Toj9cp8VZjV8fBziRWBlAE1mBj7aBAkBRtSumAc05671IJLznJzeCpDjeON6eGwFz3tWaxX1gfYUxpfHBW81YjPiC/ImgOceD3Juc2E6ayX1+uDu3f7Yk";

	public static final String PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

}
