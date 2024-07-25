package org.getech.henry.client;

import org.getech.henry.dto.DemoClientDTO;
import cn.getech.poros.framework.common.api.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hengji.li@getech.cn
 * @date 2020/3/3
 */
@FeignClient(name = "test-springboot-api",path = "/api/test-springboot")
@Validated
public interface DemoUserClient {

    /**
     * demoUser
     *
     * @param id
     * @return RestResponse<DemoClientDTO>
     */
    @GetMapping(value = "/demoUser/{id}")
    RestResponse<DemoClientDTO> getById(@PathVariable String id);
}
