package com.trinity.user.controller;

import com.trinity.common.result.Result;
import com.trinity.user.entity.SysDept;
import com.trinity.user.service.SysDeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final SysDeptService deptService;

    public DeptController(SysDeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/tree")
    public Result<List<SysDept>> tree() {
        return Result.success(deptService.listTree());
    }

    @GetMapping("/{id}")
    public Result<SysDept> getById(@PathVariable Long id) {
        return Result.success(deptService.getById(id));
    }

    @PostMapping
    public Result<Void> create(@RequestBody SysDept dept) {
        deptService.save(dept);
        return Result.success("创建成功", null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody SysDept dept) {
        dept.setId(id);
        deptService.updateById(dept);
        return Result.success("更新成功", null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id, @RequestParam String operator) {
        deptService.removeById(id, operator);
        return Result.success("删除成功", null);
    }
}
