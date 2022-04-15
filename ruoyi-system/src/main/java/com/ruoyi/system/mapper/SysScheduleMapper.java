package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysSchedule;

import java.util.List;

/**
 * 排班表管理Mapper接口
 * 
 * @author Group9
 * @date 2022-03-21
 */
public interface SysScheduleMapper
{
    /**
     * 依据日期查询排班人员
     *
     * @param sysSchedule
     * @return 排班表
     */
    public List<SysSchedule> selectSysScheduleByDate(SysSchedule sysSchedule);

    /**
     * 查询排班表管理
     * 
     * @param id 排班表管理主键
     * @return 排班表管理
     */
    public SysSchedule selectSysScheduleById(Long id);

    /**
     * 依据用户id查询排班表管理
     *
     * @param userId 排班表管理主键
     * @return 排班表管理
     */
    public List<SysSchedule> selectSysScheduleListByUserId(Long userId);

    /**
     * 查询排班表管理列表
     * 
     * @param sysSchedule 排班表管理
     * @return 排班表管理集合
     */
    public List<SysSchedule> selectSysScheduleList(SysSchedule sysSchedule);

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
