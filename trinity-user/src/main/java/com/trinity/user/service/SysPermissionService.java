package com.trinity.user.service;

import com.trinity.common.service.BaseService;
import com.trinity.user.entity.SysPermission;
import com.trinity.user.mapper.SysPermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionService extends BaseService<SysPermissionMapper, SysPermission> {

    /** 获取树形权限列表（按 parentId=0 查根节点，前端自行递归） */
    public List<SysPermission> listTree() {
        return list();
    }
}
