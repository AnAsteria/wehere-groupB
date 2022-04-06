package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客用户信息对象 visitor
 * 
 * @author Group9
 * @date 2022-04-06
 */
public class Visitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 访客id */
    private String visitorId;

    /** 访客姓名 */
    @Excel(name = "访客姓名")
    private String visitName;

    /** 访客电话 */
    @Excel(name = "访客电话")
    private String visitorTelephone;

    /** 紧急联系人姓名 */
    @Excel(name = "紧急联系人姓名")
    private String emergencyContactName;

    /** 紧急联系人电话 */
    @Excel(name = "紧急联系人电话")
    private String emergencyContactTelephone;

    /** 访问权限 */
    @Excel(name = "访问权限")
    private String limitsOfAuthority;

    public void setVisitorId(String visitorId) 
    {
        this.visitorId = visitorId;
    }

    public String getVisitorId() 
    {
        return visitorId;
    }
    public void setVisitName(String visitName) 
    {
        this.visitName = visitName;
    }

    public String getVisitName() 
    {
        return visitName;
    }
    public void setVisitorTelephone(String visitorTelephone) 
    {
        this.visitorTelephone = visitorTelephone;
    }

    public String getVisitorTelephone() 
    {
        return visitorTelephone;
    }
    public void setEmergencyContactName(String emergencyContactName) 
    {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactName() 
    {
        return emergencyContactName;
    }
    public void setEmergencyContactTelephone(String emergencyContactTelephone) 
    {
        this.emergencyContactTelephone = emergencyContactTelephone;
    }

    public String getEmergencyContactTelephone() 
    {
        return emergencyContactTelephone;
    }
    public void setLimitsOfAuthority(String limitsOfAuthority) 
    {
        this.limitsOfAuthority = limitsOfAuthority;
    }

    public String getLimitsOfAuthority() 
    {
        return limitsOfAuthority;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("visitorId", getVisitorId())
            .append("visitName", getVisitName())
            .append("visitorTelephone", getVisitorTelephone())
            .append("emergencyContactName", getEmergencyContactName())
            .append("emergencyContactTelephone", getEmergencyContactTelephone())
            .append("limitsOfAuthority", getLimitsOfAuthority())
            .toString();
    }
}
