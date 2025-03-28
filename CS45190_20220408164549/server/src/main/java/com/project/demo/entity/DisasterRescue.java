package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *灾情救援：(DisasterRescue)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DisasterRescue")
public class DisasterRescue implements Serializable {

    //DisasterRescue编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disaster_rescue_id")
    private Integer disaster_rescue_id;
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
    // 灾情情况
    @Basic
    private String disaster_situation;
    // 申请内容
    @Basic
    private String application_content;
    // 审核状态
    @Basic
    private String examine_state;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
