package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *救援计划：(RescuePlan)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RescuePlan")
public class RescuePlan implements Serializable {

    //RescuePlan编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rescue_plan_id")
    private Integer rescue_plan_id;
    // 用户编号
    @Basic
    private Integer user_number;
    // 用户姓名
    @Basic
    private String user_name;
    // 联系方式
    @Basic
    private String contact_information;
    // 身份证
    @Basic
    private String id;
    // 灾情地址
    @Basic
    private String disaster_address;
    // 灾情类型
    @Basic
    private String disaster_type;
    // 申请物资
    @Basic
    private String apply_for_materials;
    // 物资类型
    @Basic
    private String material_type;
    // 申请时间
    @Basic
    private Timestamp application_time;
    // 计划名称
    @Basic
    private String plan_name;
    // 计划类型
    @Basic
    private String plan_type;
    // 紧急程度
    @Basic
    private String degree_of_urgency;
    // 预计救援时间
    @Basic
    private Timestamp estimated_rescue_time;
    // 灾情情况
    @Basic
    private String disaster_situation;
    // 申请内容
    @Basic
    private String application_content;
    // 计划内容
    @Basic
    private String plan_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
