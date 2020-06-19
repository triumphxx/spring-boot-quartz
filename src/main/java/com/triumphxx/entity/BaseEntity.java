package com.triumphxx.entity;

import lombok.Data;

/**
 * @author:wangyupeng
 * @Date:2020/5/28
 * @Time:14:00
 * @desc:基础实体类
 **/
@Data
public class BaseEntity {
    /**
     * job名称
     */
    String jobName;
    /**
     * job分组名称
      */
    String  jobGroupName;
    /**
     * 触发器名称
     */
    String  triggerName;
    /**
     * 触发器分组名称
     */
    String triggerGroupName;
    /**
     * 需要执行的job.class
     */
    Class  jobClass;
    /**
     * cron 表达式
     */
    String cron;
}
