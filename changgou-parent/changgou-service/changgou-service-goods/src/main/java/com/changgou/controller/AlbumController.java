package com.changgou.controller;

import com.changgou.goods.pojo.Album;
import com.changgou.service.AlbumService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public Result<List<Album>> findAll(){
        albumService.findAll();
        return new Result<List<Album>>(true, StatusCode.OK,"查询相册名称成功！");
    }

    @GetMapping(value = "/{id}")
    public Result<Album> findById(@PathVariable Integer id){
        Album album = albumService.findById(id);
        return new Result<Album>(true,StatusCode.OK,"通过id查询成功！",album);
    }

    @PostMapping
    public Result add(@RequestBody Album album){
        albumService.add(album);
        return new Result(true,StatusCode.OK,"添加相册成功！");
    }

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Album album){
        album.setId(id);
        albumService.update(album);
        return new Result(true,StatusCode.OK,"修改相册成功！",album);
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
        albumService.delete(id);
        return new Result(true,StatusCode.OK,"删除相册成功！");
    }

    @PostMapping(value = "/search")
    public Result<List<Album>> findList(@RequestBody Album album){
        List<Album> brands = albumService.findList(album);
        return new Result<List<Album>>(true,StatusCode.OK,"条件查询成功！",brands);
    }

}
