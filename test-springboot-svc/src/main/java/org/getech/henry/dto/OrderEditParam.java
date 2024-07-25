package org.getech.henry.dto;

import cn.getech.poros.framework.common.param.ApiParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 订单表编辑参数对象
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @date 2024-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Order编辑", description = "订单表编辑参数")
public class OrderEditParam extends ApiParam {

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "订单ID")
    private String orderId;

}
