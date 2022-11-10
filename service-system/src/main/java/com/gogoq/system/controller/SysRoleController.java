package com.gogoq.system.controller;

import com.gogoq.system.model.system.SysRole;
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
    public List<SysRole> findAllRole(){
        //调用service
        List<SysRole> list = sysRoleService.list();
        return list;
    }

    //逻辑删除
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public boolean removeRole(@PathVariable Long id){
        boolean b = sysRoleService.removeById(id);
        return b;
    }


}
