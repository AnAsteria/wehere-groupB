package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ImAccountMapper;
import com.ruoyi.system.domain.ImAccount;
import com.ruoyi.system.service.IImAccountService;

/**
 * IMAccount管理Service业务层处理
 * 
 * @author Group9
 * @date 2022-03-31
 */
@Service
public class ImAccountServiceImpl implements IImAccountService 
{
    @Autowired
    private ImAccountMapper imAccountMapper;

    /**
     * 查询IMAccount管理
     * 
     * @param id IMAccount管理主键
     * @return IMAccount管理
     */
    @Override
    public ImAccount selectImAccountById(Long id)
    {
        return imAccountMapper.selectImAccountById(id);
    }

    /**
     * 查询IMAccount管理列表
     * 
     * @param imAccount IMAccount管理
     * @return IMAccount管理
     */
    @Override
    public List<ImAccount> selectImAccountList(ImAccount imAccount)
    {
        return imAccountMapper.selectImAccountList(imAccount);
    }

    /**
     * 新增IMAccount管理
     * 
     * @param imAccount IMAccount管理
     * @return 结果
     */
    @Override
    public int insertImAccount(ImAccount imAccount)
    {
        return imAccountMapper.insertImAccount(imAccount);
    }

    /**
     * 修改IMAccount管理
     * 
     * @param imAccount IMAccount管理
     * @return 结果
     */
    @Override
    public int updateImAccount(ImAccount imAccount)
    {
        return imAccountMapper.updateImAccount(imAccount);
    }

    /**
     * 批量删除IMAccount管理
     * 
     * @param ids 需要删除的IMAccount管理主键
     * @return 结果
     */
    @Override
    public int deleteImAccountByIds(Long[] ids)
    {
        return imAccountMapper.deleteImAccountByIds(ids);
    }

    /**
     * 删除IMAccount管理信息
     * 
     * @param id IMAccount管理主键
     * @return 结果
     */
    @Override
    public int deleteImAccountById(Long id)
    {
        return imAccountMapper.deleteImAccountById(id);
    }
}
