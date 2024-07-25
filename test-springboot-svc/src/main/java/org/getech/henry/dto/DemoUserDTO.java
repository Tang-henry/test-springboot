package org.getech.henry.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <pre>
 * 测试用户 返回数据模型
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @date 2020-03-19
 */
@Data
@ApiModel(value = "DemoUserDTO", description = "测试用户返回数据模型")
public class DemoUserDTO{

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "描述")
    private String remark;

}
