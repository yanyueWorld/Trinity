package com.trinity.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.trinity.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BaseEntity {

    private String roleName;
    private String roleCode;
    private String description;
    private Integer sortOrder;
    private Integer status;
}
