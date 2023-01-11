# Student_Arrangement
server of student arrangement system
## Framework
Springboot
## Connection
Http:

```http
http://localhost:8080
```

### Student

#### class

| **element** | type    |
| ----------- |---------|
| id          | Integer |
| number      | String  |
| gender      | String  |
| name        | String  |
| college     | String  |
| score       | Integer |

#### http

| route | action       | method  |
| ----- | ------------ | ------- |
| /init | 生成学生样例 | GET方法 |
| /all             | 查询所有学生   | GET方法    |
| /findByld        | 按照id索引     | POST方法   |
| /getByld/{id)   | 按照id索引     | GET方法    |
| /add             | 添加学生       | POST方法   |
| /deleteByld/{id} | 按照id删除学生 | DELETE方法 |



### Teacher

#### class

| element | type    |
|---------|---------|
| id      | Integer |
| name    | String  |
| college | String  |
| gender  | String  |
| number  | String  |

#### http

| route | action | method |
| ----- | ------ | ------ |
| /init | 生成teacher样例 | GET方法 |
|/all|查询所有老师|GET方法|
|/findByld|按照id索引|POST方法|
|/getByld/ (id}|按照id索引|GET方法|
|/findByldAllCourses|查询这个老师所有的授课|POST方法|
|/getByldAllCourses/{id}|查询这个老师所有的授课|GET方法|
|/add|添加老师|POST方法|
|/deleteByld/fid}|按照序号删除老师|DELETE方法|



### Course

#### class

| element    | type    |
|------------|---------|
| id         | Integer |
| courseName | String  |
| credit     | Integer |
| number     | String  |

#### http

| route | action | method |
| ----- | ------ | ------ |
| /init | 创建初始样例 | GET方法 |
|/findByld|按照id索引|POST方法|
|/findByTeacherld|按照授课老师的id索引|POST方法|
|/findByCredit|按照学分分值查询|POST方法|
|/deleteByTeacherId/{id}|按照授课老师的id进行删除|DELETE方法|

## Database
Jpa with sqlite

