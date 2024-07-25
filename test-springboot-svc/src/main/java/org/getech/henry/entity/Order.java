package org.getech.henry.entity;

import cn.getech.poros.starter.orm.bean.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author shitao2.tang@getech.cn
 * @since 2024-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("order_log")
public class Order extends BaseEntity {

    /**
     * 订单ID
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 订单金额
     */
    @TableField("amount")
    private BigDecimal amount;



    public static final String ORDER_ID = "order_id";

    public static final String AMOUNT = "amount";

}
