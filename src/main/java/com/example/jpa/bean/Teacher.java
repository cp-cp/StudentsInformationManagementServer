package com.example.jpa.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data//setter、getter、tostring
@NoArgsConstructor//无参构造
@Entity//指定实体类
@Table(name = "teacher")//指定表名
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     String college;
     String gender;
     String number;
}
