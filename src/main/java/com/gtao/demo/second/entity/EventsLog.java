package com.gtao.demo.second.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author gtao
 * @since 2020-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("events_log")
@ApiModel(value="EventsLog对象", description="操作日志表")
public class EventsLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "系统类型枚举")
    @TableField("system_type")
    private String systemType;

    @ApiModelProperty(value = "模块类型")
    @TableField("model_type")
    private String modelType;

    @ApiModelProperty(value = "类型枚举 add:新增 edit:修改 del:删除")
    @TableField("operation_type")
    private String operationType;

    @ApiModelProperty(value = "关联id")
    @TableField("nexus_id")
    private Integer nexusId;

    @ApiModelProperty(value = "操作内容")
    @TableField("info")
    private String info;

    @ApiModelProperty(value = "操作记录")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "创建人id")
    @TableField("creator_id")
    private Integer creatorId;

    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "创建人所属部门id")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "创建人所属部门名")
    @TableField("department")
    private String department;

    @TableField("creation_time")
    private Date creationTime;


}
