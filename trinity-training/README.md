# Trinity Training

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Training |
| Maven Artifact | `com.trinity:trinity-training` |
| 端口 | 8088 |
| 所属层级 | 培训发展层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

培训管理服务，负责员工培训与发展：
- **课程管理**：课程库、课件上传、分类标签
- **培训计划**：年度/季度培训计划制定
- **培训报名**：报名、审批、签到
- **在线学习**：视频/文档在线学习、进度追踪
- **考试测评**：题库管理、在线考试、成绩统计
- **培训档案**：员工培训履历、学分累计

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-employee（员工信息）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储培训管理相关业务数据）
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
