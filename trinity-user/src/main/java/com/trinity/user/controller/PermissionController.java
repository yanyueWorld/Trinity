package com.trinity.user.controller;

import com.trinity.common.result.Result;
import com.trinity.user.entity.SysPermission;
import com.trinity.user.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final SysPermissionService permService;

    public PermissionController(SysPermissionService permService) {
        this.permService = permService;
    }

    @GetMapping("/tree")
    public Result<List<SysPermission>> tree() {
        return Result.success(permService.listTree());
    }

    @GetMapping("/{id}")
    public Result<SysPermission> getById(@PathVariable Long id) {
        return Result.success(permService.getById(id));
    }

    @PostMapping
    public Result<Void> create(@RequestBody SysPermission perm) {
        permService.save(perm);
        return Result.success("创建成功", null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody SysPermission perm) {
        perm.setId(id);
        permService.updateById(perm);
        return Result.success("更新成功", null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id, @RequestParam String operator) {
        permService.removeById(id, operator);
        return Result.success("删除成功", null);
    }
}
