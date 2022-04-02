package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ImAccount;

/**
 * IMAccount管理Mapper接口
 * 
 * @author Group9
 * @date 2022-03-31
 */
public interface ImAccountMapper 
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
     * 删除IMAccount管理
     * 
     * @param id IMAccount管理主键
     * @return 结果
     */
    public int deleteImAccountById(Long id);

    /**
     * 批量删除IMAccount管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImAccountByIds(Long[] ids);
}
