package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.SmsMessageDto;
import com.crayon.youcanpass.model.SmsMessage;
import com.crayon.youcanpass.service.SmsMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname SmsMessageController
 * @Description 通知管理控制层
 * @Date 2020/3/29 20:48
 * @Created by Crayon
 */
@Api(tags = "SmsMessageController", description = "通知管理")
@RestController
@RequestMapping("/sms/message")
@Validated
public class SmsMessageController {
    @Autowired
    private SmsMessageService messageService;

    @ApiOperation("获取指定id通知")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('sms:message:id')")
    public CommonResult<SmsMessageDto> get(
            @PathVariable("id")
            @NotNull(message = "查询通知id不能为空")
            @Min(value = 1, message = "查询id必须是正整数") Long id){
        return CommonResult.success(messageService.getById(id));
    }

    @ApiOperation("获取全部通知")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('sms:message:list')")
    public CommonResult<List<SmsMessageDto>> list(){
        return CommonResult.success(messageService.listAll());
    }

    @ApiOperation("删除通知")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('sms:message:delete:id')")
    public CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "通知id不能为空")
            @Min(value = 1, message = "通知id必须是正整数") Long id){
        CommonResult commonResult;
        int count = messageService.delete(id);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("删除失败");
        }
        return commonResult;
    }

    @ApiOperation("新增通知")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sms:message:insert')")
    public CommonResult insert(@RequestBody SmsMessage message){
        CommonResult commonResult;
        int count = messageService.insert(message);
        if(count > 0){
            commonResult = CommonResult.success(message.getId());
        }else{
            commonResult = CommonResult.failed("新增通知失败");
        }
        return commonResult;
    }

    @ApiOperation("修改通知")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('sms:message:update:id')")
    public CommonResult update(
            @PathVariable("id")
            @NotNull(message = "通知id不能为空")
            @Min(value = 1, message = "通知id必须是正整数") Long id,
            @RequestBody SmsMessage smsMessage){
        CommonResult commonResult;
        int count = messageService.update(id, smsMessage);
        if(count > 0){
            commonResult = CommonResult.success(id);
        }else{
            commonResult = CommonResult.failed("更改通知失败");
        }
        return commonResult;
    }
}
