package com.triumphxx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.triumphxx.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class QrtzPausedTriggerGrps extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("SCHED_NAME")
    private String schedName;

    @TableField("TRIGGER_GROUP")
    private String triggerGroup;


}
