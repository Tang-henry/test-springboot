package org.getech.henry.test;

import org.getech.henry.Application;
import org.getech.henry.entity.DemoUser;
import org.getech.henry.service.IDemoUserService;
import cn.getech.poros.framework.common.param.PageParam;
import cn.getech.poros.starter.auth.bean.UserBaseInfo;
import cn.getech.poros.starter.auth.util.AuthUtils;
import cn.getech.poros.starter.util.context.PorosHolder;
import cn.getech.poros.starter.util.context.WebUtils;
import cn.getech.poros.starter.web.properties.PorosConfigProperties;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CommonTest
 * @Description: TODO
 * @Author hengji.li@getech.cn
 * @Date 2020/3/17
 * @Version V1.0
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestPorosFun {

    @Autowired
    private IDemoUserService demoUserService;

    @Test
    public void testContextHolder() {
        //获取当前request
        HttpServletRequest request = WebUtils.getRequest();
        Assert.notNull(request, "request is null");

        //获取当前用户信息
        UserBaseInfo userInfo = AuthUtils.getUser();
        Assert.notNull(userInfo, "current user is null");
        log.info("userInfo:{}", JSON.toJSONString(userInfo));

        //获取Bean
        PorosConfigProperties porosConfig = PorosHolder.getBean(PorosConfigProperties.class);
        Assert.notNull(porosConfig, "config is null");

        //获取系统变量配置项
        String jvmVersion = PorosHolder.getProperty("java.vm.version");
        Assert.notNull(jvmVersion, "jvmVersion is null");
        log.info("jvmVersion", jvmVersion);
    }

//    @Test
    public void testMybatisPlus() {
        String nameCondition = "tom";
        Integer ageCondition = 20;

        //复杂查询queryWrapper,推荐使用lambdaQuery,可避免一些物理字段定义散落在代码中
        //多条件and
        log.info("多条件and查询示例：");
        demoUserService.list(
                Wrappers.<DemoUser>lambdaQuery()
                        .like(DemoUser::getName, nameCondition)
                        .gt(DemoUser::getAge, ageCondition)
        );

        log.info("多条件or查询示例：");
        //多条件or
        demoUserService.list(
                Wrappers.<DemoUser>lambdaQuery()
                        .like(DemoUser::getName, nameCondition)
                        .or()
                        .gt(DemoUser::getAge, ageCondition)
        );

        log.info("排序查询示例：");
        //排序
        demoUserService.list(
                Wrappers.<DemoUser>lambdaQuery()
                        .like(DemoUser::getName, nameCondition)
                        .or()
                        .gt(DemoUser::getAge, ageCondition)
                        .orderByAsc(DemoUser::getAge)
        );

        //分页查询
        //默认从第一页开始
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(1);
        pageParam.setLimit(10);
        pageParam.setKeyword("tom");

        log.info("分页查询示例：");
        demoUserService.page(new Page<>(),
                Wrappers.<DemoUser>lambdaQuery()
                        .like(DemoUser::getName, pageParam.getKeyword())
                        .or()
                        .gt(DemoUser::getAge, ageCondition)
                        .orderByAsc(DemoUser::getAge)
        );


        //只查询指定字段
        log.info("只查询指定字段id,name,age-示例：");
        demoUserService.page(new Page<>(),
                Wrappers.<DemoUser>lambdaQuery()
                        .select(DemoUser::getId, DemoUser::getName, DemoUser::getAge)
                        .like(DemoUser::getName, pageParam.getKeyword())
                        .or()
                        .gt(DemoUser::getAge, ageCondition)
                        .orderByAsc(DemoUser::getAge)
        );

        //只查询除指定字段之外的字段
        log.info("只查询除指定字段create_time之外的字段-示例：");
        demoUserService.page(new Page<>(),
                Wrappers.<DemoUser>lambdaQuery()
                        .select(DemoUser.class, tableFieldInfo -> !tableFieldInfo.getColumn().equals("create_time"))
                        .like(DemoUser::getName, pageParam.getKeyword())
                        .or()
                        .gt(DemoUser::getAge, ageCondition)
                        .orderByAsc(DemoUser::getAge)
        );


    }
}
