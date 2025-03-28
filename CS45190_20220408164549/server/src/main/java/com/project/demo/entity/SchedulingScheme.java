package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *调度方案：(SchedulingScheme)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SchedulingScheme")
public class SchedulingScheme implements Serializable {

    //SchedulingScheme编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduling_scheme_id")
    private Integer scheduling_scheme_id;
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
    // 救援名称
    @Basic
    private String rescue_name;
    // 救援类型
    @Basic
    private String rescue_type;
    // 人员数量
    @Basic
    private String number_of_personnel;
    // 救援时间
    @Basic
    private Timestamp rescue_time;
    // 物资总量
    @Basic
    private String total_amount_of_materials;
    // 灾情情况
    @Basic
    private String disaster_situation;
    // 申请内容
    @Basic
    private String application_content;
    // 计划内容
    @Basic
    private String plan_content;
    // 救援人员
    @Basic
    private String rescue_workers;
    // 救援方案
    @Basic
    private String rescue_plan;
    // 救援物资
    @Basic
    private String relief_supplies;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
