---
AIGC:
    Label: "1"
    ContentProducer: 001191440300708461136T1XGW3
    ProduceID: 60e43baced2d0baea7396f96d258ae48_bb3ba7bb720111f1986d525400d9a7a1
    ReservedCode1: Av+M3SjMIoiPM7SC/FFvSDGllLQ/3Nz4KHC9uUz6TPwDotFg4nJLXOPwiL+3zCxWipUwa1wCEWOTwW+pt58qkkNK5ZPg1fcPoiNfe4Ao9vqreUUZGZPcKjrCg0EDN+H1L3h9KZ6sPbQJ9hHMyV0o1okbdX4qjy8qcHX7fEXh8fQjvWAIvmLI/YEoSrI=
    ContentPropagator: 001191440300708461136T1XGW3
    PropagateID: 60e43baced2d0baea7396f96d258ae48_bb3ba7bb720111f1986d525400d9a7a1
    ReservedCode2: Av+M3SjMIoiPM7SC/FFvSDGllLQ/3Nz4KHC9uUz6TPwDotFg4nJLXOPwiL+3zCxWipUwa1wCEWOTwW+pt58qkkNK5ZPg1fcPoiNfe4Ao9vqreUUZGZPcKjrCg0EDN+H1L3h9KZ6sPbQJ9hHMyV0o1okbdX4qjy8qcHX7fEXh8fQjvWAIvmLI/YEoSrI=
---

# Trinity User

用户与权限管理微服务，负责账号体系全量 CRUD。

## 技术栈

- Spring Boot 4.1.0 / Spring Cloud 2025.1.2
- MyBatis-Plus 3.5.16
- Nacos（注册中心 + 配置中心，namespace=dev）
- MySQL（trinity_user 库）

## 包结构

```
com.trinity.user
├── boot/          UserApplication.java      启动类
├── entity/        数据实体（7 张表映射）
├── mapper/        MyBatis-Plus Mapper 接口
├── service/       业务服务层
└── controller/    REST API 接口
```

## 数据库表

| 表名 | 实体 | 说明 |
|------|------|------|
| sys_user | SysUser | 系统用户 |
| sys_role | SysRole | 角色 |
| sys_permission | SysPermission | 权限（菜单/按钮） |
| sys_dept | SysDept | 部门 |
| sys_user_role | SysUserRole | 用户-角色关联 |
| sys_role_permission | SysRolePermission | 角色-权限关联 |
| oauth2_registered_client | Oauth2RegisteredClient | OAuth2 客户端 |

审计字段（id、created_time、updated_time、created_user、updated_user、version、deleted）由 BaseEntity 统一提供。

## API 接口

### 用户 `/user`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/user/loadByUsername?username=` | 供 Auth 模块 Feign 调用 |
| GET | `/user/{id}` | 查询用户 |
| POST | `/user` | 新增用户 |
| PUT | `/user/{id}` | 更新用户 |
| DELETE | `/user/{id}?operator=` | 逻辑删除（需操作人） |

### 角色 `/role`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/role` | 角色列表 |
| GET | `/role/{id}` | 角色详情 |
| POST | `/role` | 新增角色 |
| PUT | `/role/{id}` | 更新角色 |
| DELETE | `/role/{id}?operator=` | 逻辑删除 |
| PUT | `/role/{id}/permissions` | 分配权限 |
| GET | `/role/{id}/permissions` | 查询角色权限 ID 列表 |

### 权限 `/permission`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/permission/tree` | 权限树 |
| GET | `/permission/{id}` | 权限详情 |
| POST | `/permission` | 新增权限 |
| PUT | `/permission/{id}` | 更新权限 |
| DELETE | `/permission/{id}?operator=` | 逻辑删除 |

### 部门 `/dept`

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/dept/tree` | 部门树 |
| GET | `/dept/{id}` | 部门详情 |
| POST | `/dept` | 新增部门 |
| PUT | `/dept/{id}` | 更新部门 |
| DELETE | `/dept/{id}?operator=` | 逻辑删除 |

## 与 Auth 模块协作

Auth 登录时通过 Feign 调用 `GET /user/loadByUsername` 获取用户信息（含密码），在 Auth 端完成密码比对后签发 JWT。
*（内容由AI生成，仅供参考）*
