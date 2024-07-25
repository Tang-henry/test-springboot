package org.getech.henry.dto;

import cn.getech.poros.framework.common.param.ApiParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 测试用户 编辑参数对象
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @date 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DemoUser编辑", description = "测试用户编辑参数")
public class DemoUserEditParam extends ApiParam {

    @ApiModelProperty(value = "主键")
    private String  id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "描述")
    private String remark;

}
