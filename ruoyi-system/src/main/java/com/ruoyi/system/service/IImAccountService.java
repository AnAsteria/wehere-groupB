package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ImAccount;

/**
 * IMAccount管理Service接口
 * 
 * @author Group9
 * @date 2022-03-31
 */
public interface IImAccountService 
{
    /**
     * 查询IMAccount管理
     * 
     * @param id IMAccount管理主键
     * @return IMAccount管理
     */
    public ImAccount selectImAccountById(Long id);

    /**
     * 查询IMAccount管理列表
     * 
     * @param imAccount IMAccount管理
     * @return IMAccount管理集合
     */
    public List<ImAccount> selectImAccountList(ImAccount imAccount);

    /**
     * 新增IMAccount管理
     * 
     * @param imAccount IMAccount管理
     * @return 结果
     */
    public int insertImAccount(ImAccount imAccount);

    /**
     * 修改IMAccount管理
     * 
     * @param imAccount IMAccount管理
     * @return 结果
     */
    public int updateImAccount(ImAccount imAccount);

    /**
     * 批量删除IMAccount管理
     * 
     * @param ids 需要删除的IMAccount管理主键集合
     * @return 结果
     */
    public int deleteImAccountByIds(Long[] ids);

    /**
     * 删除IMAccount管理信息
     * 
     * @param id IMAccount管理主键
     * @return 结果
     */
    public int deleteImAccountById(Long id);
}
