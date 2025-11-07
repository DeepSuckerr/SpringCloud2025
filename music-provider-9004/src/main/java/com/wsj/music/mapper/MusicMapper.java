package com.wsj.music.mapper;

import com.wsj.apis.pojo.Music;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MusicMapper {


    List<Music> findAllMusic();



    


}

