package com.hansing.system.service.impl;

import com.hansing.system.api.domain.SysCorrectionUser;
import com.hansing.system.api.domain.SysDept;
import com.hansing.system.domain.vo.TreeSelect;
import com.hansing.system.mapper.SysCorrectionUserMapper;
import com.hansing.system.service.ISysCorrectionUserService;
import com.hansing.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class SysCorrectionUserServiceImpl implements ISysCorrectionUserService {

    @Autowired
    private SysCorrectionUserMapper cuserMapper;

    @Autowired
    private ISysDeptService deptService;

    @Override
    public List<SysCorrectionUser> selectCorrectionUserList() {
        return cuserMapper.selectCorrectionUserList();
    }

    @Override
    public List<SysCorrectionUser> selectCorrectionUserByDeptId(Long deptId) {
        return cuserMapper.selectCorrectionUserByDeptId(deptId);
    }

    @Override
    public List<TreeSelect> buildDeptAndCorrectionUserTreeSelect(List<SysDept> depts) {
        List<TreeSelect> treeSelects = deptService.buildDeptTreeSelect(depts);
        appendCorrectionUser(treeSelects);
        return  treeSelects;

    }

    /**
     * @Description: 根据id, 姓名查询社矫对象
     * @Param: [userId, name]
     * @return: com.hansing.system.api.domain.SysCorrectionUser
     * @Author: hlw
     * @Date: 2020/12/9-15:48
     */
    @Override
    public SysCorrectionUser selectCorrectionUserById(Long id, String name) {
        return cuserMapper.selectCorrectionUserById(id , name);
    }

    private void appendCorrectionUser(List<TreeSelect> dept){
        System.out.println(dept.get(0));
        recusion(dept.get(0));

    }

    private void recusion(TreeSelect tree){
        List<SysCorrectionUser> sysCorrectionUsers = cuserMapper.selectCorrectionUserByDeptId(tree.getId());
        List<TreeSelect> cuserTree = sysCorrectionUsers.stream().map(TreeSelect::new).collect(Collectors.toList());
        if(tree.getChildren() == null){
            tree.setChildren(cuserTree);
        }
        else {
            List<TreeSelect> temp = tree.getChildren();
            temp.addAll(cuserTree);
            tree.setChildren(temp);
        }
        if(tree.getChildren() == null || tree.getChildren().size() <= 0)
        {
            System.out.println(tree.getId() + "" + tree.getLabel());
            return;
        }

        for(TreeSelect i : tree.getChildren()){
            recusion(i);
        }


    }

}
