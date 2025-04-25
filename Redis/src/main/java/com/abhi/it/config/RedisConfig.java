package com.abhi.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.abhi.it.binding.Countries;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory jedisConfig() {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		//Redis server properties
		return jedis;
	}
	
	@Bean
	public RedisTemplate<String, Countries> redisTemplate(){
		RedisTemplate<String, Countries> rt = new RedisTemplate<String, Countries>();
		rt.setConnectionFactory(jedisConfig());
		return rt;
	}
}
