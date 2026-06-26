package com.trinity.user.service;

import com.trinity.common.service.BaseService;
import com.trinity.user.entity.SysDept;
import com.trinity.user.mapper.SysDeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptService extends BaseService<SysDeptMapper, SysDept> {

    public List<SysDept> listTree() {
        return list();
    }
}
