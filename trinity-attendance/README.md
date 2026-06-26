# Trinity Attendance

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Attendance |
| Maven Artifact | `com.trinity:trinity-attendance` |
| 端口 | 8085 |
| 所属层级 | 考勤薪酬层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

考勤管理服务，负责员工出勤数据管理：
- **考勤规则**：班次定义、排班、节假日设置
- **打卡记录**：打卡数据采集、异常标注
- **请假管理**：请假申请、审批、额度管理
- **加班管理**：加班申请、审批、时长统计
- **考勤统计**：日报/月报、出勤率、迟到早退统计

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-employee（员工信息查询）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储考勤管理相关业务数据）
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
