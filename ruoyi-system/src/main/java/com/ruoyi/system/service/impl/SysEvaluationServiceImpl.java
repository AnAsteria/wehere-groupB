package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysEvaluationMapper;
import com.ruoyi.system.domain.SysEvaluation;
import com.ruoyi.system.service.ISysEvaluationService;

/**
 * 评价系统Service业务层处理
 * 
 * @author Group9
 * @date 2022-04-16
 */
@Service
public class SysEvaluationServiceImpl implements ISysEvaluationService 
{
    @Autowired
    private SysEvaluationMapper sysEvaluationMapper;

    /**
     * 查询评价系统
     * 
     * @param id 评价系统主键
     * @return 评价系统
     */
    @Override
    public SysEvaluation selectSysEvaluationById(Long id)
    {
        return sysEvaluationMapper.selectSysEvaluationById(id);
    }

    /**
     * 查询评价系统列表
     * 
     * @param sysEvaluation 评价系统
     * @return 评价系统
     */
    @Override
    public List<SysEvaluation> selectSysEvaluationList(SysEvaluation sysEvaluation)
    {
        return sysEvaluationMapper.selectSysEvaluationList(sysEvaluation);
    }

    /**
     * 新增评价系统
     * 
     * @param sysEvaluation 评价系统
     * @return 结果
     */
    @Override
    public int insertSysEvaluation(SysEvaluation sysEvaluation)
    {
        sysEvaluation.setCreateTime(DateUtils.getNowDate());
        return sysEvaluationMapper.insertSysEvaluation(sysEvaluation);
    }

    /**
     * 修改评价系统
     * 
     * @param sysEvaluation 评价系统
     * @return 结果
     */
    @Override
    public int updateSysEvaluation(SysEvaluation sysEvaluation)
    {
        return sysEvaluationMapper.updateSysEvaluation(sysEvaluation);
    }

    /**
     * 批量删除评价系统
     * 
     * @param ids 需要删除的评价系统主键
     * @return 结果
     */
    @Override
    public int deleteSysEvaluationByIds(Long[] ids)
    {
        return sysEvaluationMapper.deleteSysEvaluationByIds(ids);
    }

    /**
     * 删除评价系统信息
     * 
     * @param id 评价系统主键
     * @return 结果
     */
    @Override
    public int deleteSysEvaluationById(Long id)
    {
        return sysEvaluationMapper.deleteSysEvaluationById(id);
    }
}
