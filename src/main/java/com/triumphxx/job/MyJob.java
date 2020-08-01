package com.triumphxx.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.QrtzJobDetails;
import com.triumphxx.service.QrtzJobDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author:triumphxx
 * @Date:2020/8/1
 * @Time:3:38 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn/
 * @GitHub https://github.com/triumphxx
 **/
@Component
@Slf4j
public class MyJob implements BaseJob {

    @Autowired
    QrtzJobDetailsService qrtzJobDetailsService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务以启动");
        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        System.out.println(list);
        System.out.println("定时任务执行时间"+new Date());
    }
}