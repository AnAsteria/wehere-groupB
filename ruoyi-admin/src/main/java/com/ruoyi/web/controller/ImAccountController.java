package com.ruoyi.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ImAccount;
import com.ruoyi.system.service.IImAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * IMAccount管理Controller
 * 
 * @author Group9
 * @date 2022-03-31
 */
@RestController
@RequestMapping("/system/IMAccount")
public class ImAccountController extends BaseController
{
    @Autowired
    private IImAccountService imAccountService;

    /**
     * 查询IMAccount管理列表
     */
    @ApiOperation("查询IMAccount管理列表")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImAccount imAccount)
    {
        startPage();
        List<ImAccount> list = imAccountService.selectImAccountList(imAccount);
        return getDataTable(list);
    }

    /**
     * 导出IMAccount管理列表
     */
    @ApiOperation("导出IMAccount管理列表")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:export')")
    @Log(title = "IMAccount管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImAccount imAccount)
    {
        List<ImAccount> list = imAccountService.selectImAccountList(imAccount);
        ExcelUtil<ImAccount> util = new ExcelUtil<ImAccount>(ImAccount.class);
        util.exportExcel(response, list, "IMAccount管理数据");
    }

    /**
     * 获取IMAccount管理详细信息
     */
    @ApiOperation("获取IMAccount管理详细信息")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(imAccountService.selectImAccountById(id));
    }

    /**
     * 新增IMAccount管理
     */
    @ApiOperation("新增IMAccount管理")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:add')")
    @Log(title = "IMAccount管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImAccount imAccount)
    {
        return toAjax(imAccountService.insertImAccount(imAccount));
    }

    /**
     * 修改IMAccount管理
     */
    @ApiOperation("修改IMAccount管理")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:edit')")
    @Log(title = "IMAccount管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImAccount imAccount)
    {
        return toAjax(imAccountService.updateImAccount(imAccount));
    }

    /**
     * 删除IMAccount管理
     */
    @ApiOperation("删除IMAccount管理")
    @PreAuthorize("@ss.hasPermi('system:IMAccount:remove')")
    @Log(title = "IMAccount管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imAccountService.deleteImAccountByIds(ids));
    }
}
