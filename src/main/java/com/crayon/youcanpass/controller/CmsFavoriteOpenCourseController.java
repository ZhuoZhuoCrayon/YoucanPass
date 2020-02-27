package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dto.CmsFavoriteOpenCourseDto;
import com.crayon.youcanpass.model.CmsFavoriteOpencourse;
import com.crayon.youcanpass.model.UmsUser;
import com.crayon.youcanpass.service.CmsFavoriteOpenCourseService;
import com.crayon.youcanpass.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname CmsFavoriteOpenCourseController
 * @Description 开课收藏模块控制层
 * @Date 2020/2/27 16:51
 * @Created by Crayon
 */
@Api(tags = "CmsFavoriteOpenCourseController", description = "课程收藏管理")
@RestController
@RequestMapping("/cms/favorite-opencourse")
@Validated
public class CmsFavoriteOpenCourseController {
    @Autowired
    private CmsFavoriteOpenCourseService favoriteOpenCourseService;
    @Autowired
    private UmsUserService umsUserService;

    @ApiOperation("获取收藏夹：用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:favorite-opencourse:list')")
    public CommonResult<List<CmsFavoriteOpenCourseDto>> list(
            @Min(value = 1, message = "id必须是正整数") @RequestParam Long semesterId){
        UmsUser user = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName());
        List<CmsFavoriteOpenCourseDto> favoriteOpenCourseDtoList = favoriteOpenCourseService.list(user.getId(), semesterId);
        return CommonResult.success(favoriteOpenCourseDtoList);
    }

    @ApiOperation("添加课程到收藏")
    @RequestMapping(value = "/insert/{opencourseId}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:favorite-opencourse:insert:opencourseId')")
    public CommonResult insert(
            @PathVariable("opencourseId")
            @NotNull(message = "开课id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long opencourseId,
            @NotNull(message = "学期id不能为空")
            @Min(value = 1, message = "id不合法") @RequestParam Long semesterId,
            @RequestParam String note){
        CmsFavoriteOpencourse favoriteOpencourse = new CmsFavoriteOpencourse();
        UmsUser user = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName());
        favoriteOpencourse.setNote(note);
        favoriteOpencourse.setSemesterId(semesterId);
        favoriteOpencourse.setOpencourseId(opencourseId);
        favoriteOpencourse.setUserId(user.getId());
        return CommonResult.success(favoriteOpenCourseService.insert(favoriteOpencourse));
    }

    @ApiOperation("取消收藏")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:favorite-opencourse:delete:id')")
    public  CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "收藏课程id不能为空")
            @Min(value = 1, message = "id不合法") Long id){
        UmsUser user = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName());
        return CommonResult.success(favoriteOpenCourseService.delete(user.getId(), id));
    }

    @ApiOperation("更新收藏")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    //@PreAuthorize("hasAuthority('cms:favorite-opencourse:update:id')")
    public CommonResult update(
            @PathVariable("id")
            @NotNull(message = "收藏课程id不能为空")
            @Min(value = 1, message = "id不合法") Long id,
            @NotNull(message = "学期id不能为空")
            @Min(value = 1, message = "id不合法") @RequestParam Long semester_id,
            @RequestParam String note){
        UmsUser user = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName());
        CmsFavoriteOpencourse favoriteOpencourse = new CmsFavoriteOpencourse();
        favoriteOpencourse.setUserId(user.getId());
        favoriteOpencourse.setSemesterId(semester_id);
        favoriteOpencourse.setNote(note);
        return CommonResult.success(favoriteOpenCourseService.update(id, favoriteOpencourse));
    }

}
