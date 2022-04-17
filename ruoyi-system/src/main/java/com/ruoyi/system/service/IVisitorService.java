package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Visitor;

/**
 * 访客用户信息Service接口
 * 
 * @author Group9
 * @date 2022-04-06
 */
public interface IVisitorService 
{
    /**
     * 查询访客用户信息
     * 
     * @param visitorId 访客用户信息主键
     * @return 访客用户信息
     */
    public Visitor selectVisitorByVisitorId(String visitorId);

    /**
     * 查询访客用户信息列表
     * 
     * @param visitor 访客用户信息
     * @return 访客用户信息集合
     */
    public List<Visitor> selectVisitorList(Visitor visitor);

    /**
     * 新增访客用户信息
     * 
     * @param visitor 访客用户信息
     * @return 结果
     */
    public int insertVisitor(Visitor visitor);

    /**
     * 修改访客用户信息
     * 
     * @param visitor 访客用户信息
     * @return 结果
     */
    public int updateVisitor(Visitor visitor);

    /**
     * 批量删除访客用户信息
     * 
     * @param visitorIds 需要删除的访客用户信息主键集合
     * @return 结果
     */
    public int deleteVisitorByVisitorIds(String[] visitorIds);

    /**
     * 删除访客用户信息信息
     * 
     * @param visitorId 访客用户信息主键
     * @return 结果
     */
    public int deleteVisitorByVisitorId(String visitorId);
}
