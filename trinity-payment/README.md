# Trinity Payment

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Payment |
| Maven Artifact | `com.trinity:trinity-payment` |
| 端口 | 8096 |
| 所属层级 | 财务管控层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

付款管理服务，负责对公付款流程管理：
- **付款申请**：付款单创建、关联合同/发票
- **审批流程**：按金额分级审批
- **付款执行**：银企直连/手工付款状态跟踪
- **发票管理**：进项发票登记、验真、匹配
- **供应商**：供应商信息、银行账户维护

## 依赖关系

### 依赖的其他服务

trinity-auth（权限校验）、trinity-contract（合同付款条款）、trinity-budget（预算冻结与核销）、trinity-finance（凭证生成）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- MySQL（存储付款管理相关业务数据）
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
