package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评价系统对象 sys_evaluation
 * 
 * @author Group9
 * @date 2022-04-15
 */
public class SysEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 评价者id */
    @Excel(name = "评价者id")
    private Long fromId;

    /** 受评者id */
    @Excel(name = "受评者id")
    private Long toId;

    /** 得分 */
    @Excel(name = "得分")
    private Long score;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFromId(Long fromId) 
    {
        this.fromId = fromId;
    }

    public Long getFromId() 
    {
        return fromId;
    }
    public void setToId(Long toId) 
    {
        this.toId = toId;
    }

    public Long getToId() 
    {
        return toId;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fromId", getFromId())
            .append("toId", getToId())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .toString();
    }
}
