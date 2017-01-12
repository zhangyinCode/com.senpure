package com.senpure.base.result;


import com.senpure.base.annotation.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.MessageFormat;
import java.util.*;

/**
 * 根据code值找到资源文件的key,实现国际化结果
 */
public class ResultHelper {
    private static String BASE_NAME = "i18n/result/result";
    private static Logger log = LogManager.getLogger(ResultHelper.class);
    private static Map<Integer, String> codeMap = new HashMap();
    private static boolean devMode = false;
    static {
        syncResults();
        checkResult();
    }

    public static String getKey(int code) {

        String key = codeMap.get(code);
        return key == null ? codeMap.get(Result.FAILURE) : key;
    }

    public static String getMessage(int code, Locale locale) {
        try {
            return ResourceBundle.getBundle(BASE_NAME, locale).getString(getKey(code));
        } catch (MissingResourceException e) {

            return "RESULT_CODE[" + code + "]";
        }

    }

    public static String getMessage(int code, Locale locale, Object... args) {


        return MessageFormat.format(getMessage(code, locale), args);

    }

    public static ResultMap wrapMessage(ResultMap resultMap, Locale locale) {

        return
                resultMap.put(ResultMap.MESSAGE_KEY, ResultHelper.getMessage(resultMap.getCode(), locale));
    }

    public static ResultMap wrapMessage(ResultMap resultMap, Locale locale, Object args) {

        return
                resultMap.put(ResultMap.MESSAGE_KEY, ResultHelper.getMessage(resultMap.getCode(), locale, args));
    }

    public static void refresh() {
        ResourceBundle.clearCache();
    }

