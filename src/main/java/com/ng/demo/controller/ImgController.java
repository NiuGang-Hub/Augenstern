package com.ng.demo.controller;


import com.ng.demo.model.User;
import com.ng.demo.model.WangEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/20
 */

@Controller
public class ImgController {

    @RequestMapping("/upload")
    @ResponseBody
    public WangEditor setImgUrl(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        byte[] bytes = file.getBytes();
        String path = "E:/images/" + user.getUserId() + "/";

        File imgFile = new File(path);
        if (!imgFile.exists()) {
            imgFile.mkdirs();
        }
        String fileName = file.getOriginalFilename();// 文件名称
        System.out.println(path + fileName);

        try (FileOutputStream fos = new FileOutputStream(new File(path + fileName))) {
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //8089是我自己的Nginx图片服务器，可自行百度


        String value = get_LAN_IP() + user.getUserId() + "/" + fileName;
        String[] values = {value};

        WangEditor wangEditor = new WangEditor();
        wangEditor.setErrno(0);
        wangEditor.setData(values);
        // System.out.println(wangEditor.getData());
        return wangEditor;
    }

    public static String get_LAN_IP() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return "http://" + addr.getHostAddress() + "/";
    }

}