package com.gogoq.system;

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
}
