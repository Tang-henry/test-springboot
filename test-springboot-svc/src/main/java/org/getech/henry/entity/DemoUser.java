package org.getech.henry.entity;

import cn.getech.poros.starter.orm.bean.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 测试用户
 * </p>
 *
 * @author hengji.li@getech.cn
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("poros_demo_user")
public class DemoUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;




}
