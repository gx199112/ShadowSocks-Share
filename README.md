欢迎访问本项目!
===================

示例站点：https://shadowsocks-share.herokuapp.com   
本项目不提供 ShadowSocks 服务。只收集、整理免费账号，便于查询、订阅。

> **注意：**
> - 本项目仅限编程学习、讨论使用，**请在适用法律允许的范围内使用**。
> - 本项目提供的信息，来自于其他共享站点，无法保证内容的准确性、可靠性、可用性、完整性。


#### 使用说明

##### Windows :
1. 下载客户端，并启动
2. 鼠标右键客户端任务栏图标
3. 服务器订阅 -> SSR 服务器订阅设置
4. 网站栏中填入项目订阅地址

##### Android :
1. 下载 APK
2. 扫面账号连接二维码

> **注意：**
> - 账号状态分为“有效”、“无效”两种：
>   - 有效：获取账号或定时检查可用性时，应用所在服务器到 SS 服务，网络可用
>   - 无效：获取账号或定时检查可用性时，应用所在服务器到 SS 服务，网络异常
> - 此状态为瞬时（而非实时）的应用服务器与 SS 服务间的网络状态。不具备准确性。请自行选择订阅有效或是全部。
> - 随机 JSON 订阅：随机返回一条有效状态的账号信息


#### 系统简介

##### 工作流程如下 :

1. 定时扫描目标网站账号信息
2. 信息保存至数据库
3. 前台展示、订阅信息
4. 定时（每 1 小时整点）检测所有账号可用性，并更新账号状态

##### 收集信息网站列表如下 :

地址     | 启动时扫描 | 扫描间隔
-------- | --- | ----
https://global.ishadowx.net/ | 是 | 从 0 点 10 分开始，每 3 小时
https://doub.io/sszhfx/ | 是 | 从 0 点 10 分开始，每 6 小时
https://freess.cx/ | 是 | 从 0 点 10 分开始，每 12 小时
https://en.ss8.fun/ | 是 | 从 0 点 10 分开始，每 4 小时
https://freessr.win/ | 是 | 从 0 点 10 分开始，每 6 小时
https://free-ss.site/ | 是 | 从 0 点 10 分开始，每 6 小时
http://www.ssr.blue/ | 是 | 从 0 点 10 分开始，每 3 小时


#### 系统部署

##### Heroku 部署方法

请参考：
ShadowSocksShare-OpenShift [Heroku 部署方法](https://github.com/the0demiurge/ShadowSocksShare-OpenShift#heroku-%E9%83%A8%E7%BD%B2%E6%96%B9%E6%B3%95) 


#### TO DO

1. 计划支持下列站点：
    1. https://plus.google.com/communities/104092405342699579599