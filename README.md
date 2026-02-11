---

# AI Demo 智能识别平台

这是一个基于 **Spring Boot** 和 **Vue.js** 开发的 AI 功能演示平台。项目集成了 **百度 AI 开放平台** (Baidu AI Cloud) 的 SDK，实现了自然语言处理、图像识别和文字识别（OCR）三大核心功能，并支持历史记录的持久化存储与管理。

## ✨ 功能特性

1. **NLP 自然语言纠错**
* 输入包含错误的文本，系统自动识别并进行纠错（例如："百度是一加高科技工司" -> "百度是一家高科技公司"）。


2. **通用图像识别**
* 上传图片，AI 自动分析图片内容并返回置信度最高的关键词描述。


3. **OCR 文字识别**
* 上传包含文字的图片，系统自动提取并输出图片中的所有文字内容。


4. **历史记录管理**
* 所有的识别结果会自动存入 MySQL 数据库。
* 支持在前端查询历史记录列表。
* 支持删除指定的历史记录。



## 🛠 技术栈

### 后端 (Backend)

* **核心框架**: Spring Boot
* **ORM 框架**: MyBatis Plus
* **数据库**: MySQL
* **AI SDK**: Baidu AIP SDK (Java)
* **工具**: Lombok

### 前端 (Frontend)

* **核心库**: Vue.js (CDN 引入)
* **UI 组件库**: Element UI
* **HTTP 请求**: Axios

## 🚀 快速开始

### 1. 数据库配置

请在 MySQL 数据库中执行以下 SQL 语句，创建项目所需的存储表：

```sql
CREATE DATABASE IF NOT EXISTS ai_demo_db DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

USE ai_demo_db;

-- 创建识别记录表
CREATE TABLE `ocr_content` (
 `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` text COMMENT '识别内容',
 `type` int DEFAULT NULL COMMENT '类型',
 `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 
'创建时间',
 `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 
'更新时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='识别记录表'

```

> **注意**: 请确保 `application.properties` 或 `application.yml` 中的数据库连接信息（URL, Username, Password）与你的本地环境一致。

### 2. API Key 配置

项目依赖百度 AI 接口，相关的 Key 目前配置在 `com.example.ai_demo.util.AiUtils.java` 文件中。

* 如果你有自己的百度 AI 账号，建议替换 `APP_ID`, `API_KEY`, `SECRET_KEY` 为你自己的凭证，以确保额度充足。

### 3. 运行后端

找到 `AiDemoApplication.java`，运行 `main` 方法启动 Spring Boot 服务。

* 服务默认端口：`8080`

### 4. 运行前端

直接使用浏览器打开 `index.html` 文件即可。

* **注意**: 由于前后端分离且前端使用硬编码的 `http://127.0.0.1:8080` 进行请求，请确保后端服务已成功启动。

## 📂 项目结构说明

```
├── src/main/java/com/example/ai_demo
│   ├── controller
│   │   ├── AiController.java       // 处理 AI 识别请求 (NLP, Img, Word)
│   │   ├── ContentController.java  // 处理历史记录的查询与删除
│   │   └── HelloController.java    // 测试接口
│   ├── dto
│   │   └── OcrContent.java         // 数据库实体类
│   ├── mapper
│   │   └── OcrContentMapper.java   // MyBatis Plus Mapper 接口
│   ├── util
│   │   └── AiUtils.java            // 百度 AI SDK 工具类 (核心逻辑)
│   └── AiDemoApplication.java      // 启动类
└── index.html                      // 前端单页面文件

```
## 声明

本项目参考b站up主小尾学长的视频实现，此处查看[原视频](https://www.bilibili.com/video/BV1mg4y1D7XX)

---
