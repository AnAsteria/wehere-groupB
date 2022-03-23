package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysRelationship;

import java.util.List;

/**
 * 关系管理Mapper接口
 * 
 * @author Group9
 * @date 2022-03-23
 */
public interface SysRelationshipMapper 
{
    /**
     * 查询关系管理
     * 
     * @param id 关系管理主键
     * @return 关系管理
     */
    public SysRelationship selectSysRelationshipById(Long id);

    /**
     * 依据督导id查询关系管理列表
     *
     * @param supervisorId 关系管理
     * @return 关系管理
     */
    public List<SysRelationship> selectSysRelationshipListBySupervisorId(Long supervisorId);

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
     * 删除关系管理
     * 
     * @param id 关系管理主键
     * @return 结果
     */
    public int deleteSysRelationshipById(Long id);

    /**
     * 批量删除关系管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRelationshipByIds(Long[] ids);
}
