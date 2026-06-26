# Trinity Gateway

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Gateway |
| Maven Artifact | `com.trinity:trinity-gateway` |
| 端口 | 8080 |
| 所属层级 | 基础设施层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

API 网关服务，作为系统唯一入口，负责：
- **路由转发**：基于 Nacos 服务发现的动态路由，将请求转发到下游微服务
- **负载均衡**：Spring Cloud LoadBalancer 客户端负载均衡
- **统一鉴权**：结合 trinity-auth 校验 JWT Token
- **跨域处理**：复用 trinity-common 的 CORS 配置
- **请求过滤**：日志、限流等前置处理

## 依赖关系

### 依赖的其他服务

trinity-auth（鉴权校验时调用）

### 依赖的中间件

- Nacos（服务注册发现 + 配置中心）
- Sentinel（网关层流量控制与熔断降级）

## 技术依赖（pom.xml）

> **注意**：依赖 trinity-common，不含数据库访问。使用 Gateway MVC 模式。

| 依赖 | 说明 |
|------|------|
| trinity-common | 公共基础模块（统一返回体、异常处理、JWT、跨域、MyBatis-Plus 配置） |
| spring-cloud-starter-gateway-server-webmvc | Spring Cloud Gateway Web MVC 模式 |
| spring-cloud-starter-alibaba-nacos-discovery | Nacos 服务注册与发现 |
| spring-cloud-starter-alibaba-nacos-config | Nacos 配置中心（数据库/Redis/Sentinel 等运行时配置） |
| spring-cloud-starter-loadbalancer | 客户端负载均衡 |
| spring-cloud-alibaba-sentinel-gateway | Sentinel 网关层流量控制与熔断降级 |
| spring-boot-starter-validation | 参数校验 |
| lombok | 代码简化注解 |
