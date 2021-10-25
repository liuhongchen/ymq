package com.hansing.system.service.impl;

import com.hansing.system.api.domain.SysDept;
import com.hansing.system.domain.vo.TreeSelect;
import com.hansing.system.mapper.SysCorrectionUserMapper;
import com.hansing.system.service.ISysCorrectionUserService;
import com.hansing.system.service.ISysDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: hansing
 * @description: 测试
 * @author: 作者名字
 * @create: 2020-12-05 18:08
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class tesst {
    @Autowired
    private SysCorrectionUserMapper cuserMapper;
    @Autowired
    private ISysCorrectionUserService userService;

    @Autowired
    private ISysDeptService deptService;
    @Test
    public void test(){
        List<SysDept> sysDepts = deptService.selectDeptList(new SysDept());
        List<TreeSelect> treeSelects = userService.buildDeptAndCorrectionUserTreeSelect(sysDepts);
        System.out.println(sysDepts);
    }
}
