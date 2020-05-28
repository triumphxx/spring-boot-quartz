package com.triumphxx.entity;

import java.time.LocalDate;
import com.triumphxx.entity.BaseEntity;
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
public class QrtzJobStats extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String jobName;

    private String jobGroup;

    private String jobStat;

    private String jobAdd;

    private LocalDate lastModifyDate;


}
