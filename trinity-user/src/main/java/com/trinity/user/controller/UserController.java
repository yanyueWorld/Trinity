package com.trinity.user.controller;

import com.trinity.common.result.Result;
import com.trinity.user.entity.SysUser;
import com.trinity.user.service.SysUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final SysUserService userService;

    public UserController(SysUserService userService) {
        this.userService = userService;
    }

    /** 供 Auth 模块 Feign 调用 */
    @GetMapping("/loadByUsername")
    public Result<SysUser> loadByUsername(@RequestParam String username) {
        SysUser user = userService.loadByUsername(username);
        if (user == null) {
            return Result.error(404, "用户不存在");
        }
        return Result.success(user);
    }

    @GetMapping("/{id}")
    public Result<SysUser> getById(@PathVariable Long id) {
        SysUser user = userService.getById(id);
        if (user == null) {
            return Result.error(404, "用户不存在");
        }
        return Result.success(user);
    }

    @PostMapping
    public Result<Void> create(@RequestBody SysUser user) {
        if (userService.existsByUsername(user.getUsername())) {
            return Result.error(400, "用户名已存在");
        }
        userService.save(user);
        return Result.success("创建成功", null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody SysUser user) {
        user.setId(id);
        userService.updateById(user);
        return Result.success("更新成功", null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id, @RequestParam String operator) {
        userService.removeById(id, operator);
        return Result.success("删除成功", null);
    }
}
