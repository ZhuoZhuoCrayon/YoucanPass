package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonPage;
import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.common.constant.CmsUserOpenCourseRelationConstant;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dto.CmsOpenCourseQuery;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationDto;
import com.crayon.youcanpass.dto.CmsUserOpenCourseRelationQuery;
import com.crayon.youcanpass.model.CmsOpencourse;
import com.crayon.youcanpass.model.CmsUserOpencourseRelation;
import com.crayon.youcanpass.service.CmsOpenCourseService;
import com.crayon.youcanpass.service.CmsUserOpenCourseRelationService;
import com.crayon.youcanpass.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname CmsUserOpenCourseRelationController
 * @Description 选课关系控制层
 * @Date 2020/2/16 18:02
 * @Created by Crayon
 */
@Api(tags = "CmsUserOpenCourseRelationController", description = "选课信息管理")
@RestController
@RequestMapping("/cms/user-opencourse-relation")
@Validated
public class CmsUserOpenCourseRelationController {
    @Autowired
    private CmsUserOpenCourseRelationService userOpenCourseRelationService;
    @Autowired
    private CmsOpenCourseService openCourseService;
    @Autowired
    private UmsUserService umsUserService;

    @ApiOperation("分页获取选课信息")
    @RequestMapping(value = "/list/page/simple", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:page:list:simple')")
    public CommonResult<CommonPage<CmsUserOpenCourseRelationDto>> listByPageQuery(
            CmsUserOpenCourseRelationQuery userOpenCourseRelationQuery,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<CmsUserOpenCourseRelationDto> userOpenCourseRelationDtoList =
                userOpenCourseRelationService.listByPageQuery(userOpenCourseRelationQuery, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(userOpenCourseRelationDtoList));
    }

    @ApiOperation("学生选课")
    @RequestMapping(value = "/select/{opencourseId}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:select:opencourseId')")
    public CommonResult select(
            @PathVariable("opencourseId")
            @NotNull(message = "开课id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long opencourseId){
        int count = userOpenCourseRelationService.select(opencourseId);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("选课失败");
        }
        return commonResult;
    }

    @ApiOperation("学生退课")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:delete:id')")
    public CommonResult delete(
            @PathVariable("id")
            @NotNull(message = "选课关系id不能为空")
            @Min(value = 1, message = "id必须是正整数") Long id){
        int count = userOpenCourseRelationService.delete(id);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("退课失败");
        }
        return commonResult;
    }

    @ApiOperation("管理员：批量删除")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:delete:batch')")
    public CommonResult deleteBatch(@RequestParam @NotNull(message = "选课关系id列表不能为空") List<Long> ids){
        int count = userOpenCourseRelationService.deleteBatch(ids);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("退课失败");
        }
        return commonResult;
    }

    @ApiOperation("管理员：批量更新选课状态")
    @RequestMapping(value = "/update/batch", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:update:batch')")
    public CommonResult updateBatch(@RequestParam @NotNull(message = "选课关系id列表不能为空") List<Long> ids,
                                    @RequestParam @NotNull(message = "选课状态不得为空")
                                    @Range(min = -1, max = 4,
                                            message = "审核状态:-1->未通过审核/0->待审核/1->审核通过，" +
                                                    "待讲师确认/2->待学生确认/3->上课中/4->结课") Integer status,
                                    @RequestParam String statusComment){
        int count = userOpenCourseRelationService.updateStatusBatch(ids, status, statusComment);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }
    @ApiOperation("讲师确认")
    @RequestMapping(value = "/teacher/confirm/batch", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:teacher:confirm')")
    public CommonResult teacherConfirm(
            @RequestParam @NotNull(message = "选课关系id列表不能为空") List<Long> ids,
            @RequestParam String statusComment){
        long userId = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        for(Long id : ids){
            CmsUserOpencourseRelation userOpencourseRelation = userOpenCourseRelationService.get(id);
            CmsOpencourse opencourse = openCourseService.get(userOpencourseRelation.getOpencourseId());
            //用户不是开课人
            if(userOpencourseRelation == null || opencourse == null || userId != opencourse.getUserId()){
                return CommonResult.failed("选课信息不存在或系统禁止非法操作");
            }
        }
        int count = userOpenCourseRelationService.updateStatusBatch(
                ids, CmsUserOpenCourseRelationConstant.WAITING_STUDENT_CONFIRM, statusComment);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量确认失败");
        }
        return commonResult;
    }

    @ApiOperation("学生确认")
    @RequestMapping(value = "/student/confirm/batch", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('cms:user-opencourse-relation:student:confirm')")
    public CommonResult studentConfirm(
            @RequestParam @NotNull(message = "选课关系id列表不能为空") List<Long> ids,
            @RequestParam String statusComment){
        long userId = umsUserService.getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        for(Long id : ids){
            CmsUserOpencourseRelation userOpencourseRelation = userOpenCourseRelationService.get(id);
            //用户不是选课用户
            if(userOpencourseRelation == null || userId != userOpencourseRelation.getUserId()){
                return CommonResult.failed("选课信息不存在或系统禁止非法操作");
            }
        }
        int count = userOpenCourseRelationService.updateStatusBatch(
                ids, CmsUserOpenCourseRelationConstant.ING, statusComment);
        CommonResult commonResult;
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("批量确认失败");
        }
        return commonResult;
    }
}
