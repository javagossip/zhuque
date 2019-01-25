/*
 * Copyright 2018 xcar.com.cn All right reserved.
 */
package ai.houyi.zhuque.commons.redis;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ai.houyi.zhuque.commons.ClassLoaderUtils;

/**
 * @author weiping wang
 *
 */
@XmlType(propOrder = {})
@XmlRootElement(name = "redis-profiles")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedisConfiguration {
	@XmlElement(name = "redis-profile")
	private List<RedisConfig> redisConfigList = new ArrayList<>();
	private Map<String, RedisConfig> redisConfigHolder;

	public RedisConfiguration() {
		this.redisConfigList = new ArrayList<>();
		this.redisConfigHolder = new HashMap<>();
	}

	public List<RedisConfig> getRedisConfigList() {
		return redisConfigList;
	}

	public void addRedisConfig(RedisConfig config) {
		redisConfigList.add(config);
		redisConfigHolder.put(config.getId(), config);
	}

	public RedisConfig getRedisConfig(String profileId) {
		return redisConfigHolder.get(profileId);
	}

	@Override
	public String toString() {
		return "RedisConfiguration [redisConfigList=" + redisConfigList + "]";
	}

	public static RedisConfiguration create(String redisConfigFile) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(RedisConfiguration.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			RedisConfiguration redisConfiguration = (RedisConfiguration) unmarshaller
					.unmarshal(ClassLoaderUtils.getStream(redisConfigFile));
			return redisConfiguration;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static RedisConfiguration create() {
		return create("redis.cfg.xml");
	}

	public static void main(String[] args) throws Exception {
		RedisConfiguration redisConfiguration = new RedisConfiguration();
		redisConfiguration.addRedisConfig(new RedisConfig("default", "127.0.0.1:2917", 10));

		File file = new File("d:\\redis.cfg.xml");
//		JAXBContext jaxbContext = JAXBContext.newInstance(RedisConfiguration.class);
//		Marshaller marshaller = jaxbContext.createMarshaller();
//		// 格式化输出，即按标签自动换行，否则就是一行输出
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		// 设置编码（默认编码就是utf-8）
//		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//		// 是否省略xml头信息，默认不省略（false）
//		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
//		marshaller.marshal(redisConfiguration, file);

		JAXBContext jaxbContext = JAXBContext.newInstance(RedisConfiguration.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		RedisConfiguration user = (RedisConfiguration) unmarshaller.unmarshal(file);
		System.out.println(user.toString());
	}
}
