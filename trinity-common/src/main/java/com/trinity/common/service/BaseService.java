package com.trinity.common.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trinity.common.entity.BaseEntity;

/**
 * Service 基类 — 提供带操作人的逻辑删除方法
 *
 * @param <M> Mapper 类型
 * @param <T> 实体类型
 */
public class BaseService<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {

    /**
     * 逻辑删除（不记录删除人，走 MyBatis-Plus 标准逻辑删除）
     */
    @Override
    public boolean removeById(java.io.Serializable id) {
        return super.removeById(id);
    }

    /**
     * 逻辑删除并传入操作人参数
     * 同时更新 deleted=1 和 updated_user，可追踪是谁执行的删除
     *
     * @param id       主键
     * @param operator 操作人
     */
    public boolean removeById(Long id, String operator) {
        LambdaUpdateWrapper<T> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(T::getDeleted, 1)
               .set(T::getUpdatedUser, operator)
               .eq(T::getId, id);
        return update(wrapper);
    }

    /**
     * 批量逻辑删除并传入操作人参数
     *
     * @param ids      主键列表
     * @param operator 操作人
     */
    public boolean removeByIds(java.util.Collection<Long> ids, String operator) {
        LambdaUpdateWrapper<T> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(T::getDeleted, 1)
               .set(T::getUpdatedUser, operator)
               .in(T::getId, ids);
        return update(wrapper);
    }
}
