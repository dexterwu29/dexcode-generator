# 鱼籽 - 定制化代码生成项目（持续更新）

> 学习教程来源，程序员鱼皮的开源项目：https://github.com/liyupi/yuzi-generator
>
> 学习笔记分享在语雀知识库，目前只有编程导航知识星球的小伙伴可以查看：
>
> 也欢迎互联网上的朋友们多提issue，大家一起交流进步！

## 一、项目介绍

基于 React + Spring Boot + Vert.x 响应式编程的 **定制化代码生成项目**

完整的项目分为 **3个阶段**：

1. 制作属于自己的 `本地代码生成器`，是一个基于命令行的脚手架，能够根据用户的交互式输入快速生成特定代码
2. 开发 `制作代码生成器的工具`，比如自己有一段常用的代码，使用该工具可以快速地把项目制作为代码生成器（我的理解：就是一套自用的模板，ex.我**刷算法题**用的代码 有LeetCode题目要求、Main方法、编写的算法本身），大大提升工作效率
3. 开发 `在线代码生成器平台`，在平台上制作发布自己的代码生成器，还可以在线使用别人的代码生成器，甚至可以共享协作

## 二、学习进度记录

### 第二期、代码生成

当前目录说明：

- 项目根目录`dexcode-generator`，便于后续不同阶段的代码管理

- `dexcode-generator-demo-projects` 存放了本项目需要用到的示例代码

- `dexcode-generator-basic` 维护项目第一阶段的开发

本期内容：

- 学习静态文件生成的两种方式
  - 使用现有的hutool工具库
  - 自己写代码进行递归复制
- 借助FreeMarker模板引擎实现动态文件生成
- 并将两者结合，统一写在了`com.dexcode.generator` 包下的`MainGenerator`类中，实现了Java ACM示例模板代码的本地定制生成

### 第一期、项目总览

跟着鱼皮的视频，了解了本项目的项目介绍、项目背景，做了需求分析和技术选型；

项目的设计主要分为三个阶段：

- 第一阶段、开发本地代码生成器和命令行工具
- 第二阶段、开发代码生成器的制作工具
- 第三阶段、开发在线代码生成器管理、分享、使用平台

本期重点，是学习面对一个项目，如何分阶段分步骤的拆解项目，做到循序渐进的开展研发，要能够**自己写出一套设计方案**；另外新项目的需求分析、技术选型、寻找网上已有的开源项目进行对比，都是一个项目开发前期必不可少的工作。

## 三、后续版本更新记录