package org.getech.henry.service.impl;

import org.getech.henry.entity.Order;
import org.getech.henry.mapper.OrderMapper;
import org.getech.henry.service.IOrderService;
import cn.getech.poros.starter.orm.service.impl.BaseServiceImpl;
import org.getech.henry.dto.OrderQueryParam;
import org.getech.henry.dto.OrderAddParam;
import org.getech.henry.dto.OrderEditParam;
import org.getech.henry.dto.OrderParamMapper;
import org.getech.henry.dto.OrderDTO;
import cn.getech.poros.starter.util.exception.Assert;
import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.framework.common.api.ResultCode;
import cn.getech.poros.starter.orm.bean.BaseEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * <pre>
 * 订单表 服务实现类
 * </pre>
 *
 * @author shitao2.tang@getech.cn
 * @since 2024-03-04
 */
@Slf4j
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderParamMapper orderParamMapper;

    @Override
    public PageResult<OrderDTO> pageDTO(OrderQueryParam orderQueryParam) {
        Wrapper<Order> wrapper = getPageSearchWrapper(orderQueryParam);
        PageResult<OrderDTO> result = orderParamMapper.pageEntity2DTO(page(orderQueryParam, wrapper));

        return Optional.ofNullable(result).orElse(new PageResult<>());
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveByParam(OrderAddParam orderAddParam) {
        Order order = orderParamMapper.addParam2Entity(orderAddParam);
        Assert.notNull(ResultCode.PARAM_VALID_ERROR, order);
        save(order);
        if (orderAddParam.getOrderId().equals("2") || orderAddParam.getOrderId().equals("6")) {
            throw new RuntimeException();
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean updateByParam(OrderEditParam orderEditParam) {
        Order order = orderParamMapper.editParam2Entity(orderEditParam);
        Assert.notNull(ResultCode.PARAM_VALID_ERROR, order);
        return updateById(order);
    }


    @Override
    public OrderDTO getDTOById(String id) {
        return orderParamMapper.entity2DTO((Order) this.getById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean saveDTOBatch(List<OrderDTO> rows) {
        return saveBatch(orderParamMapper.dtoList2Entity(rows));
    }

    private Wrapper<Order> getPageSearchWrapper(OrderQueryParam orderQueryParam) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.<Order>lambdaQuery();
        if (BaseEntity.class.isAssignableFrom(Order.class)) {
            wrapper.orderByDesc(Order::getUpdateTime, Order::getCreateTime);
        }
        return wrapper;
    }
}
