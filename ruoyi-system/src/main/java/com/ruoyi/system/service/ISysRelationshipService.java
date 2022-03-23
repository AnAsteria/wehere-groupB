package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysRelationship;

import java.util.List;

/**
 * 关系管理Service接口
 * 
 * @author Group9
 * @date 2022-03-23
 */
public interface ISysRelationshipService 
{
    /**
     * 查询关系管理
     * 
     * @param id 关系管理主键
     * @return 关系管理
     */
    public SysRelationship selectSysRelationshipById(Long id);

    /**
     * 查询关系管理列表
     * 
     * @param sysRelationship 关系管理
     * @return 关系管理集合
     */
    public List<SysRelationship> selectSysRelationshipList(SysRelationship sysRelationship);

    /**
     * 新增关系管理
     * 
     * @param sysRelationship 关系管理
     * @return 结果
     */
    public int insertSysRelationship(SysRelationship sysRelationship);

    /**
     * 修改关系管理
     * 
     * @param sysRelationship 关系管理
     * @return 结果
     */
    public int updateSysRelationship(SysRelationship sysRelationship);

    /**
     * 批量删除关系管理
     * 
     * @param ids 需要删除的关系管理主键集合
     * @return 结果
     */
    public int deleteSysRelationshipByIds(Long[] ids);

    /**
     * 删除关系管理信息
     * 
     * @param id 关系管理主键
     * @return 结果
     */
    public int deleteSysRelationshipById(Long id);
}
