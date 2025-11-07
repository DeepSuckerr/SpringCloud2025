package com.wsj.apis.config;

import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object>  template =new RedisTemplate<>();
        ObjectMapper om= new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        GenericJackson2JsonRedisSerializer jsonserializer = new GenericJackson2JsonRedisSerializer();
        template.setConnectionFactory(factory);
        RedisSerializer<String> redisSerializer =new StringRedisSerializer();
        // 设置 key 和  value的序列化 规则
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(jsonserializer);
        // 设置 hash key  和 hash value的序列化 规则
        template.setHashKeySerializer(redisSerializer);
        template.setHashValueSerializer(jsonserializer);
        return  template;
    }
}
