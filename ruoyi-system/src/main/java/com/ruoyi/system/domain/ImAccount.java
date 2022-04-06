package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * IMAccount管理对象 im_account
 * 
 * @author Group9
 * @date 2022-03-31
 */
public class ImAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** im账户名 */
    @Excel(name = "im账户名")
    private String imAccountName;

    /** im账户类型 */
    @Excel(name = "im账户类型")
    private String imAccountType;

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
    public void setImAccountName(String imAccountName) 
    {
        this.imAccountName = imAccountName;
    }

    public String getImAccountName() 
    {
        return imAccountName;
    }
    public void setImAccountType(String imAccountType) 
    {
        this.imAccountType = imAccountType;
    }

    public String getImAccountType() 
    {
        return imAccountType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("imAccountName", getImAccountName())
            .append("imAccountType", getImAccountType())
            .toString();
    }
}
