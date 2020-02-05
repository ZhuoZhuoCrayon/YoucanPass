package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.ImsSemesterParam;
import com.crayon.youcanpass.model.ImsSemester;
import com.crayon.youcanpass.service.ImsSemesterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Classname ImsSemesterController
 * @Description 学期信息管理控制层
 * @Date 2020/2/5 16:00
 * @Created by Crayon
 */
@Api(tags = "ImsSemesterController", description = "学期信息管理")
@RestController
@RequestMapping("/ims/semester")
@Validated
public class ImsSemesterController {
    @Autowired
    ImsSemesterService semesterService;

    @ApiOperation("获取指定id学期信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:semester:read')")
    public CommonResult<ImsSemester> get(
            @PathVariable("id")
            @NotNull(message = "查询学期id不能为空")
            @Min(value = 1, message = "查询id必须是正整数") Long id){
        return CommonResult.success(semesterService.get(id));
    }

    @ApiOperation("获取全部学期信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:semester:read')")
    public CommonResult<List<ImsSemester>> list(){
        return CommonResult.success(semesterService.list());
    }

    @ApiOperation("按年度范围获取学期信息")
    @RequestMapping(value = "/list/range", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:semester:read')")
    public CommonResult<List<ImsSemester>> listByTimeRange(
            @RequestParam(value = "begin")
            @NotNull(message = "起始年份不能为空")
            @Range(min = 1983, max = 2100, message = "起始年份须在有效值(1983-2100)") Integer begin,
            @RequestParam(value = "end")
            @NotNull(message = "终止年份不能为空")
            @Range(min = 1983, max = 2100, message = "终止年份须在有效值(1983-2100)") Integer end){
        CommonResult result;
        if((int) begin > (int) end){
            result = CommonResult.validateFailed("起始年份不得大于终止年份");
        }else {
            result = CommonResult.success(semesterService.listByTimeRange(begin, end));
        }
        return result;
    }

    @ApiOperation("添加学期信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ims:semester:insert')")
    public CommonResult insert(@RequestBody @Valid ImsSemesterParam semesterParam){
        CommonResult commonResult;
        int count = semesterService.insertByParam(semesterParam);
        if(count > 0){
            commonResult = CommonResult.success("新增学期信息成功");
        }else{
            commonResult = CommonResult.failed("新增学期信息失败");
        }
        return commonResult;
    }

    @ApiOperation("更新指定id学期信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ims:semester:update')")
    public CommonResult update(
            @PathVariable("id")
            @NotNull(message = "学期id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id,
            @RequestBody @Valid ImsSemesterParam semesterParam){
        CommonResult commonResult;
        int count = semesterService.updateByParam(id, semesterParam);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }

    @ApiOperation("删除指定id学期信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:semester:delete')")
    public CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "学期id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id) {
        CommonResult commonResult;
        int count = semesterService.delete(id);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }
}
