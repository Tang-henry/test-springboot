package org.getech.henry.dto;

import cn.getech.poros.framework.common.param.ApiParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 订单表新增参数
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @date 2024-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Order新增", description = "订单表新增参数")
public class OrderAddParam extends ApiParam {

    @ApiModelProperty(value = "订单ID")
    private String orderId;

}