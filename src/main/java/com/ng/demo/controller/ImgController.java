package com.ng.demo.controller;

import com.ng.demo.model.WangEditor;
import com.ng.demo.service.impl.ImgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/20
 */

@Controller
public class ImgController {

    @Autowired
    public ImgServiceImpl imgService;

    @RequestMapping("/upload")
    @ResponseBody
    public WangEditor setImgUrl(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String value = imgService.imgSave(file, request);
        String[] values = {value};

        WangEditor wangEditor = new WangEditor();
        wangEditor.setErrno(0);
        wangEditor.setData(values);

        return wangEditor;
    }


}