package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SuSysSchedule;
import com.ruoyi.system.domain.SysSchedule;
import com.ruoyi.system.mapper.SysScheduleMapper;
import com.ruoyi.system.service.ISysScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排班表管理Service业务层处理
 *
 * @author Group9
 * @date 2022-03-21
 */
@Service
public class SysScheduleServiceImpl implements ISysScheduleService
{
    @Autowired
    private SysScheduleMapper sysScheduleMapper;

    /**
     * 查询排班表管理
     *
     * @param id 排班表管理主键
     * @return 排班表管理
     */
    @Override
    public SysSchedule selectSysScheduleById(Long id)
    {
        return sysScheduleMapper.selectSysScheduleById(id);
    }

    /**
     * 最高权限查询排班表管理列表
     *
     * @param sysSchedule 排班表管理
     * @return 排班表管理
     */
    @Override
    public List<SuSysSchedule> suSelectSysScheduleList(SuSysSchedule sysSchedule)
    {
        return sysScheduleMapper.suSelectSysScheduleList(sysSchedule);
    }


    /**
     * 查询排班表管理列表
     *
     * @param sysSchedule 排班表管理
     * @return 排班表管理
     */
    @Override
    public List<SysSchedule> selectSysScheduleList(SysSchedule sysSchedule)
    {
        return sysScheduleMapper.selectSysScheduleList(sysSchedule);
    }

    /**
     * 新增排班表管理
     *
     * @param sysSchedule 排班表管理
     * @return 结果
     */
    @Override
    public int insertSysSchedule(SysSchedule sysSchedule)
    {
        sysSchedule.setCreateTime(DateUtils.getNowDate());
        return sysScheduleMapper.insertSysSchedule(sysSchedule);
    }

    /**
     * 修改排班表管理
     *
     * @param sysSchedule 排班表管理
     * @return 结果
     */
    @Override
    public int updateSysSchedule(SysSchedule sysSchedule)
    {
        return sysScheduleMapper.updateSysSchedule(sysSchedule);
    }

    /**
     * 批量删除排班表管理
     *
     * @param ids 需要删除的排班表管理主键
     * @return 结果
     */
    @Override
    public int deleteSysScheduleByIds(Long[] ids)
    {
        return sysScheduleMapper.deleteSysScheduleByIds(ids);
    }

    /**
     * 删除排班表管理信息
     *
     * @param id 排班表管理主键
     * @return 结果
     */
    @Override
    public int deleteSysScheduleById(Long id)
    {
        return sysScheduleMapper.deleteSysScheduleById(id);
    }
}