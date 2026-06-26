# Trinity Budget

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Budget |
| Maven Artifact | `com.trinity:trinity-budget` |
| 端口 | 8093 |
| 所属层级 | 财务管控层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

预算管理服务，负责公司预算编制与控制：
- **预算科目**：收入/支出科目体系维护
- **预算编制**：年度/季度/月度预算编制与审批
- **预算执行**：实际支出与预算对比、执行率分析
- **预算调整**：预算追加、调剂审批流程
- **预算预警**：超预算/接近预算阈值自动预警

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-org（部门维度预算）、trinity-expense（实际费用数据）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储预算管理相关业务数据）
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
