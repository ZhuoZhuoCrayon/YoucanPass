package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonPage;
import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.CmsOpenCourseForUserParam;
import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.service.CmsOpenCourseService;
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
import java.util.List;

/**
 * @Classname CmsOpenCourseController
 * @Description 开课信息管理控制层
 * @Date 2020/2/11 22:30
 * @Created by Crayon
 */
@Api(tags = "CmsOpenCourseController", description = "开课信息管理")
@RestController
@RequestMapping("/cms/opencourse")
@Validated
public class CmsOpenCourseController {

    @Autowired
    private CmsOpenCourseService openCourseService;

    @ApiOperation("分页获取开课信息概要信息列表")
    @RequestMapping(value = "/list/page/simple", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:opencourse:list:page:simple')")
    public CommonResult<CommonPage<CmsOpenCourseSimpleDto>>
    listOpenCourseSimpleByQuery(CmsOpenCourseQuery openCourseQuery,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<CmsOpenCourseSimpleDto>
                openCourseSimpleDtoList = openCourseService.listOpenCourseSimpleByQuery(openCourseQuery, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(openCourseSimpleDtoList));
    }

    @ApiOperation("新增开课信息：面向开课用户")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    //@PreAuthorize("hasAuthority('cms:opencourse:insert')")
    public CommonResult insertByLoginUser(@RequestBody @Valid CmsOpenCourseForUserParam openCourseForUserParam){
        int count = openCourseService.insertByLoginUser(openCourseForUserParam);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("新增开课信息失败");
        }
        return commonResult;
    }

    @ApiOperation("删除开课信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:opencourse:delete:id')")
    public CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "开课信息id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id){
        int count = openCourseService.delete(id);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("删除失败");
        }
        return commonResult;
    }
    @ApiOperation("批量删除开课信息")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:opencourse:delete:batch')")
    public CommonResult deleteBatch(@RequestParam @NotNull(message = "课程id列表不能为空") List<Long> ids){
        int count = openCourseService.deleteBatch(ids);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量删除失败");
        }
        return commonResult;
    }

    @ApiOperation("更新开课信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    //@PreAuthorize("hasAuthority('cms:opencourse:update:id')")
    public CommonResult update(
            @PathVariable("id")
            @NotNull(message = "开课信息id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id,
            @RequestBody @Valid CmsOpenCourseForUserParam openCourseForUserParam){
        int count = openCourseService.update(id, openCourseForUserParam);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新开课信息失败");
        }
        return commonResult;
    }

    @ApiOperation("批量更新开课信息状态")
    @RequestMapping(value = "/update/status/batch", method = RequestMethod.POST)
    //@PreAuthorize("hasAuthority('cms:opencourse:update:status:batch')")
    public CommonResult updateStatusBatch(
            @RequestParam @NotNull(message = "开课信息id列表不能为空") List<Long> ids,
            @RequestParam @NotNull(message = "开课状态不得为空")
            @Range(min = 0, max = 3, message = "审核状态:-1->未通过审核/0->待审核/1->审核通过（可选）/2->不可选/3->过期不可选") Integer status,
            @RequestParam String statusComment){
        int count = openCourseService.updateStatusBatch(ids, status, statusComment);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量更新开课状态失败");
        }
        return commonResult;
    }
}
