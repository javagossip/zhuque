/*
 * Copyright 2014-2016 f2time.com All right reserved.
 */
package ai.houyi.zhuque.commons.redis;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author wangwp
 */
public class RedisTemplate {

	public static Object execute(RedisCallback callback) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedisClient();
			return callback.doRedis(jedis);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				if (jedis != null) {
					jedis.close();
				}
			} catch (Exception ex) {
				// ignore this exception
			}
		}
	}
}
