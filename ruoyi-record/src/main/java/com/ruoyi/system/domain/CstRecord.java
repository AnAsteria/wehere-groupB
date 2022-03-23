package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 咨询管理对象 cst_record
 * 
 * @author Group9
 * @date 2022-03-21
 */
public class CstRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 被咨询者id */
    @Excel(name = "被咨询者id")
    private Long toId;

    /** 咨询者id
 */
    @Excel(name = "咨询者id")
    private Long fromId;

    /** 咨询记录的保存路径 */
    @Excel(name = "咨询记录的保存路径")
    private String recordPath;

    /** 记录的数量 */
    @Excel(name = "记录的数量")
    private Integer counts;

    /** 咨询记录的结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "咨询记录的结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setToId(Long toId) 
    {
        this.toId = toId;
    }

    public Long getToId() 
    {
        return toId;
    }
    public void setFromId(Long fromId) 
    {
        this.fromId = fromId;
    }

    public Long getFromId() 
    {
        return fromId;
    }
    public void setRecordPath(String recordPath) 
    {
        this.recordPath = recordPath;
    }

    public String getRecordPath() 
    {
        return recordPath;
    }
    public void setCounts(Integer counts) 
    {
        this.counts = counts;
    }

    public Integer getCounts() 
    {
        return counts;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("toId", getToId())
            .append("fromId", getFromId())
            .append("recordPath", getRecordPath())
            .append("counts", getCounts())
            .append("createTime", getCreateTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
