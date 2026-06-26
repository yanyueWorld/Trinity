# Trinity Common

## 基本信息

| 项目 | 内容 |
|------|------|
| 模块名称 | Trinity Common |
| Maven Artifact | `com.trinity:trinity-common` |
| 端口 | 无（公共 JAR 模块，不独立启动） |
| 所属层级 | 基础设施层 |
| 技术栈 | JDK 26 + Spring Boot 4.1.0 + Spring Cloud 2025.1.2 |

## 功能描述

公共基础模块，为所有微服务提供共享能力：
- **统一返回体**：`Result<T>` 统一 API 响应格式
- **异常处理**：`BusinessException` + `GlobalExceptionHandler` 全局异常拦截
- **JWT 工具**：Token 生成、解析、刷新
- **跨域配置**：CorsFilter 全局跨域支持
- **MyBatis-Plus 配置**：分页插件（MySQL 方言）

## 依赖关系

### 依赖的其他服务

无

### 依赖的中间件

作为纯 JAR 模块，不直接依赖任何中间件。各业务模块引入 common 后自行配置 Nacos / MySQL / Redis / Sentinel。

## 技术依赖（pom.xml）

> **注意**：本模块为 JAR 依赖，由其他服务模块引用，不独立运行。

| 依赖 | 说明 |
|------|------|
| spring-boot-starter-web | Spring Boot Web 支持 |
| spring-boot-starter-validation | 参数校验 |
| mybatis-plus-spring-boot4-starter | MyBatis-Plus 分页插件配置 |
| jjwt-api / jjwt-impl / jjwt-jackson | JWT Token 处理（0.13.0） |
| lombok | 代码简化注解 |
