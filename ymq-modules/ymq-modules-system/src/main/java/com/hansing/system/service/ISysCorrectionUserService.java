package com.hansing.system.service;

import com.hansing.system.api.domain.SysCorrectionUser;
import com.hansing.system.api.domain.SysDept;
import com.hansing.system.domain.vo.TreeSelect;

import java.util.List;

public interface ISysCorrectionUserService {
    /**
     * 根据条件分页查询用户列表
     * @return 用户信息集合信息
     */
    public List<SysCorrectionUser> selectCorrectionUserList();


    /**
     * 根据部门查询社矫对象
     * @return 特定社矫对象
     */
    public List<SysCorrectionUser> selectCorrectionUserByDeptId(Long deptId);

    /**
    * @Description: 将社矫对象加入部门树
    * @Param:
    * @return:  List<TreeSelect>
    * @Author: hlw
    * @Date: 2020/12/5-15:51
    */
    public List<TreeSelect> buildDeptAndCorrectionUserTreeSelect(List<SysDept> depts);

    /**
     * @Description: 根据id,姓名查询社矫对象
     * @Param: [userId,name]
     * @return: com.hansing.system.api.domain.SysCorrectionUser
     * @Author: hlw
     * @Date: 2020/12/9-15:48
     */
    public SysCorrectionUser selectCorrectionUserById(Long id, String name);




}
