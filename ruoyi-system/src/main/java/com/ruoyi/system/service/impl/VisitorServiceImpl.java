package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Visitor;
import com.ruoyi.system.mapper.VisitorMapper;
import com.ruoyi.system.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 访客用户信息Service业务层处理
 * 
 * @author Group9
 * @date 2022-04-06
 */
@Service
public class VisitorServiceImpl implements IVisitorService 
{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private VisitorMapper visitorMapper;

    /**
     * 查询访客用户信息
     * 
     * @param visitorId 访客用户信息主键
     * @return 访客用户信息
     */
    @Override
    public Visitor selectVisitorByVisitorId(String visitorId)
    {
        return visitorMapper.selectVisitorByVisitorId(visitorId);
    }

    /**
     * 查询访客用户信息列表
     * 
     * @param visitor 访客用户信息
     * @return 访客用户信息
     */
    @Override
    public List<Visitor> selectVisitorList(Visitor visitor)
    {
        return visitorMapper.selectVisitorList(visitor);
    }

    /**
     * 新增访客用户信息
     * 
     * @param visitor 访客用户信息
     * @return 结果
     */
    @Override
    public int insertVisitor(Visitor visitor)
    {
        return visitorMapper.insertVisitor(visitor);
    }

    /**
     * 修改访客用户信息
     * 
     * @param visitor 访客用户信息
     * @return 结果
     */
    @Override
    public int updateVisitor(Visitor visitor)
    {
        return visitorMapper.updateVisitor(visitor);
    }

    /**
     * 批量删除访客用户信息
     * 
     * @param visitorIds 需要删除的访客用户信息主键
     * @return 结果
     */
    @Override
    public int deleteVisitorByVisitorIds(String[] visitorIds)
    {
        return visitorMapper.deleteVisitorByVisitorIds(visitorIds);
    }

    /**
     * 删除访客用户信息信息
     * 
     * @param visitorId 访客用户信息主键
     * @return 结果
     */
    @Override
    public int deleteVisitorByVisitorId(String visitorId)
    {
        return visitorMapper.deleteVisitorByVisitorId(visitorId);
    }
}
