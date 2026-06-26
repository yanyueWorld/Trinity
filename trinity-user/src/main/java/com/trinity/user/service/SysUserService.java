package com.trinity.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trinity.common.service.BaseService;
import com.trinity.user.entity.SysUser;
import com.trinity.user.mapper.SysUserMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends BaseService<SysUserMapper, SysUser> {

    @Cacheable(value = "user", key = "#username")
    public SysUser loadByUsername(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        return getOne(wrapper);
    }

    public boolean existsByUsername(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        return exists(wrapper);
    }
}
