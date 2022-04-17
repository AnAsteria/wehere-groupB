package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysEvaluation;

/**
 * 评价系统Mapper接口
 * 
 * @author Group9
 * @date 2022-04-16
 */
public interface SysEvaluationMapper 
{
    /**
     * 查询评价系统
     * 
     * @param id 评价系统主键
     * @return 评价系统
     */
    public SysEvaluation selectSysEvaluationById(Long id);

    /**
     * 查询评价系统列表
     * 
     * @param sysEvaluation 评价系统
     * @return 评价系统集合
     */
    public List<SysEvaluation> selectSysEvaluationList(SysEvaluation sysEvaluation);

    /**
     * 新增评价系统
     * 
     * @param sysEvaluation 评价系统
     * @return 结果
     */
    public int insertSysEvaluation(SysEvaluation sysEvaluation);

    /**
     * 修改评价系统
     * 
     * @param sysEvaluation 评价系统
     * @return 结果
     */
    public int updateSysEvaluation(SysEvaluation sysEvaluation);

    /**
     * 删除评价系统
     * 
     * @param id 评价系统主键
     * @return 结果
     */
    public int deleteSysEvaluationById(Long id);

    /**
     * 批量删除评价系统
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysEvaluationByIds(Long[] ids);
}
