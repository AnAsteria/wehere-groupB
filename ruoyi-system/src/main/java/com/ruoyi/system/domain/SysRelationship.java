package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 关系管理对象 sys_relationship
 * 
 * @author Group9
 * @date 2022-03-23
 */
public class SysRelationship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 咨询师id */
    @Excel(name = "咨询师id")
    private Long consultantId;

    /** 督导id
 */
    @Excel(name = "督导id")
    private Long supervisorId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setConsultantId(Long consultantId) 
    {
        this.consultantId = consultantId;
    }

    public Long getConsultantId() 
    {
        return consultantId;
    }
    public void setSupervisorId(Long supervisorId) 
    {
        this.supervisorId = supervisorId;
    }

    public Long getSupervisorId() 
    {
        return supervisorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("consultantId", getConsultantId())
            .append("supervisorId", getSupervisorId())
            .toString();
    }
}
