package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class SuSysSchedule{
    private static final long serialVersionUID = 1L;

    /** 主键
     主键 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 排班日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "排班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    @Excel(name = "部门id")
    private Long deptId;

    @Excel(name = "昵称")
    private String nickName;

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return id;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return userName;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }
    public Date getTime()
    {
        return time;
    }

    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userName", getUserName())
                .append("time", getTime())
                .append("deptId", getDeptId().toString())
                .append("nickName", getNickName())
                .toString();
    }
}
