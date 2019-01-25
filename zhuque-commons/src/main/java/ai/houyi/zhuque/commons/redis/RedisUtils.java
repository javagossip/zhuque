/*
 * Copyright 2018 xcar.com.cn All right reserved.
 */
package ai.houyi.zhuque.commons.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import ai.houyi.zhuque.commons.Constants;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Pool;

/**
 * @author weiping wang
 *
 */
public class RedisUtils {
	private static final Map<String, Pool<?>> redis_pool_holder = new HashMap<>();
	private static JedisPool default_pool;

	static {
		RedisConfiguration config = RedisConfiguration.create();
		config.getRedisConfigList().forEach(rc -> {
			redis_pool_holder.put(rc.getId(), initRedisPool(rc));
		});

		default_pool = (JedisPool) redis_pool_holder.get("default");
	}

	@SuppressWarnings("rawtypes")
	private static Pool<?> initRedisPool(RedisConfig rc) {
		Pool<?> redisPool = null;

		GenericObjectPoolConfig poolConfig = buildPoolConfig(rc);
		boolean isSharding = rc.isSharding();
		if (isSharding) {
			redisPool = new ShardedJedisPool(poolConfig, buildShards(rc));
		} else {
			HostAndPort hap = HostAndPort.parseString(rc.getAddress());
			redisPool = new JedisPool(poolConfig, hap.getHost(), hap.getPort(), rc.getConnectTimeout(),
					rc.getSoTimeout(), rc.getAuth(), rc.getDb(), null, false, null, null, null);
		}
		return redisPool;
	}

	private static List<JedisShardInfo> buildShards(RedisConfig rc) {
		String[] redisServers = StringUtils.split(rc.getAddress(), Constants.SIGN_COMMA);
		List<JedisShardInfo> shards = new ArrayList<>();
		for (String redisServer : redisServers) {
			JedisShardInfo shard = new JedisShardInfo(String.format("redis://%s/%d", redisServer, rc.getDb()));
			shard.setConnectionTimeout(rc.getConnectTimeout());
			shard.setSoTimeout(rc.getSoTimeout());
			if (StringUtils.isNotBlank(rc.getAuth())) {
				shard.setPassword(rc.getAuth());
			}
			shards.add(shard);
		}
		return shards;
	}

	@SuppressWarnings("rawtypes")
	private static GenericObjectPoolConfig buildPoolConfig(RedisConfig rc) {
		GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(rc.getMaxActive());
		poolConfig.setMaxIdle(rc.getMaxActive());
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestWhileIdle(true);

		return poolConfig;
	}

	public static Jedis getRedisClient() {
		return default_pool.getResource();
	}
}
