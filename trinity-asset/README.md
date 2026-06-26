# Trinity Asset

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Asset |
| Maven Artifact | `com.trinity:trinity-asset` |
| 端口 | 8089 |
| 所属层级 | 资产管理层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

固定资产管理服务，负责公司固定资产全生命周期管理：
- **资产台账**：资产登记、分类、标签打印
- **资产领用**：领用申请、审批、发放
- **资产归还**：归还验收、状态更新
- **资产盘点**：盘点计划、扫码盘点、盘盈盘亏
- **资产折旧**：折旧计算、残值管理
- **资产处置**：报废、调拨、变卖

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-employee（领用人信息）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储资产管理相关业务数据）
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
