package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *物资管理：(MaterialManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialManagement")
public class MaterialManagement implements Serializable {

    //MaterialManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_management_id")
    private Integer material_management_id;
    // 物资名称
    @Basic
    private String material_name;
    // 物资类型
    @Basic
    private String material_type;
    // 物资数量
    @Basic
    private String quantity_of_materials;
    // 物资图片
    @Basic
    private String material_picture;
    // 物资简介
    @Basic
    private String material_introduction;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
