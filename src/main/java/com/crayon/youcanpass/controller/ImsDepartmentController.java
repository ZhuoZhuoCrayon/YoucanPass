package com.crayon.youcanpass.controller;

import com.crayon.youcanpass.common.api.CommonPage;
import com.crayon.youcanpass.common.api.CommonResult;
import com.crayon.youcanpass.dto.ImsDepartmentTreeNode;
import com.crayon.youcanpass.model.ImsDepartment;
import com.crayon.youcanpass.service.ImsDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制层
 * Created by crayon on 2020/02/02
 */

@Api(tags = "ImsDepartmentController", description = "部门信息管理")
@RestController
@RequestMapping("/ims/department")
public class ImsDepartmentController {
    @Autowired
    private ImsDepartmentService departmentService;

    @ApiOperation("获取指定id部门信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:id')")
    public CommonResult<ImsDepartment> get(@PathVariable("id") Long id){
        return CommonResult.success(departmentService.get(id));
    }

    @ApiOperation("分页查询部门信息")
    @RequestMapping(value = "/list/page", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:list:page')")
    public CommonResult<CommonPage<ImsDepartment>> listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<ImsDepartment> departmentList = departmentService.listByPage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(departmentList));
    }

    @ApiOperation("获取所有部门信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:list')")
    public CommonResult<List<ImsDepartment>> list(){
        return CommonResult.success(departmentService.list());
    }

    @ApiOperation("获取指定部门id所属层次信息:向上查找")
    @RequestMapping(value = "/{id}/root", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:id:root')")
    public CommonResult<ImsDepartmentTreeNode> getDepartmentRoot(@PathVariable("id") Long id){
        return CommonResult.success(departmentService.getDepartmentRoot(id));
    }

    @ApiOperation("获取指定部门id下属部门信息:向下查找")
    @RequestMapping(value = "/{id}/structure", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:id:structure')")
    public CommonResult<List<ImsDepartmentTreeNode>> listDepartmentStructure(@PathVariable("id") Long id){
        return CommonResult.success(departmentService.listDepartmentStructure(id));
    }


    @ApiOperation("添加部门信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ims:department:insert')")
    public CommonResult insert(@RequestBody ImsDepartment department){
        CommonResult commonResult;
        int count = departmentService.insert(department);
        if(count > 0){
            commonResult = CommonResult.success(department.getId());
        }else{
            commonResult = CommonResult.failed("创建失败");
        }
        return commonResult;
    }

    @ApiOperation("更新指定id部门信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ims:department:update:id')")
    public CommonResult update(@PathVariable("id") Long id,
                               @RequestBody ImsDepartment department){
        CommonResult commonResult;
        int count = departmentService.update(id, department);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("更新失败");
        }
        return commonResult;
    }

    @ApiOperation("删除指定id部门信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ims:department:delete:id')")
    public CommonResult delete(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count = departmentService.delete(id);
        if(count > 0){
            commonResult = CommonResult.success(count);
        }else{
            commonResult = CommonResult.failed("删除失败");
        }
        return commonResult;
    }
}