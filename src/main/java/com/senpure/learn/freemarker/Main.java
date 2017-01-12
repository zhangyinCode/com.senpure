package com.senpure.learn.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/7.
 */
public class Main {
    public static void main(String[] args) throws IOException, TemplateException {

        Configuration cfg =  new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

        cfg.setClassForTemplateLoading(Main.class,"/com/senpure/learn/freemarker");
        Template t = cfg.getTemplate("hello_world.ftl");//指定模板
        FileOutputStream fos = new FileOutputStream(new File("d:/hello.html"));//

        Map<String ,Object> data=new HashMap<>();

        data.put("name","lzz");
        t.process(data, new OutputStreamWriter(fos,"utf-8"));//
    }
}
