package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonPage;
import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.model.CmsCourse;
import com.crayon.youcanpass.service.CmsCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname CmsCourseController
 * @Description 课程管理控制层
 * @Date 2020/2/5 21:07
 * @Created by Crayon
 */

@Api(tags = "CmsCourseController", description = "课程信息管理")
@RestController
@RequestMapping("/cms/course")
public class CmsCourseController {
    @Autowired
    private CmsCourseService courseService;

    @ApiOperation("获取指定id课程信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('cms:course:read')")
    public CommonResult<CmsCourse> get(
            @PathVariable("id")
            @NotNull(message = "查询课程id不能为空")
            @Min(value = 1, message = "查询id必须是正整数") Long id){
        return CommonResult.success(courseService.get(id));
    }

    @ApiOperation("分页查询课程信息")
    @RequestMapping(value = "/list/page", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('cms:course:read')")
    public CommonResult<CommonPage<CmsCourse>> listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<CmsCourse> courseList = courseService.listByPage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(courseList));
    }

    @ApiOperation("获取所有课程信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('cms:course:read')")
    public CommonResult<List<CmsCourse>> list(){
        return CommonResult.success(courseService.list());
    }

    @ApiOperation("添加课程信息")
    @PreAuthorize("hasAuthority('cms:course:insert')")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public CommonResult insert(@RequestBody @Valid CmsCourse course){
        CommonResult commonResult;
        int count = courseService.insert(course);
        if(count > 0){
            commonResult = CommonResult.success(course.getId());
        }else{
            commonResult = CommonResult.failed("创建失败");
        }
        return commonResult;
    }

    @ApiOperation("更新指定id课程信息")
    @PreAuthorize("hasAuthority('cms:course:update')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(
            @PathVariable("id")
            @NotNull(message = "课程id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id,
            @RequestBody @Valid CmsCourse course){
        CommonResult commonResult;
        int count = courseService.update(id, course);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }

    @ApiOperation("删除指定id课程信息")
    @PreAuthorize("hasAuthority('cms:course:delete')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "课程id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id){
        CommonResult commonResult;
        int count = courseService.delete(id);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("删除失败");
        }
        return commonResult;
    }

    @ApiOperation("批量更新课程启用状态")
    @PreAuthorize("hasAuthority('cms:course:update')")
    @RequestMapping(value = "/update/status/batch", method = RequestMethod.POST)
    public CommonResult updateStatusBatch(
            @RequestParam @NotNull(message = "课程id列表不能为空") List<Long> ids,
            @RequestParam @NotNull(message = "启用状态不得为空")
            @Range(min = 0, max = 1, message = "启用状态:0->禁用/1->启用") Integer status){
        CommonResult commonResult;
        int count = courseService.updateStatusBatch(ids, status);
        if(count > 0) {
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量更新课程启用状态失败");
        }
        return commonResult;
    }

    @ApiOperation("批量更新课程学期信息")
    @PreAuthorize("hasAuthority('cms:course:update')")
    @RequestMapping(value = "/update/term/batch", method = RequestMethod.POST)
    public CommonResult updateTermBatch(
            @RequestParam @NotNull(message = "课程id列表不能为空") List<Long> ids,
            @NotNull(message = "开课学期不得为空")
            @Range(min = 1, max = 3, message = "开课学期:1->第一学期/2->第二学期/3->全年开设") Integer term){
        CommonResult commonResult;
        int count = courseService.updateTermBatch(ids, term);
        if(count > 0) {
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量更新课程学期信息失败");
        }
        return commonResult;
    }

    @ApiOperation("批量更新课程类型")
    @PreAuthorize("hasAuthority('cms:course:update')")
    @RequestMapping(value = "/update/type/batch", method = RequestMethod.POST)
    public CommonResult updateTypeBatch(
            @RequestParam @NotNull(message = "课程id列表不能为空") List<Long> ids,
            @NotNull(message = "课程类型不得为空")
            @Range(min = 0, max = 3, message = "课程类型:0->专业核心课/1->专业选修课/2-其他") Integer type){
        CommonResult commonResult;
        int count = courseService.updateStatusBatch(ids, type);
        if(count > 0) {
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量更新课程类型失败");
        }
        return commonResult;
    }
}
