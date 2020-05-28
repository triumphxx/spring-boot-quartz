package com.triumphxx.config;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.QrtzJobDetails;
import com.triumphxx.service.QrtzJobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author:triumphxx
 * @Date:2020/5/10
 * @Time:7:40 下午
 * @desc:应用级别数据缓存
 **/
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {
    @Autowired
    QrtzJobDetailsService qrtzJobDetailsService;

    ServletContext servletContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        System.out.println("查询出来的数据是"+JSONUtil.formatJsonStr(list.toString()));
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
