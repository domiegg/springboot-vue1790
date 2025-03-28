package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *审核员：(Auditor)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Auditor")
public class Auditor implements Serializable {

    //Auditor编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditor_id")
    private Integer auditor_id;
    // 人员编号
    @Basic
    private String personnel_number;
    // 人员姓名
    @Basic
    private String personnel_name;
    // 人员性别
    @Basic
    private String personnel_gender;
    // 人员年龄
    @Basic
    private String personnel_age;
    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
