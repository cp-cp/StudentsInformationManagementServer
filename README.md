# Student_Arrangement
server of student arrangement system

Front-end by **Coca Cat**,**lyuzlion**

back-end by **cp-cp** ,**Miraclys**

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

#### http

| route                    | action           | method   |
|--------------------------|------------------|----------|
| /init                    | 生成学生样例           | GET方法    |
| /all                     | 查询所有学生           | GET方法    |
| /findByld                | 按照id索引           | POST方法   |
|/findByNumber/{number}| 按照number索引       | GET方法    |
| /getByld/{id)            | 按照id索引           | GET方法    |
| /add                     | 添加学生             | POST方法   |
| /deleteByNumber/{number} | 按照number(学号)删除学生 | DELETE方法 |
| modify                   | 更新学生             | POST方法   |


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

| route                    | action       | method   |
|--------------------------|--------------|----------|
| /init                    | 生成teacher样例  | GET方法    |
| /all                     | 查询所有老师       | GET方法    |
| /findById                | 按照id索引       | POST方法   |
| /getById/ (id}           | 按照id索引       | GET方法    |
| /findByNumber/{number}   | 按照number索引   | GET方法    |
| /findByIdAllCourses      | 查询这个老师所有的授课  | POST方法   |
| /getByIdAllCourses/{id}  | 查询这个老师所有的授课  | GET方法    |
| /add                     | 添加老师         | POST方法   |
| /deleteByNumber/{number} | 按照number删除老师 | DELETE方法 |
| /modify                  | 更新老师         | POST方法   |


### Course

#### class

| element    | type    |
|------------|---------|
| id         | Integer |
| courseName | String  |
| credit     | Integer |
| number     | String  |
|teacher | Teacher|

#### http

| route                           | action            | method   |
|---------------------------------|-------------------|----------|
| /init                           | 创建初始样例            | GET方法    |
| /findById                       | 按照id索引            | POST方法   |
| /findByTeacherNumber            | 按照授课老师的number索引   | POST方法   |
| /findByCredit                   | 按照学分分值查询          | POST方法   |
| /deleteByTeacherNumber/{number} | 按照授课老师的number进行删除 | DELETE方法 |
| /deleteByNumber/{number}        | 按照课程号删除           | DELETE方法 |
| /add                            | 添加课程              | POST方法   |
| /modify                         | 修改课程              | POST方法   |

### Score
#### class

| element | type    |
|---------|---------|
| id      | Integer |
| score   | Integer |
| course  | Course  |
| student | Student |

#### http
| route                                                              | action       | methond  |
|--------------------------------------------------------------------|--------------|----------|
| /init                                                              | 生成样例         | GET方法    |
| /all                                                               | 获取所有         | GET方法    |
| /findByStudentNumber/{studentNumber}                               | 按照学号查询       | GET方法    |
| /findByCourseNumber/{courseNumber}                                 | 按照课程号查询      | GET方法    |
|/findByTeacherNumber/{number}"| 按照老师编号查询     | GET方法    |
| /findByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber} | 唯一检索某节课某学生成绩 | GET方法    |
| /add                                                               | 添加成绩         | POST方法   |
| /modify                                                            | 修改成绩         | POST方法   |
|/deleteByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber}| 唯一删除         | DELETE方法 |
|/deleteByStudentNumber/{studentNumber}| 删除某一学生的所有成绩  | DELETE方法 |
|/deleteByCourseNumber/{courseNumber}| 某个课程的成绩清空    | DELETE方法 |


## Database
Jpa with sqlite

