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
import com.ruoyi.system.domain.SysEvaluation;
import com.ruoyi.system.service.ISysEvaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价系统Controller
 * 
 * @author Group9
 * @date 2022-04-15
 */
@RestController
@RequestMapping("/system/evaluation")
public class SysEvaluationController extends BaseController
{
    @Autowired
    private ISysEvaluationService sysEvaluationService;

    /**
     * 查询评价系统列表
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysEvaluation sysEvaluation)
    {
        startPage();
        List<SysEvaluation> list = sysEvaluationService.selectSysEvaluationList(sysEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出评价系统列表
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:export')")
    @Log(title = "评价系统", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysEvaluation sysEvaluation)
    {
        List<SysEvaluation> list = sysEvaluationService.selectSysEvaluationList(sysEvaluation);
        ExcelUtil<SysEvaluation> util = new ExcelUtil<SysEvaluation>(SysEvaluation.class);
        util.exportExcel(response, list, "评价系统数据");
    }

    /**
     * 获取评价系统详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysEvaluationService.selectSysEvaluationById(id));
    }

    /**
     * 新增评价系统
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:add')")
    @Log(title = "评价系统", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysEvaluation sysEvaluation)
    {
        return toAjax(sysEvaluationService.insertSysEvaluation(sysEvaluation));
    }

    /**
     * 修改评价系统
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:edit')")
    @Log(title = "评价系统", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysEvaluation sysEvaluation)
    {
        return toAjax(sysEvaluationService.updateSysEvaluation(sysEvaluation));
    }

    /**
     * 删除评价系统
     */
    @PreAuthorize("@ss.hasPermi('system:evaluation:remove')")
    @Log(title = "评价系统", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysEvaluationService.deleteSysEvaluationByIds(ids));
    }
}
