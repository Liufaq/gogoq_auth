package com.gogoq.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gogoq.system.model.system.SysRole;
import com.gogoq.system.model.vo.SysRoleQueryVo;

public interface SysRoleService extends IService<SysRole> {
    //条件分页查询寻
    IPage<SysRole> selectPage(Page<SysRole> p, SysRoleQueryVo sysRoleQueryVo);
}
