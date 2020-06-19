package com.triumphxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.QrtzJobDetails;
import com.triumphxx.service.JobService;
import com.triumphxx.util.Result;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:06
 * @desc:测试job
 **/
@RestController
public class JobController  extends BaseController{

    @Autowired
    JobService jobService;

    @PostMapping("/job/add")
    public Result addJob(String jobClassName,String jobGroupName,String cron){

        return Result.success();
    }

    @PostMapping("/job/delete")
    public Result deleteJob(String jobClassName,String jobGroupName){

        return Result.success();
    }

    @PostMapping("/job/update")
    public Result updateJob(String jobClassName,String jobGroupName,String cron){

        return Result.success();
    }

    @PostMapping("/job/start")
    public void startJob(String jobClassName,String jobGroupName) throws SchedulerException {

        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        scheduler.resumeJob(JobKey.jobKey(list.get(0).getJobName(), list.get(0).getJobGroup()));
    }

    @PostMapping("job/stop")
    public void stopJob(String jobClassName,String jobGroupName) throws SchedulerException {

        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        scheduler.pauseJob(JobKey.jobKey(list.get(0).getJobName(), list.get(0).getJobGroup()));
    }


}
