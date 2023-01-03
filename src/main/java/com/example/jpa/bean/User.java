package com.example.jpa.bean;
import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
@Data//setter、getter、tostring
@NoArgsConstructor//无参构造
@Accessors(chain = true)//链式
@Entity//指定实体类
@Table(name = "users")//指定表名
public class User{// implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}