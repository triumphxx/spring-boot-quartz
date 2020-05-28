package com.triumphxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.QrtzJobDetails;
import com.triumphxx.service.QrtzJobDetailsService;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:06
 * @desc:测试job
 **/
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    QrtzJobDetailsService qrtzJobDetailsService;

    @Autowired
    Scheduler scheduler;

    @RequestMapping("start")
    public void resumeJob() throws SchedulerException {

        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        scheduler.resumeJob(JobKey.jobKey(list.get(0).getJobName(), list.get(0).getJobGroup()));
    }

    @RequestMapping("stop")
    public void pauseJob() throws SchedulerException {

        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        scheduler.pauseJob(JobKey.jobKey(list.get(0).getJobName(), list.get(0).getJobGroup()));
    }
}
