# Trinity System

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity System |
| Maven Artifact | `com.trinity:trinity-system` |
| 端口 | 8082 |
| 所属层级 | 基础设施层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

系统管理服务，负责系统级配置与运维：
- **字典管理**：系统数据字典维护
- **参数配置**：系统级参数键值管理
- **操作日志**：审计日志记录与查询
- **通知公告**：系统公告发布与管理
- **文件管理**：统一文件上传/下载/存储

## 依赖关系

### 依赖的其他服务

trinity-auth（操作人身份校验）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储系统管理相关业务数据）
- MyBatis-Plus 3.5.16（ORM 框架）
- Redis（业务数据缓存）
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
