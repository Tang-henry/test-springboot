package org.getech.henry.dto;

import cn.getech.poros.framework.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 测试用户 分页查询参数对象
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @date 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DemoUser查询", description = "测试用户查询参数")
public class DemoUserQueryParam extends PageParam {

    @ApiModelProperty(value = "姓名")
    private String name;

}
