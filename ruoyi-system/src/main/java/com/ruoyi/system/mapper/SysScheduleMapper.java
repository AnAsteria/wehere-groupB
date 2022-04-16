package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SuSysSchedule;
import com.ruoyi.system.domain.SysSchedule;

/**
 * 排班表管理Mapper接口
 * 
 * @author Group9
 * @date 2022-04-16
 */
public interface SysScheduleMapper 
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
     * @return 排班表管理
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
     * 删除排班表管理
     * 
     * @param id 排班表管理主键
     * @return 结果
     */
    public int deleteSysScheduleById(Long id);

    /**
     * 批量删除排班表管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysScheduleByIds(Long[] ids);
}
