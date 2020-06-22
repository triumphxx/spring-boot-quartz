package com.triumphxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.QrtzJobDetails;
import com.triumphxx.entity.vo.QuartzVo;
import com.triumphxx.service.JobService;
import com.triumphxx.service.QrtzJobDetailsService;
import com.triumphxx.util.Result;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:06
 * @desc:测试job
 **/
@Controller
public class JobController extends BaseController {

    @Autowired
    JobService jobService;
    @Autowired
    QrtzJobDetailsService qrtzJobDetailsService;

    @RequestMapping({"", "/"})
    public String index() {
        return "/view/index";
    }

    @GetMapping("/query/jobs")
    @ResponseBody
    public Result query() {
        List<QrtzJobDetails> list = qrtzJobDetailsService.list(new QueryWrapper<QrtzJobDetails>()
                .eq("SCHED_NAME", "clusteredScheduler")
        );
        return Result.success(list);
    }


    @PostMapping("/job/add")
    @ResponseBody
    public Result addJob(@RequestBody QuartzVo quartzVo) throws Exception {
        Result result = jobService.addJob(quartzVo.getJobClassName(), quartzVo.getJobGroupName(), quartzVo.getCron());
        return result;

    }

    @PostMapping("/job/delete")
    @ResponseBody
    public Result deleteJob(@RequestBody QuartzVo quartzVo) throws SchedulerException {
        Result result = jobService.deleteJob(quartzVo.getJobClassName(), quartzVo.getJobGroupName());
        return result;
    }

    @PostMapping("/job/update")
    @ResponseBody
    public Result updateJob(@RequestBody QuartzVo quartzVo) throws SchedulerException {
        Result result = jobService.updateJob(quartzVo.getJobClassName(), quartzVo.getJobGroupName(), quartzVo.getCron());
        return result;
    }

    @PostMapping("/job/start")
    @ResponseBody
    public Result startJob(@RequestBody QuartzVo quartzVo) throws SchedulerException {
        Result result = jobService.startJob(quartzVo.getJobClassName(), quartzVo.getJobGroupName());
        return result;
    }

    @PostMapping("job/stop")
    @ResponseBody
    public Result stopJob(@RequestBody QuartzVo quartzVo) throws SchedulerException {
        Result result = jobService.stopJob(quartzVo.getJobClassName(), quartzVo.getJobGroupName());
        return result;
    }


}
