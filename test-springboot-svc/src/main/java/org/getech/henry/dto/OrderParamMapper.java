package org.getech.henry.dto;

import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.starter.orm.bean.BaseEntity;
import org.getech.henry.entity.Order;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * <pre>
 * 订单表参数实体映射
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @date 2024-03-04
 */
@Mapper(componentModel = "spring",imports = {BaseEntity.class})
public interface  OrderParamMapper{

    /**
     * 新增参数转换为实体
     *
     * @param orderAddParam
     * @return
     */
    Order addParam2Entity(OrderAddParam orderAddParam);

    /**
     * 编辑参数转换为实体
     * @param orderEditParam
     * @return
     */
    Order editParam2Entity(OrderEditParam orderEditParam);

    /**
     * 实体转换为DTO
     * @param order
     * @return
     */
    OrderDTO entity2DTO(Order order);

    /**
     * 分页实体转DTO
     * @param page
     * @return
     */
    PageResult<OrderDTO> pageEntity2DTO(PageResult<Order> page);


    /**
     * dto集合转entity集合
     * @param rows
     * @return
     */
    List<Order> dtoList2Entity(List<OrderDTO> rows);

}
