package com.ng.demo.service.impl;

import com.ng.demo.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/4/9
 */
@Service
public class ImgServiceImpl {
    public String imgSave(MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        byte[] bytes = file.getBytes();
        String path = "E:/images/" + user.getUserId() + "/";

        File imgFile = new File(path);
        if (!imgFile.exists()) {
            imgFile.mkdirs();
        }
        String fileName = file.getOriginalFilename();// 文件名称

        try (FileOutputStream fos = new FileOutputStream(new File(path + fileName))) {
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String value = get_LAN_IP() + user.getUserId() + "/" + fileName;
        return value;
    }

    /*
    *
    * 为了获取本机ip；因为Nginx在本机ip8089上部署
    *
    *
    */
    public static String get_LAN_IP() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return "http://" + addr.getHostAddress() + ":8089/";
    }
}
