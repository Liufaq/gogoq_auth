package com.gogoq.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gogoq.system.mapper.SysRoleMapper;
import com.gogoq.system.model.system.SysRole;
import com.gogoq.system.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
