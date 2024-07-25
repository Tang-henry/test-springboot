package org.getech.henry.controller;

import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.framework.common.api.RestResponse;
import cn.getech.poros.starter.logging.auditlog.AuditLog;
import cn.getech.poros.starter.logging.auditlog.BusinessType;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.getech.henry.dto.OrderQueryParam;
import org.getech.henry.dto.OrderAddParam;
import org.getech.henry.dto.OrderEditParam;
import org.getech.henry.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import javax.validation.constraints.NotEmpty;

import org.getech.henry.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * test控制器
 * </p>
 *
 * @author shitao2.tang@getech.cn
 * @since 2024-03-04
 */
@RestController
@Slf4j
@RequestMapping("/api/order")
@Api(tags = "test服务接口")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 分页获取test列表
     */
    @ApiOperation("分页获取test列表")
    @GetMapping("/list")
    public RestResponse<PageResult<OrderDTO>> pageList(@Valid OrderQueryParam orderQueryParam) {
        return RestResponse.ok(orderService.pageDTO(orderQueryParam));
    }

    /**
     * 新增test
     */
    @ApiOperation("新增test")
    @AuditLog(title = "test", desc = "新增test", businessType = BusinessType.INSERT)
    @PostMapping
    public RestResponse<Boolean> add(@RequestBody @Valid List<OrderAddParam> orderAddParam) {
        List<String> errorList = Lists.newArrayList();
        for (OrderAddParam addParam : orderAddParam) {
            try {
                orderService.saveByParam(addParam);
            } catch (Exception e) {
                errorList.add(addParam.getOrderId() + "异常回滚");
            }
        }
        log.info("error:{}", JSONUtil.toJsonStr(errorList));
        return RestResponse.ok();
    }

    /**
     * 修改test
     */
    @ApiOperation(value = "修改test")
    @AuditLog(title = "test", desc = "修改test", businessType = BusinessType.UPDATE)
    @PutMapping
    public RestResponse<Boolean> update(@RequestBody @Valid OrderEditParam orderEditParam) {
        return RestResponse.ok(orderService.updateByParam(orderEditParam));
    }

    /**
     * 根据ids删除test
     */
    @ApiOperation(value = "根据id删除test")
    @AuditLog(title = "test", desc = "test", businessType = BusinessType.DELETE)
    @DeleteMapping
    public RestResponse<Boolean> delete(@RequestBody @NotEmpty List<String> ids) {
        return RestResponse.ok(orderService.removeByIds(ids));
    }

    /**
     * 根据id获取test
     */
    @ApiOperation(value = "根据id获取test")
    @GetMapping(value = "/{id}")
    public RestResponse<OrderDTO> get(@PathVariable String id) {
        return RestResponse.ok(orderService.getDTOById(id));
    }

}
