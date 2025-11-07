package com.wsj.apis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 音乐实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Music {

    /**
     * 音乐ID，主键
     */
    private Integer musicId;

    /**
     * 对应的用户ID (歌手)
     */
    private Integer fromSinger;

    /**
     * 歌曲名
     */
    private String musicName;

    /**
     * 歌曲地址 (对应UUID名)
     */
    private String musicUrl;

    /**
     * 是否激活 (0:激活, 1:用户锁定, 2:管理员锁定)
     */
    private Integer activation;

    /**
     * 播放量
     */
    private Integer listenNumb;

    /**
     * 封面图片地址
     */
    private String imageUrl;

    /**
     * 时长 (单位:秒)
     */
    private Integer timelength;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 标签
     */
    private String tags;

    /**
     * 歌词
     */
    private String lyric;
}