package org.getech.henry.service;

import org.getech.henry.entity.Order;
import cn.getech.poros.starter.orm.service.IBaseService;
import org.getech.henry.dto.OrderQueryParam;
import org.getech.henry.dto.OrderAddParam;
import org.getech.henry.dto.OrderEditParam;
import org.getech.henry.dto.OrderDTO;
import cn.getech.poros.framework.common.api.PageResult;

import java.util.List;

/**
 * <pre>
 * 订单表 服务类
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @since 2024-03-04
 */
public interface IOrderService extends IBaseService<Order> {

    /**
     * 分页查询，返回DTO
     *
     * @param orderQueryParam
     * @return
     */
    PageResult<OrderDTO> pageDTO(OrderQueryParam orderQueryParam);

    /**
     * 保存
     * @param orderAddParam
     * @return
     */
    boolean saveByParam(OrderAddParam orderAddParam);

    /**
     * 根据id查询，转dto
     * @param id
     * @return
     */
    OrderDTO getDTOById(String id);

    /**
     * 批量保存
     * @param rows
     */
    boolean saveDTOBatch(List<OrderDTO> rows);

    /**
     * 更新
     * @param orderEditParam
     */
    boolean updateByParam(OrderEditParam orderEditParam);
}