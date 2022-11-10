package com.gogoq.system.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gogoq.system.mapper.SysRoleMapper;
import com.gogoq.system.model.system.SysRole;
import com.gogoq.system.model.vo.SysRoleQueryVo;
import com.gogoq.system.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    //条件分页查询
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> p, SysRoleQueryVo sysRoleQueryVo) {
        IPage<SysRole> res = baseMapper.selectPage(p,sysRoleQueryVo);
        return res;
    }
}
