package com.hansing.system.api.domain;

import com.hansing.common.core.annotation.Excel;
import com.hansing.common.core.annotation.Excel.ColumnType;
import com.hansing.common.core.annotation.Excel.Type;
import com.hansing.common.core.annotation.Excels;
import com.hansing.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.Size;


//矫正对象实体类


public class SysCorrectionUser extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long correctionUserId;

    /** 所属部门ID */
    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long deptId;

    /** imei号 */
    private Long imei;

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    /** 用户账号 */
    @Excel(name = "矫正对象姓名")
    private String cuserName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String gender;
    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 部门对象 */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    public SysCorrectionUser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return correctionUserId;
    }

    public void setUserId(Long correctionUserId) {
        this.correctionUserId = correctionUserId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return cuserName;
    }

    public void setUserName(String cuserName) {
        this.cuserName = cuserName;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("correctionUserId", correctionUserId)
                .append("deptId", deptId)
                .append("imei", imei)
                .append("cuserName", cuserName)
                .append("phonenumber", phonenumber)
                .append("gender", gender)
                .append("status", status)
                .append("delFlag", delFlag)
                .append("dept", dept)
                .toString();
    }
}

