package com.gogoq.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gogoq.system.mapper.SysRoleMapper;
import com.gogoq.system.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试类
 * liufq
 */
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    //查询所有记录
    @Test
    public void findAll(){
        List<SysRole> list = sysRoleMapper.selectList(null);
        for (SysRole s: list ) {
            System.out.println(s + "============================");
        }
    }

    //添加一条记录
    @Test
    public void add(){
        SysRole s = new SysRole();
        s.setDescription("测试案例1");
        s.setRoleName("测试1");
        s.setRoleCode("1");
        int rows = sysRoleMapper.insert(s);
        System.out.println(rows);
    }

    //修改一条记录
    @Test
    public void update(){

    }
    //删除    逻辑删除
    @Test
    public void delete(){
       int rows = sysRoleMapper.deleteById("1590261037158567938");
    }

    //条件查询
    @Test
    public void select(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("id","1");
        sysRoleMapper.selectList(wrapper);
    }
}
