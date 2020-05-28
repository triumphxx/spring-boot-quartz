package com.triumphxx.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:04
 * @desc:我的定时任务测试
 **/
@Component
public class MyJob implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务以启动");
    }
}
