# Trinity Finance

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Finance |
| Maven Artifact | `com.trinity:trinity-finance` |
| 端口 | 8097 |
| 所属层级 | 财务管控层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

财务总账服务，负责财务核算与报表：
- **科目体系**：会计准则科目表维护
- **凭证管理**：记账凭证生成、审核、过账
- **账务处理**：自动凭证（薪资、折旧等）、手动凭证
- **期末处理**：结转、结账、调汇
- **财务报表**：资产负债表、利润表、现金流量表
- **辅助核算**：部门/项目/客户多维度辅助核算

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-salary（薪资凭证）、trinity-asset（折旧凭证）、trinity-payment（付款凭证）、trinity-expense（费用凭证）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储财务总账相关业务数据）
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
