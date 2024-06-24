## SQLite 自学项目
- 原贴https://blog.csdn.net/wsjzzcbq/article/details/134468069
### 安装SQLite
- 下载SQLite的安装包，解压到指定目录
- 下载地址：https://www.sqlite.org/download.html
### java操作SQLite
- 创建一个java工程，基于maven
- 引入 sqlite-jdbc 依赖
```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.41.2.1</version>
</dependency>
```
- 增删改查代码详见sql_test
### 项目任务：数据异常查询和VIP信息分析
- 背景:工作中经常需要查询和解决数据异常的问题。现在有一个本地的SQLite数据库文件users_vip.db，其中包含两张表:
- 1、用户表：users：
```sql
CREATE TABLE IF NOT EXISTS users (
    userid TEXT PRIMARY KEY,
    email TEXT,
    phone TEXT
);
```
- 用户ID ( userid )
- 电子邮件（ email)，格式为{name}@{domain}，其中 domain均以.com结尾。部分数据可能格式不正确，如包含连续的..、含有,、domain不完整、含有多余字符串等信息。
- 手机号（phone )，应该以+86-130-4567-9876的格式存储（仅包含+86地区)。部分数据可能格式不正确，如连字符不正确、位数不对等信息。
- 2、VIP表：vip_records：
```sql
CREATE TABLE IF NOT EXISTS vip_records (
    userid TEXT,
    is_paid INTEGER,--0 表示免费VIP，1 表示付费VIP
    vip_start_date TEXT,
    vip_end_date TEXT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);
```
- 每行是一次用户的VIP购买历史，VIP间隔不会重合，日期存储格式为"%Y-%m-%d"(例如:2024-o5-o9到2024-05-31)。
- 用户ID( userid)
- 是否付费VIP( is_paid):0表示免费VIP，1表示付费VIP
- VIP开始日期(vip_start_date)
- VIP结束日期（vip_end_date )
### 任务要求
- 1.查询出明显存储格式不对的用户列表。
- 2.查找并计算这些用户的 VIP历史信息。
- 3.将最终结果按照如下格式输出并写入本地文件invalid_user_vip_summary :
- UserID: user_0016，Total VIP Count: 3, Free VIP Days: 7, Paid VIP Days: 60



