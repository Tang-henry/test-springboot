package org.getech.henry.service.impl;

import org.getech.henry.dto.*;
import org.getech.henry.entity.DemoUser;
import org.getech.henry.mapper.DemoUserMapper;
import org.getech.henry.service.IDemoUserService;
import cn.getech.poros.starter.util.exception.Assert;
import cn.getech.poros.framework.common.api.PageResult;
import cn.getech.poros.framework.common.api.ResultCode;
import cn.getech.poros.starter.orm.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



/**
 * <pre>
 * 测试用户 服务实现类
 * </pre>
 *
 * @author hengji.li@getech.cn
 * @since 2020-03-19
 */
@Slf4j
@Service
public class DemoUserServiceImpl extends BaseServiceImpl<DemoUserMapper, DemoUser> implements IDemoUserService {

    @Autowired
    private DemoUserParamMapper demoUserParamMapper;

    @Override
    public PageResult<DemoUserDTO> pageDTO(DemoUserQueryParam demoUserQueryParam) {
        Wrapper<DemoUser> wrapper = getPageSearchWrapper(demoUserQueryParam);
        PageResult<DemoUserDTO> result = demoUserParamMapper.pageEntity2DTO(page(demoUserQueryParam, wrapper));

        return Optional.ofNullable(result).orElse(new PageResult<>());
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean saveByParam(DemoUserAddParam demoUserAddParam) {
        DemoUser demoUser = demoUserParamMapper.addParam2Entity(demoUserAddParam);
        Assert.notNull(ResultCode.PARAM_VALID_ERROR,demoUser);
        return save(demoUser);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean updateByParam(DemoUserEditParam demoUserEditParam) {
        DemoUser demoUser = demoUserParamMapper.editParam2Entity(demoUserEditParam);
        Assert.notNull(ResultCode.PARAM_VALID_ERROR,demoUser);
        return updateById(demoUser);
    }

    @Override
    public DemoUserDTO getDTOById(String id) {
        return demoUserParamMapper.entity2DTO((DemoUser) this.getById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean saveDTOBatch(List<DemoUserDTO> rows) {
        return saveBatch(demoUserParamMapper.DTOList2Entity(rows));
    }

    private Wrapper<DemoUser> getPageSearchWrapper(DemoUserQueryParam demoUserQueryParam) {
        LambdaQueryWrapper<DemoUser> wrapper = Wrappers.<DemoUser>lambdaQuery();
        wrapper.like(StringUtils.isNotBlank(demoUserQueryParam.getName()),
                     DemoUser::getName, demoUserQueryParam.getName());
        return wrapper;
    }
}
