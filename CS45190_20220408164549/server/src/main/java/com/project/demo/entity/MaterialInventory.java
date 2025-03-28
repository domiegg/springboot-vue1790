package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *物资库存：(MaterialInventory)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialInventory")
public class MaterialInventory implements Serializable {

    //MaterialInventory编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_inventory_id")
    private Integer material_inventory_id;
    // 物资名称
    @Basic
    private String material_name;
    // 物资类型
    @Basic
    private String material_type;
    // 物资数量
    @Basic
    private String quantity_of_materials;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
