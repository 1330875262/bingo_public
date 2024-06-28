## sakura-api接口管理平台

### 项目介绍
- 对接sakura机器人的接口管理平台（后端部分），目前仅为个人使用，后续会开放给所有人使用。如有其他需求，欢迎联系我。
- 原创yupi.icu请尊重知识产权@程序员鱼皮

### 软件架构
 - 管理员流量线：管理员 - > 用户管理 - > 接口管理 - > 接口测试 - > 接口文档 -> 数据库
 - 用户流量线：用户 - > 用户前台 - > api网关 - > 模拟接口 - > 接口文档 -> 数据库
 - 数据库 - > 对接MyQQ/NiceQQ/铃心机器人管理平台，详见sakura机器人使用说明

### 技术选型（后端部分）
- Java Spring Boot 框架 
- MySQL 数据库 
- MyBatis-Plus 及 MyBatis X 自动生成 
- API 签名认证（Http 调用） 
- Spring Boot Starter（SDK 开发） 
- Dubbo 分布式（RPC、Nacos） 
- Spring Cloud Gateway 微服务网关 
- Swagger + Knife4j 接口文档生成
- Hutool、Apache Common Utils、Gson 等工具库
