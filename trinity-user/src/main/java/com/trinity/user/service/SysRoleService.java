package com.trinity.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trinity.user.entity.SysRole;
import com.trinity.user.entity.SysRolePermission;
import com.trinity.user.mapper.SysRoleMapper;
import com.trinity.user.mapper.SysRolePermissionMapper;
import com.trinity.common.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleService extends BaseService<SysRoleMapper, SysRole> {

    private final SysRolePermissionMapper rolePermissionMapper;

    public SysRoleService(SysRolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Transactional
    public void assignPermissions(Long roleId, List<Long> permIds) {
        // 先删后增
        LambdaQueryWrapper<SysRolePermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRolePermission::getRoleId, roleId);
        rolePermissionMapper.delete(wrapper);

        for (Long permId : permIds) {
            SysRolePermission rp = new SysRolePermission();
            rp.setRoleId(roleId);
            rp.setPermissionId(permId);
            rolePermissionMapper.insert(rp);
        }
    }

    public List<Long> getPermissionIds(Long roleId) {
        LambdaQueryWrapper<SysRolePermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRolePermission::getRoleId, roleId);
        return rolePermissionMapper.selectList(wrapper).stream()
                .map(SysRolePermission::getPermissionId)
                .toList();
    }
}
