package com.imooc.cache;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.util.SafeEncoder;

public class JedisUtil {
	/**
	 * 缓存生存时间
	 */
	private final int expire = 60000;
	/** 操作Key的方法 */
	public Keys KEYS;
	/** 对存储结构为String类型的操作 */
	public Strings STRINGS;

	/** Redis连接池对象 */
	private JedisPool jedisPool;

	/**
	 * 获取redis连接池
	 * 
	 * @return
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	/**
	 * 设置redis连接池
	 * 
	 * @return
	 */
	public void setJedisPool(JedisPoolWriper jedisPoolWriper) {
		this.jedisPool = jedisPoolWriper.getJedisPool();
	}

	/**
	 * 从jedis连接池中获取获取jedis对象
	 * 
	 * @return
	 */
	public Jedis getJedis() {
		return jedisPool.getResource();
	}

	// *******************************************Keys*******************************************//
	public class Keys {

		public Keys(JedisUtil jedisUtil) {

		}

		/**
		 * 清空所有key
		 */
		public String flushAll() {
			Jedis jedis = getJedis();
			String stata = jedis.flushAll();
			jedis.close();
			return stata;
		}

		/**
		 * 删除keys对应的记录,可以是多个key
		 * 

		 *            ... keys
		 * @return 删除的记录数
		 */
		public long del(String... keys) {
			Jedis jedis = getJedis();
			long count = jedis.del(keys);
			jedis.close();
			return count;
		}

		/**
		 * 判断key是否存在

		 *            key
		 * @return boolean
		 */
		public boolean exists(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			Jedis sjedis = getJedis();
			boolean exis = sjedis.exists(key);
			sjedis.close();
			return exis;
		}
		/**
		 * 对List,Set,SortSet进行排序,如果集合数据较大应避免使用这个方法
		 *
		 * @param
		 *            key
		 * @return List<String> 集合的全部记录
		 **/
		public List<String> sort(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			Jedis sjedis = getJedis();
			List<String> list = sjedis.sort(key);
			sjedis.close();
			return list;
		}

		/**
		 * 对List,Set,SortSet进行排序或limit
		 *
		 * @param key
		 *            key
		 * @param parame
		 *            parame 定义排序类型或limit的起止位置.
		 * @return List<String> 全部或部分记录
		 **/
		public List<String> sort(String key, SortingParams parame) {
			// ShardedJedis sjedis = getShardedJedis();
			Jedis sjedis = getJedis();
			List<String> list = sjedis.sort(key, parame);
			sjedis.close();
			return list;
		}

		/**
		 * 返回指定key存储的类型
		 *
		 * @param
		 *            key
		 * @return String string|list|set|zset|hash
		 **/
		public String type(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			Jedis sjedis = getJedis();
			String type = sjedis.type(key);
			sjedis.close();
			return type;
		}
		/**
		 * 查找所有匹配给定的模式的键

		 *            key的表达式,*表示多个，？表示一个
		 */
		public Set<String> keys(String pattern) {
			Jedis jedis = getJedis();
			Set<String> set = jedis.keys(pattern);
			jedis.close();
			return set;
		}
	}

	// *******************************************Strings*******************************************//
	public class Strings {
		public Strings(JedisUtil jedisUtil) {

		}

		/**
		 * 根据key获取记录

		 * @return 值
		 */
		public String get(String key) {
			// ShardedJedis sjedis = getShardedJedis();
			Jedis sjedis = getJedis();
			String value = sjedis.get(key);
			sjedis.close();
			return value;
		}

		/**
		 * 添加记录,如果记录已存在将覆盖原有的value
		 * 

		 */
		public String set(String key, String value) {
			return set(SafeEncoder.encode(key), SafeEncoder.encode(value));
		}

		/**
		 * 添加记录,如果记录已存在将覆盖原有的value

		 * @return 状态码
		 */
		public String set(byte[] key, byte[] value) {
			Jedis jedis = getJedis();
			String status = jedis.set(key, value);
			jedis.close();
			return status;
		}

	}

}