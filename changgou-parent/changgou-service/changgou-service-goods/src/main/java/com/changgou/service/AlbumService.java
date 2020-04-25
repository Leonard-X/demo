package com.changgou.service;

import com.changgou.dao.AlbumMapper;
import com.changgou.goods.pojo.Album;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AlbumService {
    /**
     * 查询
     */
    List<Album> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Album findById(Integer id);

    /**
     * 添加
     * @param album
     */
    void add(Album album);

    /**
     * 修改
     * @param album
     */
    void update(Album album);

    /**
     * 删除
     */
    void delete(Integer id);

    /**
     * 根据相册名称查询
     * @param album
     * @return
     */
    List<Album> findList(Album album);

    /**
     * 分页
     * @param page 当前页数
     * @param size 每页显示的条数
     * @return
     */
    PageInfo<Album> findPage(Integer page,Integer size);

    /**
     * 条件查询+分页
     * @param album
     * @param page
     * @param size
     * @return
     */
    PageInfo<Album> findPage(Album album,Integer page,Integer size);
}
