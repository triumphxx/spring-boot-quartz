package com.triumphxx.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:01
 * @desc:定时任务基础类
 **/
public interface BaseJob extends Job {
    @Override
    void execute(JobExecutionContext context) throws JobExecutionException;
}
