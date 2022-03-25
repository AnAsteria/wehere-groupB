package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CstRecord;
import com.ruoyi.system.domain.SysRelationship;
import com.ruoyi.system.service.ICstRecordService;
import com.ruoyi.system.service.ISysRelationshipService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Autowired
    private ISysRelationshipService sysRelationshipService;

    @Autowired
    private ISysUserService sysUserService;

    private List<CstRecord> getCstRecordList(CstRecord cstRecord){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long userId = loginUser.getUserId();
        Long deptId = loginUser.getDeptId();
        List<CstRecord> list = null;
        if(deptId == 100L){
            list = cstRecordService.selectCstRecordList(cstRecord);
        }
        else if(deptId == 101L){
            list = cstRecordService.selectCstRecordListByUserId(userId);
        }
        else if(deptId == 102L){
            list = new ArrayList<CstRecord>();
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
                list.addAll(cstRecordService.selectCstRecordListByUserId(user.getUserId()));
            }
        }
        return list;
    }

    /**
     * 查询咨询管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    @ApiOperation("查询咨询管理列表")
    public TableDataInfo list(CstRecord cstRecord)
    {
        startPage();
        List<CstRecord> list = getCstRecordList(cstRecord);
        return getDataTable(list);
    }

    /**
     * 导出咨询管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "咨询管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出咨询管理列表")
    public void export(HttpServletResponse response, CstRecord cstRecord)
    {
        List<CstRecord> list = getCstRecordList(cstRecord);
        ExcelUtil<CstRecord> util = new ExcelUtil<CstRecord>(CstRecord.class);
        util.exportExcel(response, list, "咨询管理数据");
    }

    /**
     * 获取咨询管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取咨询管理详细信息")
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
    @ApiOperation("新增咨询管理")
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
    @ApiOperation("修改咨询管理")
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
    @ApiOperation("删除咨询管理")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cstRecordService.deleteCstRecordByIds(ids));
    }
}
