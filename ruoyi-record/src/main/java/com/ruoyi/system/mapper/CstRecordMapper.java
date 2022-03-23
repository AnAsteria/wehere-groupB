package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.CstRecord;

/**
 * 咨询管理Mapper接口
 * 
 * @author Group9
 * @date 2022-03-21
 */
public interface CstRecordMapper 
{
    /**
     * 查询咨询管理
     * 
     * @param id 咨询管理主键
     * @return 咨询管理
     */
    public CstRecord selectCstRecordById(Long id);

    /**
     * 查询咨询管理列表
     * 
     * @param cstRecord 咨询管理
     * @return 咨询管理集合
     */
    public List<CstRecord> selectCstRecordList(CstRecord cstRecord);

    /**
     * 新增咨询管理
     * 
     * @param cstRecord 咨询管理
     * @return 结果
     */
    public int insertCstRecord(CstRecord cstRecord);

    /**
     * 修改咨询管理
     * 
     * @param cstRecord 咨询管理
     * @return 结果
     */
    public int updateCstRecord(CstRecord cstRecord);

    /**
     * 删除咨询管理
     * 
     * @param id 咨询管理主键
     * @return 结果
     */
    public int deleteCstRecordById(Long id);

    /**
     * 批量删除咨询管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCstRecordByIds(Long[] ids);
}
