# Trinity Salary

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Salary |
| Maven Artifact | `com.trinity:trinity-salary` |
| 端口 | 8086 |
| 所属层级 | 考勤薪酬层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

薪资管理服务，负责薪酬核算与发放：
- **薪资结构**：基本工资、岗位工资、绩效工资、津贴等薪资项配置
- **社保公积金**：社保基数、公积金比例维护
- **个税计算**：个人所得税自动计算
- **薪资核算**：月度薪资自动核算（关联考勤、绩效数据）
- **工资条**：电子工资条生成与推送

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-employee（员工薪资档案）、trinity-attendance（考勤扣款数据）、trinity-performance（绩效奖金数据）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储薪资管理相关业务数据）
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
