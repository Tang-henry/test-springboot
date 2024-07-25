package org.getech.henry.service;

import org.getech.henry.dto.*;
import org.getech.henry.entity.DemoUser;
import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.starter.orm.service.IBaseService;

import java.util.List;

/**
 * <pre>
 * 测试用户 服务类
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @since 2020-03-19
 */
public interface IDemoUserService extends IBaseService<DemoUser> {

        /**
         * 分页查询，返回DTO
         *
         * @param demoUserQueryParam
         * @return
         */
        PageResult<DemoUserDTO> pageDTO(DemoUserQueryParam demoUserQueryParam);

        /**
         * 保存
         * @param demoUserAddParam
         * @return
         */
        boolean saveByParam(DemoUserAddParam demoUserAddParam);

        /**
         * 根据id查询，转DTO
         * @param id
         * @return
         */
        DemoUserDTO getDTOById(String id);

        /**
         * 批量保存
         * @param rows
         */
        boolean saveDTOBatch(List<DemoUserDTO> rows);

        /**
         * 更新
         * @param demoUserEditParam
         */
        boolean updateByParam(DemoUserEditParam demoUserEditParam);
}