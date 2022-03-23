package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysRelationship;
import com.ruoyi.system.mapper.SysRelationshipMapper;
import com.ruoyi.system.service.ISysRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关系管理Service业务层处理
 * 
 * @author Group9
 * @date 2022-03-23
 */
@Service
public class SysRelationshipServiceImpl implements ISysRelationshipService 
{
    @Autowired
    private SysRelationshipMapper sysRelationshipMapper;

    /**
     * 查询关系管理
     * 
     * @param id 关系管理主键
     * @return 关系管理
     */
    @Override
    public SysRelationship selectSysRelationshipById(Long id)
    {
        return sysRelationshipMapper.selectSysRelationshipById(id);
    }

    /**
     * 查询关系管理列表
     * 
     * @param sysRelationship 关系管理
     * @return 关系管理
     */
    @Override
    public List<SysRelationship> selectSysRelationshipList(SysRelationship sysRelationship)
    {
        return sysRelationshipMapper.selectSysRelationshipList(sysRelationship);
    }

    /**
     * 新增关系管理
     * 
     * @param sysRelationship 关系管理
     * @return 结果
     */
    @Override
    public int insertSysRelationship(SysRelationship sysRelationship)
    {
        return sysRelationshipMapper.insertSysRelationship(sysRelationship);
    }

    /**
     * 修改关系管理
     * 
     * @param sysRelationship 关系管理
     * @return 结果
     */
    @Override
    public int updateSysRelationship(SysRelationship sysRelationship)
    {
        return sysRelationshipMapper.updateSysRelationship(sysRelationship);
    }

    /**
     * 批量删除关系管理
     * 
     * @param ids 需要删除的关系管理主键
     * @return 结果
     */
    @Override
    public int deleteSysRelationshipByIds(Long[] ids)
    {
        return sysRelationshipMapper.deleteSysRelationshipByIds(ids);
    }

    /**
     * 删除关系管理信息
     * 
     * @param id 关系管理主键
     * @return 结果
     */
    @Override
    public int deleteSysRelationshipById(Long id)
    {
        return sysRelationshipMapper.deleteSysRelationshipById(id);
    }
}
