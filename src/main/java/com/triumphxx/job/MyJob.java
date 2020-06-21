package com.triumphxx.job;

import cn.hutool.json.JSONUtil;
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
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:04
 * @desc:我的定时任务测试
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
