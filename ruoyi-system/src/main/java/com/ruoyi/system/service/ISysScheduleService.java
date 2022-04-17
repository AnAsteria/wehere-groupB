package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SuSysSchedule;
import com.ruoyi.system.domain.SysSchedule;

/**
 * 排班表管理Service接口
 * 
 * @author Group9
 * @date 2022-04-16
 */
public interface ISysScheduleService 
{
    /**
     * 查询排班表管理
     * 
     * @param id 排班表管理主键
     * @return 排班表管理
     */
    public SysSchedule selectSysScheduleById(Long id);

    /**
     * 查询排班表管理列表
     * 
     * @param sysSchedule 排班表管理
     * @return 排班表管理集合
     */
    public List<SysSchedule> selectSysScheduleList(SysSchedule sysSchedule);

    /**
     * 最高权限查询排班表管理列表
     *
     * @param sysSchedule 排班表管理
     * @return 排班表管理集合
     */
    public List<SuSysSchedule> suSelectSysScheduleList(SuSysSchedule sysSchedule);

    /**
     * 新增排班表管理
     * 
     * @param sysSchedule 排班表管理
     * @return 结果
     */
    public int insertSysSchedule(SysSchedule sysSchedule);

    /**
     * 修改排班表管理
     * 
     * @param sysSchedule 排班表管理
     * @return 结果
     */
    public int updateSysSchedule(SysSchedule sysSchedule);

    /**
     * 批量删除排班表管理
     * 
     * @param ids 需要删除的排班表管理主键集合
     * @return 结果
     */
    public int deleteSysScheduleByIds(Long[] ids);

    /**
     * 删除排班表管理信息
     * 
     * @param id 排班表管理主键
     * @return 结果
     */
    public int deleteSysScheduleById(Long id);
}
