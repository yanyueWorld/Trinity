# Trinity Auth

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Auth |
| Maven Artifact | `com.trinity:trinity-auth` |
| 端口 | 8081 |
| 所属层级 | 基础设施层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

认证授权服务，负责系统安全管控：
- **用户认证**：登录/登出、JWT Token 签发与刷新
- **权限管理**：RBAC 角色-权限模型，菜单/按钮/接口级权限控制
- **用户管理**：用户 CRUD、密码重置、状态管理
- **角色管理**：角色分配、权限绑定
- **Token 校验**：为 Gateway 和其他服务提供 Token 合法性校验接口

## 依赖关系

### 依赖的其他服务

无（认证服务独立，不依赖其他业务服务）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心，路由配置如数据库连接等存储在 Nacos）
- MySQL（存储用户、角色、权限、菜单等认证授权数据）
- MyBatis-Plus 3.5.16（ORM 框架）
- Redis（Token 黑名单、验证码缓存）
- Sentinel（接口限流与熔断保护）

## 技术依赖（pom.xml）

| 依赖 | 说明 |
|------|------|
| trinity-common | 公共基础模块（统一返回体、异常处理、JWT、跨域、MyBatis-Plus 配置） |
| spring-boot-starter-web | Spring Boot Web 支持 |
| spring-cloud-starter-alibaba-nacos-discovery | Nacos 服务注册与发现 |
| spring-cloud-starter-alibaba-nacos-config | Nacos 配置中心（数据库/Redis/Sentinel 等运行时配置） |
| spring-cloud-starter-loadbalancer | 客户端负载均衡 |
| mybatis-plus-spring-boot4-starter | ORM 框架（MyBatis-Plus 3.5.16） |
| mysql-connector-j | MySQL 数据库驱动（9.7.0） |
| spring-cloud-starter-openfeign | 声明式服务间远程调用 |
| spring-boot-starter-validation | 参数校验 |
| lombok | 代码简化注解 |
