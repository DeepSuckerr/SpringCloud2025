package com.wsj.music.controller;

import com.wsj.apis.commons.Result;
import com.wsj.music.service.MusicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
@Tag(name = "音乐服务模块")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/getAll")
    @Operation(summary = "查询所有音乐")
    public Result findAllMusic() {
        return musicService.findAllMusic();
    }
}
