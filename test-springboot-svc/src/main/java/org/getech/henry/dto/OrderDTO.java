package org.getech.henry.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <pre>
 * 订单表返回数据模型
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @date 2024-03-04
 */
@Data
@ApiModel(value = "OrderDTO", description = "订单表返回数据模型")
public class OrderDTO{

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
}