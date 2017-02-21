package com.senpure.base.inner;

import com.senpure.base.util.StringUtil;

import java.io.File;


/**
 * Created by DZ on 2016-07-01 15:55
 */
public abstract class RoundEntityGenerator {

    private static boolean maven = true;
    protected static StringBuilder exist = new StringBuilder();
    protected static StringBuilder create = new StringBuilder();
    protected File entityFolder;
    protected File partFolder;
    protected int entityLength;
    protected String entityPackage;
    protected String[] entityNames;
    protected   String tempPath;
    protected final String NEW_LINE = "\n";


    public void execute(String part) {
        analyzePart(part);
        generate();
    }

    public abstract void generate();

    public abstract String[] getOnlyEntity();

    public void analyzePart(String part) {
         tempPath = maven ? "src" + File.separator + "main" + File.separator + "java" : "src";
        File f = new File(tempPath + File.separator + part.replace(".", File.separator));
        String partPath = f.getAbsolutePath();
        partFolder = new File(partPath);
        entityFolder = new File(partPath + File.separator + "entity");
        System.out.println("entityFolder :" + entityFolder);
        entityPackage = entityFolder.getAbsolutePath();
        int j = StringUtil.indexOf(entityPackage, tempPath);
        entityPackage = entityPackage.substring(j + tempPath.length() + 1).replace(File.separator, ".");
        System.out.println("entityPackage:" + entityPackage);
        String s[] = entityFolder.list();
        // 过滤掉非java文件
        int l = s.length;
        for (int i = 0; i < l; i++) {
            String name = s[i];
            if (name.endsWith(".java") && !name.equals("package-info.java")) {
                entityLength++;
            }
        }
        int k = 0;
        // 取得实体类名
       entityNames = new String[entityLength];
        // 去掉java后缀
        for (int i = 0; i < l; i++) {
            String name = s[i];
            if (name.endsWith(".java") && !name.equals("package-info.java")) {
                entityNames[k++] = name.replace(".java", "");

            }
        }
        String[] only=getOnlyEntity();
        if (only != null && StringUtil.isExist(only[0])) {
            entityNames = new String[only.length];
            entityLength = only.length;
            for (int i = 0; i < entityLength; i++) {
                entityNames[i] = only[i];
            }

        }
    }
}
