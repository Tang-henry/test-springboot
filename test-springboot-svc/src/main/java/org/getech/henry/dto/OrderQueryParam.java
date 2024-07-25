package org.getech.henry.dto;

import cn.getech.poros.framework.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 订单表分页查询参数对象
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @date 2024-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Order查询", description = "订单表查询参数")
public class OrderQueryParam extends PageParam {

    @ApiModelProperty(value = "主键")
    private Long id;
}
