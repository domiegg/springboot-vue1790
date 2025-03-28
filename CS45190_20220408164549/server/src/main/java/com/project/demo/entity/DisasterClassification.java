package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *灾情分类：(DisasterClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DisasterClassification")
public class DisasterClassification implements Serializable {

    //DisasterClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disaster_classification_id")
    private Integer disaster_classification_id;
    // 灾情类型
    @Basic
    private String disaster_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
