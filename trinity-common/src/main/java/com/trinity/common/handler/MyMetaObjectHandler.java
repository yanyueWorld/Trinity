package com.trinity.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis-Plus 自动填充处理器
 * 负责 createdTime / updatedTime / createdUser / updatedUser 的自动填充
 *
 * createdUser / updatedUser 由调用方通过 ThreadLocal 或请求上下文设置，
 * 此处提供 setCurrentOperator 静态方法供拦截器/过滤器调用。
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final ThreadLocal<String> OPERATOR_HOLDER = new ThreadLocal<>();

    /**
     * 由拦截器/过滤器在请求入口设置当前操作人
     */
    public static void setCurrentOperator(String operator) {
        OPERATOR_HOLDER.set(operator);
    }

    /**
     * 请求结束后清理
     */
    public static void removeCurrentOperator() {
        OPERATOR_HOLDER.remove();
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        String operator = getOperator();

        this.strictInsertFill(metaObject, "createdTime", LocalDateTime.class, now);
        this.strictInsertFill(metaObject, "updatedTime", LocalDateTime.class, now);
        this.strictInsertFill(metaObject, "createdUser", String.class, operator);
        this.strictInsertFill(metaObject, "updatedUser", String.class, operator);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        String operator = getOperator();

        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime.class, now);
        this.strictUpdateFill(metaObject, "updatedUser", String.class, operator);
    }

    private String getOperator() {
        String operator = OPERATOR_HOLDER.get();
        return operator != null ? operator : "system";
    }
}
