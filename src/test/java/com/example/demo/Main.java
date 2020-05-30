package com.example.demo;

import org.springframework.web.util.HtmlUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/4/9
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException {
//        String a = "<p><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">F飞洒登封市</font></font></p>";
//
//        String b= HtmlUtils.htmlEscapeDecimal(a);
//        System.out.println(b);
//
//        String c = HtmlUtils.htmlUnescape(b);
//        System.out.println(c);
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(formatDate);
    }

}
