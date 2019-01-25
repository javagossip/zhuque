/*
 * Copyright 2018 xcar.com.cn All right reserved.
 */
package ai.houyi.zhuque.commons.redis;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author weiping wang
 *
 */
@XmlType(propOrder = {})
@XmlRootElement(name = "redis-profile")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedisConfig {
	@Override
	public String toString() {
		return "RedisConfig [id=" + id + ", address=" + address + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle
				+ ", minIdle=" + minIdle + ", sharding=" + sharding + ", connectTimeout=" + connectTimeout
				+ ", soTimeout=" + soTimeout + ", auth=" + auth + ", db=" + db + "]";
	}

	private String id;
	private String address;
	private int maxActive;
	private int maxIdle;
	private int minIdle;
	private boolean sharding;
	private int connectTimeout;
	private int soTimeout;
	private String auth;
	private int db;

	public RedisConfig() {
	}
	
	public RedisConfig(String id,String address,int maxActive) {
		this(id,address,maxActive,maxActive,0,false,3000,50,null,0);
	}
	
	public RedisConfig(String id, String address, int maxActive, int maxIdle, int minIdle, boolean sharding,
			int connectTimeout, int soTimeout, String auth, int db) {
		super();
		this.id = id;
		this.address = address;
		this.maxActive = maxActive;
		this.maxIdle = maxIdle;
		this.minIdle = minIdle;
		this.sharding = sharding;
		this.connectTimeout = connectTimeout;
		this.soTimeout = soTimeout;
		this.auth = auth;
		this.db = db;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public boolean isSharding() {
		return sharding;
	}

	public void setSharding(boolean sharding) {
		this.sharding = sharding;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	
}
