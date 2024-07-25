package org.getech.henry.dto;

import org.getech.henry.entity.DemoUser;
import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.starter.orm.bean.BaseEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <pre>
 * 测试用户 参数实体映射
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @date 2020-03-19
 */
@Mapper(componentModel = "spring",imports = {BaseEntity.class})
public interface  DemoUserParamMapper{

    /**
     * 新增参数转换为实体
     *
     * @param demoUserAddParam
     * @return
     */
    DemoUser addParam2Entity(DemoUserAddParam demoUserAddParam);

    /**
     * 编辑参数转换为实体
     * @param demoUserEditParam
     * @return
     */
    DemoUser editParam2Entity(DemoUserEditParam demoUserEditParam);

    /**
     * 实体转换为DTO
     * @param demoUser
     * @return
     */
    DemoUserDTO entity2DTO(DemoUser demoUser);

    /**
     * 分页实体转DTO
     * @param page
     * @return
     */
    PageResult<DemoUserDTO> pageEntity2DTO(PageResult<DemoUser> page);


    /**
     * DTO集合转entity集合
     * @param rows
     * @return
     */
    List<DemoUser> DTOList2Entity(List<DemoUserDTO> rows);

}
