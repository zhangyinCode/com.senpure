package com.senpure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;

public class AppContext {

    private static Logger log = LogManager.getLogger(AppContext.class);
    private static String classRootPath;

    static {

        try {
            classRootPath = AppContext.class.getResource("").toURI().getPath();
            int index = classRootPath.indexOf("/");
            if (index == 0) {
                classRootPath = classRootPath.substring(1);
            }
            classRootPath = classRootPath.replace("/", File.separator);
            String packpath = AppContext.class.getPackage().getName();
            packpath = packpath.replace(".", File.separator);
            classRootPath = classRootPath.replace(packpath, "");
            while (classRootPath.charAt(classRootPath.length() - 1) == File.separatorChar) {
                classRootPath = classRootPath.substring(0, classRootPath.length() - 1);
            }
            log.info("classRootPath {}",classRootPath);
        } catch (URISyntaxException e) {


            log.error("",e);
        }
    }

    /**
     * class 所在包的根绝对路径<br>
     * 如 /class 或/bin
     *
     * @return str
     */
    public static String getClassRootPath() {

        return classRootPath;
    }
}
