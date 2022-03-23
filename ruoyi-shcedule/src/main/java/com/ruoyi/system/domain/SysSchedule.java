package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 排班表管理对象 sys_schedule
 * 
 * @author Group9
 * @date 2022-03-21
 */
public class SysSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 值班人员 */
    @Excel(name = "值班人员")
    private Long userId;

    /** 年 */
    @Excel(name = "年")
    private Integer year;

    /** 月 */
    @Excel(name = "月")
    private Integer month;

    /** 日 */
    @Excel(name = "日")
    private Integer day;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setYear(Integer year) 
    {
        this.year = year;
    }

    public Integer getYear() 
    {
        return year;
    }
    public void setMonth(Integer month) 
    {
        this.month = month;
    }

    public Integer getMonth() 
    {
        return month;
    }
    public void setDay(Integer day) 
    {
        this.day = day;
    }

    public Integer getDay() 
    {
        return day;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("year", getYear())
            .append("month", getMonth())
            .append("day", getDay())
            .toString();
    }
}
