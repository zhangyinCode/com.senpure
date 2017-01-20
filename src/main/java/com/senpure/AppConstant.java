package com.senpure;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 初始化之后就不变的一些信息
 */
public class AppConstant implements Serializable {

    private static final long serialVersionUID = 1111442270801558256L;

    /**
     * 数据库表前缀
     */
    public static final String DB_BASE_PREFIX="SENPURE";


    public static final String ACTION_RESULT_MODEL_VIEW_KEY="action.result";


    /**
     * yyyy-MM-dd HH:mm:ss:SSS
     */
    public static final DateFormat DFMS= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final DateFormat DFS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final DateFormat DFM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * yyyy-MM-dd HH
     */
    public static final DateFormat DFH = new SimpleDateFormat("yyyy-MM-dd HH");
    /**
     * yyyy-MM-dd
     */
    public static final DateFormat DFD= new SimpleDateFormat("yyyy-MM-dd");

    /**
     * yyyMMddHHmmss
     */
    public static final DateFormat DFS_COMPACT = new SimpleDateFormat("yyyyMMddHHmmss");


}
