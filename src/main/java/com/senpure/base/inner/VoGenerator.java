package com.senpure.base.inner;

import com.senpure.base.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VoGenerator {
    private static Logger log = LogManager.getLogger(VoGenerator.class);
    /**
     * 实体类所在的包名
     */
    private static String part = "com.senpure.base";

    /**
     * 只生产这里面的类
     */
   // private static String[] only = {""};
    private static String[] only = {"Account"};
    /**
     * 是否强制覆盖
     */
    private static boolean enforcement = true;


    private static File voFolder;
    private static File entityFolder;

    private static int entityLength;
    private static String entityPackage;
    private static String voPackage;
    private static final String NEW_LINE = "\n";
    private static StringBuilder exist = new StringBuilder();
    private static StringBuilder create = new StringBuilder();
    static StringBuilder convert = new StringBuilder();

    static StringBuilder code = new StringBuilder();
    private static boolean maven = true;

    public static void execute() {
        String tempPath = maven ? "src" + File.separator + "main" + File.separator + "java" : "src";
        File f = new File(tempPath + File.separator + part.replace(".", File.separator));
        String partPath = f.getAbsolutePath();
        voFolder = new File(partPath + File.separator + "vo");
        if (!voFolder.exists()) {
            System.err.println(voFolder.getAbsolutePath() + ",不存在，创建文件夹");
            voFolder.mkdirs();
        }
        log.debug("vo:" + voFolder.getAbsolutePath());
        // System.out.println("vo:" + voFolder.getAbsolutePath());

        entityFolder = new File(partPath + File.separator + "entity");

        entityPackage = entityFolder.getAbsolutePath();
        int j = StringUtil.indexOf(entityPackage, tempPath);
        entityPackage = entityPackage.substring(j + tempPath.length() + 1).replace(File.separator, ".");
        // System.out.println("entityPackage:" + entityPackage);
        log.debug("entityPackage:" + entityPackage);
        voPackage = voFolder.getAbsolutePath();
        int m = StringUtil.indexOf(voPackage, tempPath);
        voPackage = voPackage.substring(m + tempPath.length() + 1).replace(File.separator, ".");
        // System.out.println("voPackage:" + voPackage);
        log.debug("voPackage:" + voPackage);
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
        String[] entityNames = new String[entityLength];
        // 去掉java后缀
        for (int i = 0; i < l; i++) {

            String name = s[i];
            if (name.endsWith(".java")) {

                log.debug("实体类：" + name);
                entityNames[k++] = name.replace(".java", "");

            }
        }

        List<String> entityList = new ArrayList<>();
        // 过滤掉中间对象,不过滤中间对象了。。。。
        for (int i = 0; i < entityLength; i++) {

            String name = entityNames[i];
            boolean exclude = false;

            for (int o = 0; o < entityLength; o++) {

                if (o == i) {
                    continue;
                }
                String other = entityNames[o];
                if (name.startsWith(other)) {
                    // 不过滤中间对象了
                    // exclude = true;
                    break;
                }
            }
            if (exclude) {
                continue;
            }

            entityList.add(name);
        }

        if (only != null && StringUtil.isExist(only[0])) {
            entityList.clear();
            for (String entity : only) {
                entityList.add(entity);
            }
        }

        for (String entity : entityList) {

            File vo = new File(voFolder, entity + "Vo.java");

            // System.out.println("准备生成vo:" + entity + "Vo.java");
            log.debug("准备生成vo:" + entity + "Vo.java");
            create.append("准备生成vo:" + entity + "Vo.java");
            try {
                File entityFile = new File(entityFolder, entity + ".java");
                BufferedReader reader = new BufferedReader(new FileReader(entityFile));
                StringBuilder sb = new StringBuilder();
                // entitytovo
                StringBuilder convert = new StringBuilder();
                // votoentity
                StringBuilder convert2 = new StringBuilder();

                String entityVo = entity + "Vo";

                convert.append(" public static ");
                convert.append(entityVo).append(" convert(");
                convert.append(entity).append(" entity");
                convert.append(") {").append(NEW_LINE);
                convert.append(" 	");
                convert.append(entityVo).append(" vo");
                convert.append("= new ").append(entityVo).append("();");
                convert.append(NEW_LINE);
                convert.append(" 	");
                convert.append("return convert(").append("entity,");

                convert.append("vo);");
                convert.append(NEW_LINE);
                convert.append("	}").append(NEW_LINE).append(NEW_LINE);

                convert.append(" public static ");
                convert.append(entityVo).append(" convert(");
                convert.append(entity).append(" entity,").append(entity).append("Vo vo");
                convert.append(") {").append(NEW_LINE);
                // id,先把id的方法写好
                convert.append(" 	");
                convert.append("    vo.setId(entity.getId());").append(NEW_LINE);

                convert.append(" 	");
                convert.append("    vo.setVersion(entity.getVersion());").append(NEW_LINE);

                convert2.append(" public static ");
                convert2.append(entity).append(" convert(");
                convert2.append(entityVo).append(" vo");
                convert2.append(") {").append(NEW_LINE);
                convert2.append(" 	");
                convert2.append(entity).append(" entity");
                convert2.append("= new ").append(entity).append("();");
                convert2.append(NEW_LINE);
                convert2.append(" 	");
                convert2.append("return convert(").append("vo,");
                convert2.append("entity);");
                convert2.append(NEW_LINE);
                convert2.append("	}").append(NEW_LINE).append(NEW_LINE);

                convert2.append(" public static ");
                convert2.append(entity).append(" convert(");
                convert2.append(entityVo).append(" vo,").append(entity).append(" entity");
                convert2.append(") {").append(NEW_LINE);
                // id
                convert2.append(" 	");
                convert2.append("if(vo.getId()!=null){").append(NEW_LINE);
                convert2.append(" 		");
                convert2.append("entity.setId(vo.getId());").append(NEW_LINE);
                convert2.append(" 	");
                convert2.append("}").append(NEW_LINE);
                convert2.append(" 	");
                convert2.append("if(vo.getVersion()!=null){").append(NEW_LINE);
                convert2.append(" 		");
                convert2.append("entity.setVersion(vo.getVersion());").append(NEW_LINE);
                convert2.append(" 	");
                convert2.append("}").append(NEW_LINE);


                List<EntityClass> ec = new ArrayList<>();
                EntityClass id = new EntityClass();
                id.first = "private";

                id.type = "Integer";
                id.name = "id";
                ec.add(id);
                boolean nextLine = true;
                String temp;

                boolean go = true;
                while (go) {

                    temp = reader.readLine();
                    if (temp == null) {

                        go = false;
                        temp = "private Integer version;";
                    }

                    if (temp == null) {
                        continue;
                    }

                    // 过滤注解
                    if (temp.contains("@")) {
                        if (temp.contains("@OneToMany") || temp.contains("@JoinColumn")) {
                            nextLine = false;

                        }

                        continue;
                    } else {

                        if (nextLine) {

                            // 只能查找private 的属性
                            int index = temp.indexOf("private");

                            if (index > -1 && temp.indexOf("static") < 0) {
                                log.debug("普通字段属性:" + temp);
                                int end = temp.indexOf("=", index);
                                if (end < 0) {
                                    end = temp.indexOf(";", index);
                                }
                                if (end > -1) {
                                    temp = temp.substring(index, end).trim();
                                }

                                EntityClass e = new EntityClass();
                                int tempL = temp.length();

                                for (int i = 0; i < tempL; i++) {

                                    char c = temp.charAt(i);
                                    if (c == ' ') {
                                        e.first = temp.substring(0, i);
                                        temp = temp.substring(i);

                                        temp = temp.trim();
                                        tempL = temp.length();
                                        break;
                                    }
                                }

                                for (int i = 0; i < tempL; i++) {

                                    char c = temp.charAt(i);
                                    if (c == ' ') {
                                        e.type = temp.substring(0, i);
                                        temp = temp.substring(i);
                                        temp = temp.trim();
                                        e.name = temp;
                                        break;
                                    }
                                }

                                boolean canadd = true;
                                for (EntityClass t : ec) {
                                    if (t.name.equals(e.name)) {
                                        canadd = false;
                                        break;
                                    }
                                }
                                if (canadd) {

                                    convert.append("		");
                                    convert.append("vo.set").append(StringUtil.toUpperFirstLetter(e.name));
                                    convert.append("(").append("entity.");

                                    String method = e.type.equalsIgnoreCase("boolean") ? "is" : "get";

                                    convert.append(method);
                                    convert.append(StringUtil.toUpperFirstLetter(e.name)).append("());")
                                            .append(NEW_LINE);

                                    convert2.append(" 	");
                                    char c = (char) e.type.getBytes()[0];

                                    if (StringUtil.isUpperLetter(c)) {// vo.getSome() !=null
                                        convert2.append("if(vo.").append(method)
                                                .append(StringUtil.toUpperFirstLetter(e.name)).append("()");
                                        convert2.append("!=null){").append(NEW_LINE);
                                        convert2.append(" 		");
                                        convert2.append("entity.set").append(StringUtil.toUpperFirstLetter(e.name));
                                        convert2.append("(").append("vo.");
                                        convert2.append(method);
                                        convert2.append(StringUtil.toUpperFirstLetter(e.name)).append("());")
                                                .append(NEW_LINE);
                                        convert2.append(" 	");
                                        convert2.append("}").append(NEW_LINE);
                                    } else {


                                        convert2.append("entity.set").append(StringUtil.toUpperFirstLetter(e.name));
                                        convert2.append("(").append("vo.");
                                        convert2.append(method);
                                        convert2.append(StringUtil.toUpperFirstLetter(e.name)).append("());")
                                                .append(NEW_LINE);


                                    }
                                    ec.add(e);
                                }

                            }

                        } else {

                            if (temp.indexOf("List") < 0) {

                                int index = temp.indexOf("private");
                                if (index > -1 && temp.indexOf("static") < 0) {
                                    log.debug("其他实体属性只转换ID:" + temp);
                                    int end = temp.indexOf("=", index);
                                    if (end < 0) {
                                        end = temp.indexOf(";", index);
                                    }
                                    if (end > -1) {
                                        temp = temp.substring(index, end).trim();
                                    }

                                    EntityClass e = new EntityClass();
                                    int tempL = temp.length();

                                    for (int i = 0; i < tempL; i++) {

                                        char c = temp.charAt(i);
                                        if (c == ' ') {
                                            e.first = temp.substring(0, i);
                                            temp = temp.substring(i);

                                            temp = temp.trim();
                                            tempL = temp.length();

                                            break;
                                        }
                                    }

                                    for (int i = 0; i < tempL; i++) {

                                        char c = temp.charAt(i);
                                        if (c == ' ') {
                                            e.type = temp.substring(0, i);
                                            temp = temp.substring(i);
                                            temp = temp.trim();
                                            e.name = temp;
                                            break;
                                        }
                                    }

                                    String ot = e.type;

                                    e.type = "Integer";
                                    e.name += "Id";
                                    // e.name=StringUtil.toLowerFirstLetter(ot)+"Id";
                                    boolean canadd = true;
                                    for (EntityClass t : ec) {
                                        if (t.name.equals(e.name)) {
                                            canadd = false;
                                            break;
                                        }
                                    }
                                    if (canadd) {

                                        String ob = e.name.replace("Id", "");

                                        String rob = ob;

                                        boolean self = false;
                                        // System.out.println("=============ot:"+ot+",entity:"+entity);

                                        if (ot.equals(entity)) {
                                            self = true;
                                        }

                                        if (self) {
                                            rob = entity;
                                        } else {
                                            rob = ot;
                                        }
                                        // log.debug("e:"+e);
                                        // log.debug("ob:"+ob+",rob:"+rob);

                                        convert.append("		").append(StringUtil.toUpperFirstLetter(rob));
                                        convert.append(" ").append(ob).append(" = entity.get")
                                                .append(StringUtil.toUpperFirstLetter(ob));
                                        convert.append("();").append(NEW_LINE);

                                        convert.append("		if(").append(ob).append("!=null)").append("{")
                                                .append(NEW_LINE);

                                        convert.append("			");
                                        convert.append("vo.set").append(StringUtil.toUpperFirstLetter(e.name));
                                        convert.append("(").append(ob).append(".getId");

                                        convert.append("());").append(NEW_LINE);
                                        convert.append("		}").append(NEW_LINE);

                                        convert2.append("		").append(StringUtil.toUpperFirstLetter(rob));
                                        convert2.append(" ").append(ob).append(" = entity.get")
                                                .append(StringUtil.toUpperFirstLetter(ob));
                                        convert2.append("();").append(NEW_LINE);

                                        convert2.append("		if(").append(ob).append("!=null)").append("{")
                                                .append(NEW_LINE);

                                        convert2.append("			");

                                        convert2.append(ob).append(".setId(");
                                        convert2.append("vo.get").append(StringUtil.toUpperFirstLetter(e.name));

                                        convert2.append("());").append(NEW_LINE);
                                        convert2.append("		}").append(NEW_LINE);

                                        ec.add(e);
                                    }

                                }

                            } else if (temp.indexOf("List") > 0) {
                                log.debug("集合属性不做任何转换:" + temp);
                            }

                            nextLine = true;
                        }

                    }

                }
                reader.close();
                sb.append("package ").append(voPackage).append(";").append(NEW_LINE).append(NEW_LINE);
                sb.append("import java.io.Serializable;").append(NEW_LINE);
                sb.append("import java.util.Date;").append(NEW_LINE);
                sb.append("public class ").append(entity).append("Vo implements Serializable ")

                        .append("{").append(NEW_LINE);

                sb.append("	private static final long serialVersionUID = ");
                sb.append(System.currentTimeMillis()).append("L").append(";").append(NEW_LINE).append(NEW_LINE)
                        .append(NEW_LINE);

                // sb.append(" private int id;").append(NEW_LINE);
                for (EntityClass e : ec) {
                    sb.append("	").append(e.first).append("	").append(e.type).append(" ").append(e.name).append(";")
                            .append(NEW_LINE);

                }

                sb.append(NEW_LINE);

                for (EntityClass e : ec) {
                    sb.append("	").append("public").append(" ").append(e.type)

                            .append(" ");

                    if (e.type.equalsIgnoreCase("boolean")) {
                        sb.append("is");
                    } else {
                        sb.append("get");
                    }

                    sb.append(StringUtil.toUpperFirstLetter(e.name));
                    sb.append("() {").append(NEW_LINE);
                    sb.append("		return ").append(e.name).append(";").append(NEW_LINE);
                    sb.append("	}").append(NEW_LINE).append(NEW_LINE);
                    sb.append(NEW_LINE);

                    sb.append("	").append("public").append("	void")

                            .append(" set");
                    sb.append(StringUtil.toUpperFirstLetter(e.name));
                    sb.append("(").append(e.type).append(" ").append(e.name);
                    sb.append(") {").append(NEW_LINE);
                    sb.append("		this.").append(e.name).append("=").append(e.name);
                    sb.append(" ;").append(NEW_LINE);
                    sb.append("	}").append(NEW_LINE).append(NEW_LINE);

                }
                sb.append("}");
                if (vo.exists() && !enforcement) {

                    log.warn(vo.getName() + "存在，不予处理");
                    // System.err.println(vo.getName() + "存在，不予处理");

                    exist.append(vo.getName() + "存在，不予处理");

                } else {
                    // vo.createNewFile();
                    Writer writer = new FileWriter(vo);
                    writer.write(sb.toString());

                    writer.flush();
                    writer.close();

                    // System.out.println(convert.toString());
                    log.debug("vo:" + entity + "Vo.java" + "生成完成");
                    // System.out.println("vo:" + entity + "Vo.java" + "生成完成");
                }
                convert.append("		return ").append("vo;").append(NEW_LINE);
                convert.append("	}").append(NEW_LINE).append(NEW_LINE);

                convert2.append("		return ").append("entity;").append(NEW_LINE);
                convert2.append("	}").append(NEW_LINE).append(NEW_LINE);
                VoGenerator.convert.append(convert).append(convert2);
                VoGenerator.code.append(sb);

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }

    private static class EntityClass {

        private String first;
        private String type;
        private String name;

        @Override
        public String toString() {
            return "EntityClass [first=" + first + ", type=" + type + ", name=" + name + "]";
        }

    }

    public static void main(String[] args) {
        execute();
        //  log.warn("应该生成的代码:\n" + code);

        // System.out.println("应该生成的代码:");
        // System.out.println(code);

        // System.out.println("entity-vo方法:");
        log.warn("entity-vo方法:\n" + convert);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stsel = new StringSelection(convert.toString());
        clipboard.setContents(stsel, stsel);
        log.warn("已将entity-vo方法 复制到系统粘贴板");
        // System.out.println(convert);

        // String str = "private String       description";
        //
        // System.out.println(Arrays.toString(str.split(" ")));

    }

}
