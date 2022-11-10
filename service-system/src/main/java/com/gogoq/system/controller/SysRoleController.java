package com.gogoq.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gogoq.common.result.Result;
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
}
