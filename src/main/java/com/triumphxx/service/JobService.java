package com.triumphxx.service;

import com.triumphxx.util.Result;
import org.quartz.SchedulerException;

/**
 * @author:triumphxx
 * @Date:2020/6/14
 * @Time:6:00 下午
 * @微信公众号：北漂码农有话说
 * @desc:
 **/
public interface JobService {

    /**
     * 新增job任务
     *
     * @param jobClassName     job名称
     * @param jobGroupName     job分组名称
     * @param cron             cron 表达式
     * @throws SchedulerException
     */
    Result addJob(String jobClassName, String jobGroupName, String cron) throws Exception;

    /**
     * 删除定时任务
     *
     * @param jobClassName     job名称
     * @param jobGroupName     job分组名称
     * @throws SchedulerException
     */
    Result deleteJob(String jobClassName, String jobGroupName) throws SchedulerException;
    /**
     * 修改定时任务
     * @param jobClassName     job名称
     * @param jobGroupName     job分组名称
     * @param cron             cron 表达式
     */
    Result updateJob(String jobClassName, String jobGroupName, String cron) throws SchedulerException;

    /**
     * 启动定时任务
     * @param jobClassName
     * @param jobGroupName
     * @return
     */
    Result startJob(String jobClassName, String jobGroupName) throws SchedulerException;

    /**
     * 停止定时任务
     * @param jobClassName
     * @param jobGroupName
     * @return
     */
    Result stopJob(String jobClassName, String jobGroupName) throws SchedulerException;

}
