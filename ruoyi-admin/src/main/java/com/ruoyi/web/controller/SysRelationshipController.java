package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysRelationship;
import com.ruoyi.system.service.ISysRelationshipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 关系管理Controller
 * 
 * @author Group9
 * @date 2022-03-23
 */
@RestController
@RequestMapping("/system/relationship")
public class SysRelationshipController extends BaseController
{
    @Autowired
    private ISysRelationshipService sysRelationshipService;

    /**
     * 查询关系管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:relationship:list')")
    @GetMapping("/list")
    @ApiOperation("查询关系管理列表")
    public TableDataInfo list(SysRelationship sysRelationship)
    {
        startPage();
        List<SysRelationship> list = sysRelationshipService.selectSysRelationshipList(sysRelationship);
        return getDataTable(list);
    }

    /**
     * 依据咨询师id查询关系列表
     */
    @ApiOperation("依据咨询师id查询关系列表")
    @PreAuthorize("@ss.hasPermi('system:relationship:select_cid_by_sid')")
    @GetMapping("/select_by_cid/{sid}")
    public AjaxResult selectDataBySid(@PathVariable("sid") Long id){
        return AjaxResult.success(sysRelationshipService.selectSysRelationshipListByConsultantId(id));
    }

    /**
     * 依据督导id查询关系列表
     */
    @ApiOperation("依据督导id查询关系列表")
    @PreAuthorize("@ss.hasPermi('system:relationship:select_sid_by_cid')")
    @GetMapping("/select_by_sid/{cid}")
    public AjaxResult selectDataByCid(@PathVariable("cid") Long id){
        return AjaxResult.success(sysRelationshipService.selectSysRelationshipListBySupervisorId(id));
    }

    /**
     * 导出关系管理列表
     */
    @ApiOperation("导出关系管理列表")
    @PreAuthorize("@ss.hasPermi('system:relationship:export')")
    @Log(title = "关系管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRelationship sysRelationship)
    {
        List<SysRelationship> list = sysRelationshipService.selectSysRelationshipList(sysRelationship);
        ExcelUtil<SysRelationship> util = new ExcelUtil<SysRelationship>(SysRelationship.class);
        util.exportExcel(response, list, "关系管理数据");
    }

    /**
     * 获取关系管理详细信息
     */
    @ApiOperation("获取关系管理详细信息")
    @PreAuthorize("@ss.hasPermi('system:relationship:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRelationshipService.selectSysRelationshipById(id));
    }

    /**
     * 新增关系管理
     */
    @ApiOperation("新增关系管理")
    @PreAuthorize("@ss.hasPermi('system:relationship:add')")
    @Log(title = "关系管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRelationship sysRelationship)
    {
        return toAjax(sysRelationshipService.insertSysRelationship(sysRelationship));
    }

    /**
     * 修改关系管理
     */
    @ApiOperation("修改关系管理")
    @PreAuthorize("@ss.hasPermi('system:relationship:edit')")
    @Log(title = "关系管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRelationship sysRelationship)
    {
        return toAjax(sysRelationshipService.updateSysRelationship(sysRelationship));
    }

    /**
     * 删除关系管理
     */
    @ApiOperation("删除关系管理")
    @PreAuthorize("@ss.hasPermi('system:relationship:remove')")
    @Log(title = "关系管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRelationshipService.deleteSysRelationshipByIds(ids));
    }
}
