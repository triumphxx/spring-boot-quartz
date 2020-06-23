package com.triumphxx.service;

import com.triumphxx.job.BaseJob;
import com.triumphxx.util.Result;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author:triumphxx
 * @Date:2020/6/14
 * @Time:5:55 下午
 * @微信公众号：北漂码农有话说
 * @desc:
 **/
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    Scheduler scheduler;
    /**
     * 新增job任务
     *
     * @param jobName      job名称
     * @param jobGroupName job分组名称
     * @param cron         cron 表达式
     * @throws SchedulerException
     */
    public Result addJob(String jobName, String jobGroupName, String cron) throws Exception {
        //校验cron表达式 是否符合规范
        boolean b = CronExpression.isValidExpression(cron);
        if (!b){
            return Result.fail("cron表达式书写有误，请重新提交");
        }
        // 启动调度器
        scheduler.start();
        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobName).getClass()).withIdentity(jobName, jobGroupName).build();
        //cron表达式调度器构建
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        //构建 Trigger
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName).withSchedule(scheduleBuilder).build();
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);
        if (date==null){
            return Result.fail("添加定时任务失败");
        }
        return Result.success();
    }


    /**
     * 删除job
     *
     * @param jobName  任务名称
     * @param jobGroup 任务分组
     * @throws SchedulerException
     */
    public Result deleteJob(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        boolean deleteJob = scheduler.deleteJob(jobKey);
        if (!deleteJob){
            return Result.fail("删除定时任务失败");
        }
        return Result.success();
    }

    /**
     * 修改定时任务
     *
     * @param jobName      job名称
     * @param jobGroupName job分组名称
     * @param cron         cron 表达式
     */
    public Result updateJob(String jobName, String jobGroupName, String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //重新构建表达式trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        Date date = scheduler.rescheduleJob(triggerKey, trigger);
        if (date==null){
            return Result.fail("添加定时任务失败");
        }
        return Result.success();

    }

    /**
     * 启动定时任务
     * @param jobClassName 任务名称
     * @param jobGroupName 任务所属组
     * @return
     * @throws SchedulerException
     */
    @Override
    public Result startJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jobClassName,jobGroupName));
        return Result.success();
    }

    /**
     * 停止定时任务
     * @param jobClassName 任务名称
     * @param jobGroupName 任务所属组
     * @return
     * @throws SchedulerException
     */
    @Override
    public Result stopJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobClassName,jobGroupName));
        return Result.success();
    }


    private BaseJob getClass(String jobName) throws Exception {
        Class<?> class1 = Class.forName(jobName);
        return (BaseJob) class1.newInstance();
    }

}
