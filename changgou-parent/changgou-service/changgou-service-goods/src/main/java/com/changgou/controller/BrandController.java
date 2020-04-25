package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin//跨域
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll(){
        //查询所有品牌
        List<Brand> brands = brandService.findAll();
        //响应结果封装
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌集合数据成功",brands);
    }

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findById(id);

        return new Result<Brand>(true,StatusCode.OK,"根据ID查数据成功",brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功");

    }

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Brand brand){
        brand.setId(id);//把品牌id给brand以后，就可以根据id定位到修改的品牌，然后修改掉
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功！",brand);
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功！");
    }

    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"条件查询成功！",brands);
    }

    @GetMapping(value = "/search/{page}/{size}")
    public Result<List<Brand>> findPage(@PathVariable Integer page,@PathVariable Integer size){
        PageInfo<Brand> page1 = brandService.findPage(page, size);
        return new Result<List<Brand>>(true,StatusCode.OK,"分页查询成功！",page1);

    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result<List<Brand>> findPage(@RequestBody Brand brand,@PathVariable Integer page,@PathVariable Integer size){
        PageInfo<Brand> page1 = brandService.findPage(brand,page, size);
        return new Result<List<Brand>>(true,StatusCode.OK,"分页查询商品成功！",page1);

    }
}
