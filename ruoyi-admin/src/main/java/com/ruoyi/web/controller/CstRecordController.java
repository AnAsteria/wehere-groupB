package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CstRecord;
import com.ruoyi.system.service.ICstRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 咨询管理Controller
 * 
 * @author Group9
 * @date 2022-03-21
 */
@RestController
@RequestMapping("/system/record")
public class CstRecordController extends BaseController
{
    @Autowired
    private ICstRecordService cstRecordService;

    /**
     * 查询咨询管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(CstRecord cstRecord)
    {
        startPage();
        List<CstRecord> list = cstRecordService.selectCstRecordList(cstRecord);
        return getDataTable(list);
    }

    /**
     * 导出咨询管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "咨询管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CstRecord cstRecord)
    {
        List<CstRecord> list = cstRecordService.selectCstRecordList(cstRecord);
        ExcelUtil<CstRecord> util = new ExcelUtil<CstRecord>(CstRecord.class);
        util.exportExcel(response, list, "咨询管理数据");
    }

    /**
     * 获取咨询管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cstRecordService.selectCstRecordById(id));
    }

    /**
     * 新增咨询管理
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "咨询管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CstRecord cstRecord)
    {
        return toAjax(cstRecordService.insertCstRecord(cstRecord));
    }

    /**
     * 修改咨询管理
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "咨询管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CstRecord cstRecord)
    {
        return toAjax(cstRecordService.updateCstRecord(cstRecord));
    }

    /**
     * 删除咨询管理
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "咨询管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cstRecordService.deleteCstRecordByIds(ids));
    }
}
