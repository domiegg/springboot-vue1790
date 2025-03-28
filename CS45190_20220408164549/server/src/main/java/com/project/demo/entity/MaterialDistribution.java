package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *物资发放：(MaterialDistribution)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialDistribution")
public class MaterialDistribution implements Serializable {

    //MaterialDistribution编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_distribution_id")
    private Integer material_distribution_id;
    // 物资名称
    @Basic
    private String material_name;
    // 物资类型
    @Basic
    private String material_type;
    // 发放数量
    @Basic
    private Integer issued_quantity;
    // 发放时间
    @Basic
    private Timestamp release_time;
    // 物资流向
    @Basic
    private String material_flow_direction;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
