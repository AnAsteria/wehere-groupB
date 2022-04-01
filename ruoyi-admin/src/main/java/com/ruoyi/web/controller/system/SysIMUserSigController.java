package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.client.TIMClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysIMUserSigController {
    /**
     * 获取 TIM User Sig
     *
     * @param userId 登录信息
     * @return 结果
     */
    @ApiOperation("获取用户在TIM系统的用户签名")
    @GetMapping("/im/usersig/{userId}")
    public AjaxResult getUserSig(@PathVariable String userId)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String userSig = TIMClient.getUserSig(userId);
        ajax.put("im-user-sig", userSig);
        return ajax;
    }
}
