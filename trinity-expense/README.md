# Trinity Expense

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Expense |
| Maven Artifact | `com.trinity:trinity-expense` |
| 端口 | 8094 |
| 所属层级 | 财务管控层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

费用报销管理服务，负责员工费用报销全流程：
- **报销类型**：差旅费、招待费、办公费、交通费等类型定义
- **报销申请**：填写报销单、上传发票
- **审批流程**：多级审批、会签、转审
- **费用标准**：差旅标准、招待标准按职级控制
- **费用统计**：部门/个人/科目维度费用报表

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-employee（报销人/审批人信息）、trinity-org（部门归属）、trinity-budget（预算校验与控制）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储费用报销相关业务数据）
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
