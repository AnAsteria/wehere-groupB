package com.ruoyi.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.client.TIMClient;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Visitor;
import com.ruoyi.system.service.IVisitorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 访客用户信息Controller
 * 
 * @author Group9
 * @date 2022-04-06
 */
@RestController
@RequestMapping("/system/visitor")
public class VisitorController extends BaseController
{
    @Autowired
    private IVisitorService visitorService;

    /**
     * 查询访客用户信息列表
     */
    @ApiOperation("查询访客用户信息列表")
//    @PreAuthorize("@ss.hasPermi('system:visitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(Visitor visitor)
    {
        startPage();
        List<Visitor> list = visitorService.selectVisitorList(visitor);
        return getDataTable(list);
    }

    /**
     * 导出访客用户信息列表
     */
    @ApiOperation("导出访客用户信息列表")
    @PreAuthorize("@ss.hasPermi('system:visitor:export')")
    @Log(title = "访客用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Visitor visitor)
    {
        List<Visitor> list = visitorService.selectVisitorList(visitor);
        ExcelUtil<Visitor> util = new ExcelUtil<Visitor>(Visitor.class);
        util.exportExcel(response, list, "访客用户信息数据");
    }

    /**
     * 获取访客用户信息详细信息
     */
    @ApiOperation("获取访客用户信息详细信息")
    @PreAuthorize("@ss.hasPermi('system:visitor:query')")
    @GetMapping(value = "/{visitorId}")
    public AjaxResult getInfo(@PathVariable("visitorId") String visitorId)
    {
        return AjaxResult.success(visitorService.selectVisitorByVisitorId(visitorId));
    }

    /**
     * 新增访客用户信息
     */
    @ApiOperation("新增访客用户信息")
//    @PreAuthorize("@ss.hasPermi('system:visitor:add')")
//    @Log(title = "访客用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Visitor visitor)
    {
        JSONObject params = new JSONObject();
        params.put("UserID",visitor.getVisitorId());
        ResponseEntity<JSONObject> result = TIMClient.sendRequest("im_open_login_svc", "account_import", null, params, JSONObject.class);
//        System.out.println("result = " + result);
        return toAjax(visitorService.insertVisitor(visitor));
    }

    /**
     * 修改访客用户信息
     */
    @ApiOperation("修改访客用户信息")
//    @PreAuthorize("@ss.hasPermi('system:visitor:edit')")
//    @Log(title = "访客用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Visitor visitor)
    {
        return toAjax(visitorService.updateVisitor(visitor));
    }

    /**
     * 删除访客用户信息
     */
    @ApiOperation("删除访客用户信息")
    @PreAuthorize("@ss.hasPermi('system:visitor:remove')")
    @Log(title = "访客用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{visitorIds}")
    public AjaxResult remove(@PathVariable String[] visitorIds)
    {
        return toAjax(visitorService.deleteVisitorByVisitorIds(visitorIds));
    }
}
