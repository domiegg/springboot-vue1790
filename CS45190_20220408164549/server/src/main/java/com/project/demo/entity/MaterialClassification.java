package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *物资分类：(MaterialClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialClassification")
public class MaterialClassification implements Serializable {

    //MaterialClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_classification_id")
    private Integer material_classification_id;
    // 物资类型
    @Basic
    private String material_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
