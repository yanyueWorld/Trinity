package com.trinity.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.trinity.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 系统用户 — 对应 sys_user 表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /** 用户名 */
    private String username;

    /** 密码（加密） */
    private String password;

    /** 真实姓名 */
    private String realName;

    /** 头像 */
    private String avatar;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String phone;

    /** 性别：0-未知 1-男 2-女 */
    private Integer gender;

    /** 部门ID */
    private Long deptId;

    /** 状态：0-禁用 1-启用 */
    private Integer status;

    /** 备注 */
    private String remark;

    /** 最后登录时间 */
    private LocalDateTime lastLoginTime;
}
