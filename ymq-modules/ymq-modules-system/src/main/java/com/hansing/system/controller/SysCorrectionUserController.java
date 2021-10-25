package com.hansing.system.controller;


import com.hansing.common.core.web.controller.BaseController;
import com.hansing.common.core.web.domain.AjaxResult;
import com.hansing.common.security.annotation.PreAuthorize;
import com.hansing.system.api.domain.SysCorrectionUser;
import com.hansing.system.api.domain.SysDept;
import com.hansing.system.domain.vo.TreeSelect;
import com.hansing.system.service.ISysCorrectionUserService;
import com.hansing.system.service.ISysDeptService;
import com.hansing.system.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correctionuser")
public class SysCorrectionUserController extends BaseController {

    @Autowired
    private ISysCorrectionUserService cuserService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysPermissionService permissionService;

    @PreAuthorize(hasPermi = "system:user:list")
    @GetMapping("/list")
    public AjaxResult list()
    {
        List<SysCorrectionUser> list = cuserService.selectCorrectionUserList();
        return AjaxResult.success(list);
    }

    @GetMapping("/correctionUserTreeSelect")
    public AjaxResult treeselect(SysDept dept){
        List<SysDept> depts = deptService.selectDeptList(dept);
        List<TreeSelect> treeSelects = cuserService.buildDeptAndCorrectionUserTreeSelect(depts);
        return AjaxResult.success(treeSelects);
    }

    @GetMapping("/correctionuser/{id}")
    public AjaxResult correctionuser(@PathVariable("id") Long id, @RequestParam(name = "name") String name){
        SysCorrectionUser sysCorrectionUser = cuserService.selectCorrectionUserById(id, name);
        return AjaxResult.success(sysCorrectionUser);
    }


}
