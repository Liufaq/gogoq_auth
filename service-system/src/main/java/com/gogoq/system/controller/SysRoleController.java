package com.gogoq.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gogoq.common.result.Result;
import com.gogoq.system.exception.GogoqException;
import com.gogoq.system.mapper.SysRoleMapper;
import com.gogoq.system.model.system.SysRole;
import com.gogoq.system.model.vo.SysRoleQueryVo;
import com.gogoq.system.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 */
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    //注入service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有记录
    @ApiOperation("查询所有记录接口")
    @GetMapping("findAll")
    public Result findAllRole(){
        //调用service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    //逻辑删除
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id){
        boolean res = sysRoleService.removeById(id);
        if(res){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //条件分页查询
    //page 当前页  limit 每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result selectByPage(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo) {

       Page<SysRole> p = new Page<>(page, limit);
        IPage<SysRole> res = sysRoleService.selectPage(p,sysRoleQueryVo);
        //返回
        return Result.ok(res);
    }

    //添加角色
    //@RequestBody 不能使用get提交
    //传递用JSON格式 吧JSON格式封装到对象里面
    @ApiOperation("添加")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole){

    boolean isSuccess = sysRoleService.save(sysRole);
    if(isSuccess){
        return Result.ok();
    }else{
        return Result.fail();
    }

    }

    //修改接口  根据ID查询
    @ApiOperation("根据ID查询结果")
    @PostMapping("findById/{id}")
    public Result findById(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }
    //修改接口 修改内容
    @ApiOperation("修改内容")
    @PostMapping("update")
    public Result updateById(@RequestBody SysRole sysRole){
        boolean isScuss = sysRoleService.updateById(sysRole);
        if(isScuss){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }


    //批量删除
    //多个ID{1,2,3,4} json 的数组格式对应java的集合
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        try {
            int a = 9/0;
        }catch (Exception e){
           throw new GogoqException(20001,"自定义异常");
        }

        sysRoleService.removeByIds(idList);
        return Result.ok();
    }


}
