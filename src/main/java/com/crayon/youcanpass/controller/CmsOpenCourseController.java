package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonPage;
import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.CmsOpenCourseForUserParam;
import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsOpenCourseSimpleDto;
import com.crayon.youcanpass.service.CmsOpenCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @RequestMapping(value = "/list/simple", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:opencourse:list:simple')")
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
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }

}
