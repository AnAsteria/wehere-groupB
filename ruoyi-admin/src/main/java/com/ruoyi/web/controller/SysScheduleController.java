package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CstRecord;
import com.ruoyi.system.domain.SysRelationship;
import com.ruoyi.system.domain.SysSchedule;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysRelationshipService;
import com.ruoyi.system.service.ISysScheduleService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Autowired
    private ISysRelationshipService sysRelationshipService;

    @Autowired
    private ISysUserService sysUserService;

    //获取排班表
    private List<SysSchedule> getSysScheduleList(SysSchedule sysSchedule){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long userId = loginUser.getUserId();
        Long deptId = loginUser.getDeptId();

        List<SysSchedule> list = null;

        if(deptId == 100L){
            list = sysScheduleService.selectSysScheduleList(sysSchedule);
        }
        else if(deptId == 101L){
            list = sysScheduleService.selectSysScheduleListByUserId(userId);
        }
        else if(deptId == 102L){
            list = new ArrayList<>();
            Stack<Long> stack = new Stack<>();
            stack.push(userId);
            while (!stack.isEmpty()){
                SysUser user = sysUserService.selectUserById(stack.pop());
                if(user.getDeptId() == 102L){
                    List<SysRelationship> sysRelationships = sysRelationshipService.selectSysRelationshipListBySupervisorId(userId);
                    for(SysRelationship relationship: sysRelationships){
                        stack.push(relationship.getConsultantId());
                    }
                }
                list.addAll(sysScheduleService.selectSysScheduleListByUserId(user.getUserId()));
            }
        }

        return list;
    }

    /**
     * 查询排班表管理列表
     */
    @ApiOperation("查询排班表管理列表")
    @PreAuthorize("@ss.hasPermi('system:schedule:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSchedule sysSchedule)
    {
        startPage();
        List<SysSchedule> list = getSysScheduleList(sysSchedule);
        return getDataTable(list);
    }

    /**
     * 导出排班表管理列表
     */
    @ApiOperation("导出排班表管理列表")
    @PreAuthorize("@ss.hasPermi('system:schedule:export')")
    @Log(title = "排班表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSchedule sysSchedule)
    {
        List<SysSchedule> list = getSysScheduleList(sysSchedule);
        ExcelUtil<SysSchedule> util = new ExcelUtil<SysSchedule>(SysSchedule.class);
        util.exportExcel(response, list, "排班表管理数据");
    }

    /**
     * 获取排班表管理详细信息
     */
    @ApiOperation("获取排班表管理详细信息")
    @PreAuthorize("@ss.hasPermi('system:schedule:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysScheduleService.selectSysScheduleById(id));
    }

    /**
     * 新增排班表管理
     */
    @ApiOperation("新增排班表管理")
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
    @ApiOperation("修改排班表管理")
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
    @ApiOperation("删除排班表管理")
    @PreAuthorize("@ss.hasPermi('system:schedule:remove')")
    @Log(title = "排班表管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysScheduleService.deleteSysScheduleByIds(ids));
    }
}
