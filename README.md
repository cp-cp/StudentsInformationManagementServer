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

| route                    | action           | method   | response |
|--------------------------|------------------|----------|--------------------------|
| /init                    | 生成学生样例           | GET方法    | String "initialize students successfully!" |
| /all                     | 查询所有学生           | GET方法 | List<Student>                              |
|/findByNumber/{number}| 按照number索引       | GET方法    | Student |
| /add                     | 添加学生             | POST方法   | ResponseEntity |
| /deleteByNumber/{number} | 按照number(学号)删除学生 | DELETE方法 | ResponseEntity |
| modify                   | 更新学生             | POST方法   | ResponseEntity |


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

| route                           | action                 | method     | response                                   |
|---------------------------------| ---------------------- | ---------- | ------------------------------------------ |
| /init                           | 生成teacher样例        | GET方法    | String "initialize teachers successfully!" |
| /all                            | 查询所有老师           | GET方法    | List<Teacher>                              |
| /findByNumber/{number}          | 按照number索引         | GET方法    | Teacher                                    |
| /findByNumberAllCourses/{number} | 查询这个老师所有的授课 | GET方法    | List<String>                               |
| /add                            | 添加老师               | POST方法   | ResponseEntity                             |
| /deleteByNumber/{number}        | 按照number删除老师     | DELETE方法 | ResponseEntity                             |
| /modify                         | 修改老师               | POST方法   | ResponseEntity                             |


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

| route                           | action                       | method     | response                                 |
| ------------------------------- | ---------------------------- | ---------- | ---------------------------------------- |
| /init                           | 创建初始样例                 | GET方法    | String initialize courses successfully!" |
| /findByTeacherNumber            | 按照授课老师的number索引     | POST方法   | List<Course>                             |
| /findByCredit                   | 按照学分分值查询             | POST方法   | List<Course>                             |
| /deleteByTeacherNumber/{number} | 按照授课老师的number进行删除 | DELETE方法 | String                                   |
| /deleteByNumber/{number}        | 按照课程号删除               | DELETE方法 | ResponseEntity                           |
| /add                            | 添加课程                     | POST方法   | ResponseEntity                           |
| /modify                         | 修改课程                     | POST方法   | ResponseEntity                           |
| /all                            | 全部课程                     | GET方法    | List<Course>                             |

### Score
#### class

| element | type    |
|---------|---------|
| id      | Integer |
| score   | Integer |
| course  | Course  |
| student | Student |

#### http
| route                                                        | action                   | methond    | response       |
| ------------------------------------------------------------ | ------------------------ | ---------- | -------------- |
| /init                                                        | 生成样例                 | GET方法    | String         |
| /all                                                         | 获取所有                 | GET方法    | List<Score>    |
| /findByStudentNumber/{studentNumber}                         | 按照学号查询             | GET方法    | List<Score>    |
| /findByCourseNumber/{courseNumber}                           | 按照课程号查询           | GET方法    | List<Score>    |
| /findByTeacherNumber/{number}"                               | 按照老师编号查询         | GET方法    | List<Score>    |
| /findByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber} | 唯一检索某节课某学生成绩 | GET方法    | Score          |
| /add                                                         | 添加成绩                 | POST方法   | ResponseEntity |
| /modify                                                      | 修改成绩                 | POST方法   | ResponseEntity |
| /deleteByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber} | 唯一删除                 | DELETE方法 | ResponseEntity |
| /deleteByStudentNumber/{studentNumber}                       | 删除学生                 | DELETE方法 | ResponseEntity |
| /deleteByCourseNumber/{courseNumber}                         | 删除课程                 | DELETE方法 | ResponseEntity |


## Database
Jpa with sqlite
