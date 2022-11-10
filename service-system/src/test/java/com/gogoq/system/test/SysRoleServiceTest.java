package com.gogoq.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gogoq.system.model.system.SysRole;
import com.gogoq.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 服务测试
 */
@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;

    //查找
    @Test
    public void findAll(){
        List<SysRole> list = sysRoleService.list();//调用服务进行查询
       /*
        sysRoleService.save();//添加
        sysRoleService.updateById();//修改
        sysRoleService.removeById();//删除

        //条件查询 删除修改同理
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("","");
        sysRoleService.list(wrapper);
        */

        for (SysRole s : list) {
            System.out.println(s+"++++++++++++++++++++++++++++++++++++++++++");

        }
    }

}
