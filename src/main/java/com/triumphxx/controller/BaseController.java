package com.triumphxx.controller;

import com.triumphxx.service.QrtzJobDetailsService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:13:59
 * @desc:基础控制器类
 **/
public class BaseController {

    @Autowired
    QrtzJobDetailsService qrtzJobDetailsService;

    @Autowired
    Scheduler scheduler;
}
