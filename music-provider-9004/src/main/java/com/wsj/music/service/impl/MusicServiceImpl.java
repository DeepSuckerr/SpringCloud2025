package com.wsj.music.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsj.apis.commons.Result;
import com.wsj.apis.pojo.Music;
import com.wsj.music.mapper.MusicMapper;
import com.wsj.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicMapper musicMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public static final String ALL_MUSIC_KEY = "music:all";

    @Override
    public Result findAllMusic() {
        // 1. 从Redis查询缓存
        String musicJson = redisTemplate.opsForValue().get(ALL_MUSIC_KEY);

        // 2. 判断缓存是否存在
        if (StringUtils.hasText(musicJson)) {
            // 存在，直接反序列化后返回
            try {
                List<Music> musicList = objectMapper.readValue(musicJson,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Music.class));
                return new Result("从Redis查询成功", 200, musicList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // 3. 缓存不存在，查询数据库
        List<Music> musicList = musicMapper.findAllMusic();

        // 4. 数据库中不存在，返回错误信息
        if (musicList == null || musicList.isEmpty()) {
            return new Result("未找到任何音乐信息", 500, null);
        }

        // 5. 数据库中存在，将数据写入Redis
        try {
            String json = objectMapper.writeValueAsString(musicList);
            // 写入Redis并设置30分钟过期时间
            redisTemplate.opsForValue().set(ALL_MUSIC_KEY, json, 30, TimeUnit.MINUTES);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 6. 返回从数据库查询到的结果
        return new Result("从数据库查询成功", 200, musicList);
    }
}
