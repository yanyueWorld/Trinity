# Trinity Employee

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Employee |
| Maven Artifact | `com.trinity:trinity-employee` |
| 端口 | 8084 |
| 所属层级 | 组织人事层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

员工管理服务，负责人事信息全生命周期管理：
- **员工档案**：基本信息、教育经历、工作经历、家庭成员
- **入职管理**：入职流程、信息采集、账号开通
- **异动管理**：调岗、晋升、转正、离职流程
- **合同管理**：劳动合同签订、续签、到期提醒
- **花名册**：员工名册查询与导出

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-org（部门/岗位数据）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储员工管理相关业务数据）
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
