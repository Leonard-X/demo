package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    /**
     * 查询品牌集合数据
     */
    List<Brand> findAll();

    /**
     * 根据ID查询商品
     */
    Brand findById(Integer id);

    /**
     * 增加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据ID修改品牌
     */
    void update(Brand brand);

    /**
     * 根据ID删除商品
     */
    void delete(Integer id);

    /**
     * 1.根据品牌查询
     * 2.根据首字母查询
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页
     * @param page:当前页
     * @param size:每页显示的条数
     * @return
     */
    PageInfo<Brand> findPage(Integer page,Integer size);

    /**
     * 条件查询+分页
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);


}