    public static void syncResults() {

        try {
            File i18n;
            log.debug("devMode {}", devMode);
            if (devMode) {
                i18n = new File("src/main/resources/i18n/result/result.properties");
            }
            // File ;
            else {
                i18n = new File(ResultHelper.class.getClassLoader().getResource("").toURI().getPath()
                        + "i18n/result/result.properties");
            }

            // log.debug("资源文件完整路径：" + i18n);

            log.debug("资源文件完整路径：" + i18n.getAbsolutePath());
            // System.out.println(i18n.getAbsolutePath()+"======================================================");

            boolean exist = true;
            boolean create = false;
            if (!i18n.exists()) {
                exist = false;
                create = true;
                i18n.getParentFile().mkdirs();
            }
            SortProperties props = new SortProperties();

            if (exist) {

                InputStream in = new FileInputStream(i18n);
                props.load(in);
                in.close();

            }
            Class<Result> clazz = Result.class;
            Field[] fields = clazz.getFields();
            Result result = new Result() {
            };
            // StringBuilder titleBuilder = new StringBuilder();
            // StringBuilder messageBuilder = new StringBuilder();
            StringBuilder nameBuilder = new StringBuilder();
            boolean update = false;
            for (Field field : fields) {

                String name = field.getName().replace("_", ".").toLowerCase();
                int code = 0;
                try {
                    code = field.getInt(result);
                } catch (IllegalArgumentException e) {

                    e.printStackTrace();
                    continue;
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                    continue;
                }

                codeMap.put(code, name);
                // String title = name + ".title";
                // String message = name + ".message";
                // if (!props.containsKey(title)) {
                // update = true;
                // titleBuilder.append(title).append("\n");
                //
                // props.put(title, "RESULT");
                //
                // }
                // if (!props.containsKey(message)) {
                // update = true;
                // messageBuilder.append(message).append("\n");
                //
                // props.put(message, "RESULT-CODE[" + code + "]");
                //
                // }

                if (!props.containsKey(name)) {
                    update = true;
                    nameBuilder.append(name).append("\n");
                    Message m = field.getAnnotation(Message.class);

                    if (m != null && m.message().trim().length() != 0) {
                        log.trace(code + " >> " + name + " >> " + m.message());
                        props.put(name, m.message());
                    } else {
                        log.trace(code + " >> " + name + " >> " + "RESULT-CODE[" + code + "]");
                        props.put(name, "RESULT-CODE[" + code + "]");
                    }

                }

            }

            if (update) {
                OutputStream out = new FileOutputStream(i18n);

                if (create) {
                    log.debug("create");

                    props.store(out, "create properties");
                } else

                {

                    log.debug("update");
                    props.store(out, "update name:\n" + nameBuilder.toString()
                            + "############################################################################");

                }
                out.close();
                props.clear();

            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


    private static class SortProperties extends Properties {

        /**
         *
         */
        private static final long serialVersionUID = 8797697874867004841L;


        private final LinkedHashSet<Object> keys = new LinkedHashSet();


        public Enumeration<Object> keys() {

            return Collections.<Object>enumeration(keys);

        }


        public Object put(Object key, Object value) {

            keys.add(key);

            return super.put(key, value);

        }


        public Set<Object> keySet() {

            return keys;

        }


        public Set<String> stringPropertyNames() {

            Set<String> set = new LinkedHashSet<String>();


            for (Object key : this.keys) {

                set.add((String) key);

            }


            return set;

        }
    }

    private static void checkResult() {
        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    WatchService ws = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(Result.class.getResource("").toURI());
                    log.debug("result class 监控路径" + path);
                    path.register(ws, StandardWatchEventKinds.ENTRY_MODIFY);
                    while (true) {
                        WatchKey key = ws.take();
                        List<WatchEvent<?>> events = key.pollEvents();
                        for (WatchEvent<?> e : events) {

                            String name = e.context().toString();
                            if (name.equals("ResultHelper.class")) {
                                log.debug("重新映射结果表============");
                                syncResults();

                            }
                        }
                        key.reset();
                    }

                } catch (IOException e) {

                    log.error("Watch ERROR", e);
                } catch (URISyntaxException e) {

                    log.error("Watch ERROR", e);
                } catch (InterruptedException e) {
                    log.error("Watch ERROR", e);
                }

            }
        };
        thread.setDaemon(true);
        thread.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {

                try {
                    WatchService ws = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(Result.class.getResource("/i18n/result").toURI());
                    log.debug("result properties 监控路径" + path);

                    path.register(ws, StandardWatchEventKinds.ENTRY_MODIFY);
                    while (true) {
                        WatchKey key = ws.take();
                        List<WatchEvent<?>> events = key.pollEvents();
                        for (WatchEvent<?> e : events) {

                            String name = e.context().toString();
                            if (name.equals("result.properties")) {

                                log.debug("清空result缓存====================");
                                refresh();

                            }
                        }
                        key.reset();
                    }

                } catch (IOException e) {

                    log.error("Watch ERROR", e);
                } catch (URISyntaxException e) {

                    log.error("Watch ERROR", e);
                } catch (InterruptedException e) {
                    log.error("Watch ERROR", e);
                }

            }
        };
        if (!devMode) {
            thread2.setDaemon(true);
            thread2.start();
        }


    }

    public static void test(int code, Object... args) {
        System.out.println(getMessage(code, Locale.CHINA, args));
    }


    public static void print() {
        Class<Result> clazz = Result.class;
        Field[] fields = clazz.getFields();
        Result result = new Result() {
        };
        StringBuilder nameBuilder = new StringBuilder();
        boolean update = false;
        for (Field field : fields) {

            String name = field.getName().replace("_", ".").toLowerCase();
            int code = 0;
            try {
                code = field.getInt(result);
            } catch (IllegalArgumentException e) {

                e.printStackTrace();
                continue;
            } catch (IllegalAccessException e) {

                e.printStackTrace();
                continue;
            }


            nameBuilder.append(name).append("\n");
            Message m = field.getAnnotation(Message.class);

            if (m != null && m.message().trim().length() != 0) {
                System.out.println(code + " >> " + name + " >> " + m.message());

            } else {
                System.out.println(code + " >> " + name + " >> " + "RESULT-CODE[" + code + "]");

            }

        }


    }

    public static void main(String[] args) throws Exception {


        print();
        System.out.println(  getMessage(Result.SUCCESS,Locale.CHINESE,"jkl"));


    }
}
