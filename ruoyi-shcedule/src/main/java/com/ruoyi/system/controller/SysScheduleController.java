package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.SysSchedule;
import com.ruoyi.system.service.ISysScheduleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排班表管理Controller
 * 
 * @author Group9
 * @date 2022-03-21
 */
@RestController
@RequestMapping("/system/schedule")
public class SysScheduleController extends BaseController
{
    @Autowired
    private ISysScheduleService sysScheduleService;

    /**
     * 查询排班表管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSchedule sysSchedule)
    {
        startPage();
        List<SysSchedule> list = sysScheduleService.selectSysScheduleList(sysSchedule);
        return getDataTable(list);
    }

    /**
     * 导出排班表管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:export')")
    @Log(title = "排班表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSchedule sysSchedule)
    {
        List<SysSchedule> list = sysScheduleService.selectSysScheduleList(sysSchedule);
        ExcelUtil<SysSchedule> util = new ExcelUtil<SysSchedule>(SysSchedule.class);
        util.exportExcel(response, list, "排班表管理数据");
    }

    /**
     * 获取排班表管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysScheduleService.selectSysScheduleById(id));
    }

    /**
     * 新增排班表管理
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:add')")
    @Log(title = "排班表管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSchedule sysSchedule)
    {
        return toAjax(sysScheduleService.insertSysSchedule(sysSchedule));
    }

    /**
     * 修改排班表管理
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:edit')")
    @Log(title = "排班表管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSchedule sysSchedule)
    {
        return toAjax(sysScheduleService.updateSysSchedule(sysSchedule));
    }

    /**
     * 删除排班表管理
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:remove')")
    @Log(title = "排班表管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysScheduleService.deleteSysScheduleByIds(ids));
    }
}
