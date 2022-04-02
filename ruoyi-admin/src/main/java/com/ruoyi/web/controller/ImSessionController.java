package com.ruoyi.web.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.CstRecord;
import com.ruoyi.system.service.ICstRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IMSessionController
 *
 * @author Group9
 * @date 2022-03-31
 */
@RestController
@RequestMapping("/system/IMASession")
public class ImSessionController {

    @Autowired
    ICstRecordService cstRecordService;

    /**
     * 发起会话请求并保存会话记录至数据库
     */
    @ApiOperation("发起会话请求并保存会话记录至数据库")
    @PreAuthorize("@ss.hasPermi('system:IMSession:begin')")
    @GetMapping("/begin/{to_id}")
    public void beginSession(@PathVariable("to_id") Long toId){
        Long fromId = SecurityUtils.getLoginUser().getUserId();
        CstRecord cstRecord = new CstRecord();
        cstRecord.setFromId(fromId);
        cstRecord.setToId(toId);
        cstRecordService.insertCstRecord(cstRecord);
    }
}
