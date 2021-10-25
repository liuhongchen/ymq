package com.hansing.system.mapper;

import com.hansing.system.api.domain.SysCorrectionUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysCorrectionUserMapper {
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
    * @Description: 根据id,姓名查询社矫对象
    * @Param: [userId,name]
    * @return: com.hansing.system.api.domain.SysCorrectionUser
    * @Author: hlw
    * @Date: 2020/12/9-15:48
    */
    public SysCorrectionUser selectCorrectionUserById(@Param("id") Long userId,@Param("name") String name);

}
