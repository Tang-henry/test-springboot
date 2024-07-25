package org.getech.henry.controller;


import org.getech.henry.dto.*;
import org.getech.henry.service.IDemoUserService;
import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.framework.common.api.RestResponse;
import cn.getech.poros.starter.logging.auditlog.AuditLog;
import cn.getech.poros.starter.logging.auditlog.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <p>
 * DemoUser测试用户控制器
 * </p>
 *
 * @author hengji.li@getech.cn
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/api/test-springboot/demoUser")
@Api(tags = "DemoUser测试用户服务接口")
public class DemoUserController {

    @Autowired
    private IDemoUserService demoUserService;

    /**
     * 分页获取DemoUser测试用户列表
     */
    @ApiOperation("分页获取DemoUser测试用户列表")
    @GetMapping("/list")
    public RestResponse<PageResult<DemoUserDTO>> pageList(@Valid DemoUserQueryParam demoUserQueryParam){
        return RestResponse.ok(demoUserService.pageDTO(demoUserQueryParam));
    }

    /**
     * 新增DemoUser测试用户
     */
    @ApiOperation("新增DemoUser测试用户")
    @AuditLog(title = "DemoUser测试用户",desc = "新增DemoUser测试用户",businessType = BusinessType.INSERT)
    @PostMapping
    public RestResponse<Boolean> add(@RequestBody @Valid DemoUserAddParam demoUserAddParam) {
        return RestResponse.ok(demoUserService.saveByParam(demoUserAddParam));
    }

    /**
     * 修改DemoUser测试用户
     */
    @ApiOperation(value="修改DemoUser测试用户")
    @AuditLog(title = "DemoUser测试用户",desc = "修改DemoUser测试用户",businessType = BusinessType.UPDATE)
    @PutMapping
    public RestResponse<Boolean> update(@RequestBody @Valid DemoUserEditParam demoUserEditParam) {
        return RestResponse.ok(demoUserService.updateByParam(demoUserEditParam));
    }

    /**
     * 根据id删除DemoUser测试用户
     */
    @ApiOperation(value="根据id删除DemoUser测试用户")
    @AuditLog(title = "DemoUser测试用户",desc = "DemoUser测试用户",businessType = BusinessType.DELETE)
    @DeleteMapping
    public RestResponse<Boolean> delete(@RequestBody @NotEmpty List<String> ids) {
        return RestResponse.ok(demoUserService.removeByIds(ids));
    }

    /**
     * 根据id获取DemoUser测试用户
     */
    @ApiOperation(value = "根据id获取DemoUser测试用户")
    @GetMapping(value = "/{id}")
    public RestResponse<DemoUserDTO> get(@PathVariable  String id) {
        return RestResponse.ok(demoUserService.getDTOById(id));
    }

}
