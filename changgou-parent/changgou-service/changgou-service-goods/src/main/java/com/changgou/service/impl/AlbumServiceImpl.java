package com.changgou.service.impl;

import com.changgou.dao.AlbumMapper;
import com.changgou.goods.pojo.Album;
import com.changgou.service.AlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> findAll() {
        return albumMapper.selectAll();
    }

    @Override
    public Album findById(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Album album) {
        albumMapper.insertSelective(album);

    }

    @Override
    public void update(Album album) {
        albumMapper.updateByPrimaryKeySelective(album);
    }

    @Override
    public void delete(Integer id) {
        albumMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<Album> findList(Album album) {
        Example example = createExample(album);
        return albumMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Album> findPage(Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //集合查询
        List<Album> albums = albumMapper.selectAll();
        return new PageInfo<Album>(albums);
    }


    @Override
    public PageInfo<Album> findPage(Album album, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Example example = createExample(album);
        List<Album> albums = albumMapper.selectByExample(example);
        //封装进PageInfo
        return new PageInfo<Album>(albums);
    }

    public Example createExample(Album album){
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if (album != null){
            if (!StringUtils.isEmpty(album.getTitle())){
                criteria.andLike("title","%"+album.getTitle()+"%");
            }
        }
        return example;
    }
}
