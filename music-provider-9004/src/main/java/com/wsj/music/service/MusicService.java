package com.wsj.music.service;

import com.wsj.apis.DTO.MusicDTO;

import java.util.List;

public interface MusicService {


    List<MusicDTO> selectAll();
}

