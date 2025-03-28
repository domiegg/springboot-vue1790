package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *物资入库：(Material)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Material")
public class Material implements Serializable {

    //Material编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer material_id;
    // 物资名称
    @Basic
    private String material_name;
    // 物资类型
    @Basic
    private String material_type;
    // 入库数量
    @Basic
    private Integer receipt_quantity;
    // 入库时间
    @Basic
    private Timestamp warehousing_time;
    // 物资来源
    @Basic
    private String material_source;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
