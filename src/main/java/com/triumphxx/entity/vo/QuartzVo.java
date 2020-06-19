package com.triumphxx.entity.vo;

import lombok.Data;

/**
 * @author:triumphxx
 * @Date:2020/6/19
 * @Time:12:39 下午
 * @微信公众号：北漂码农有话说
 * @desc: 接收页面参数
 **/
@Data
public class QuartzVo {
    /**
     * 定时任务类全称
     */
    private String jobClassName;
    /**
     * 定时任务所属组
     */
    private String jobGroupName;
    /**
     * cron 表达式
     */
    private String cron;
}
