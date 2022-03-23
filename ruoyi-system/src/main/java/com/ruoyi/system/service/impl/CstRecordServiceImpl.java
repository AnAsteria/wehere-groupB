package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.CstRecord;
import com.ruoyi.system.mapper.CstRecordMapper;
import com.ruoyi.system.service.ICstRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 咨询管理Service业务层处理
 * 
 * @author Group9
 * @date 2022-03-21
 */
@Service
public class CstRecordServiceImpl implements ICstRecordService 
{
    @Autowired
    private CstRecordMapper cstRecordMapper;

    /**
     * 查询咨询管理
     * 
     * @param id 咨询管理主键
     * @return 咨询管理
     */
    @Override
    public CstRecord selectCstRecordById(Long id)
    {
        return cstRecordMapper.selectCstRecordById(id);
    }

    /**
     * 依据被咨询者的id查询咨询管理列表
     *
     * @param userId 咨询管理
     * @return 咨询管理集合
     */
    @Override
    public List<CstRecord> selectCstRecordListByUserId(Long userId) {
        return cstRecordMapper.selectCstRecordListByUserId(userId);
    }

    /**
     * 查询咨询管理列表
     * 
     * @param cstRecord 咨询管理
     * @return 咨询管理
     */
    @Override
    public List<CstRecord> selectCstRecordList(CstRecord cstRecord)
    {
        return cstRecordMapper.selectCstRecordList(cstRecord);
    }

    /**
     * 新增咨询管理
     * 
     * @param cstRecord 咨询管理
     * @return 结果
     */
    @Override
    public int insertCstRecord(CstRecord cstRecord)
    {
        cstRecord.setCreateTime(DateUtils.getNowDate());
        return cstRecordMapper.insertCstRecord(cstRecord);
    }

    /**
     * 修改咨询管理
     * 
     * @param cstRecord 咨询管理
     * @return 结果
     */
    @Override
    public int updateCstRecord(CstRecord cstRecord)
    {
        return cstRecordMapper.updateCstRecord(cstRecord);
    }

    /**
     * 批量删除咨询管理
     * 
     * @param ids 需要删除的咨询管理主键
     * @return 结果
     */
    @Override
    public int deleteCstRecordByIds(Long[] ids)
    {
        return cstRecordMapper.deleteCstRecordByIds(ids);
    }

    /**
     * 删除咨询管理信息
     * 
     * @param id 咨询管理主键
     * @return 结果
     */
    @Override
    public int deleteCstRecordById(Long id)
    {
        return cstRecordMapper.deleteCstRecordById(id);
    }
}
