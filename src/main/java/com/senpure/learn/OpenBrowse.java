package com.senpure.learn;

import java.io.IOException;

/**
 * Created by Administrator on 2017/1/12.
 */
public class OpenBrowse {
    public static void main(String[] args) throws IOException {
        if(java.awt.Desktop.isDesktopSupported()){
            System.out.println("yes");
            try{
                //创建一个URI实例,注意不是URL
                java.net.URI uri=java.net.URI.create("http://127.0.0.1");
                //获取当前系统桌面扩展
                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            }catch(java.lang.NullPointerException e){
                e.printStackTrace();
            }catch(java.io.IOException e){
                e.printStackTrace();
            }
        }
    }
}
