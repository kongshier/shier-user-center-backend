package com.shier.shierusercenterbackend.controller;

import com.shier.shierusercenterbackend.common.BaseResponse;
import com.shier.shierusercenterbackend.service.OssService;
import com.shier.shierusercenterbackend.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(tags = "阿里云文件管理")
@RestController
@RequestMapping("/fileOss")
@CrossOrigin(origins = "http://user.kongshier.top/", allowCredentials = "true")
public class OssController {

    @Resource
    private OssService ossService;

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public BaseResponse<String> uploadOssFile(@RequestParam(required = false) MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            return null;
        }
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        //返回r对象
        return ResultUtils.success(url);
    }
}
