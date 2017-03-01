package com.senpure;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 初始化之后就不变的一些信息
 */
public class AppConstant implements Serializable {

    private static final long serialVersionUID = 1111442270801558256L;

    public static final String PROJECT_NAME="SENPURE";
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

    /**
     * 容器等级，值越小等级越高，目前最小为0
     */
    public static final int CONTAINER_LEVEL_TOP = 0;
    public static final int CONTAINER_LEVEL_COMPANY = 1;
    public static final int CONTAINER_LEVEL_DEPARTMENT = 10;
    public static final int CONTAINER_LEVEL_GROUP = 100;

    public static final String CONTAINER_SEPARTOR="-";

    public static final String PERMISSION_TYPE_NORMAL="NORMAL";
    public static final String PERMISSION_TYPE_OWNER="OWNER";
    public static final String PERMISSION_TYPE_IGNORE ="IGNORE ";


    /*
	 * 账号状态，将来可能会有新的状态，采用string 不用枚举
	 */
    public static final String ACCOUNT_STATE_CREATE = "CREATE";
    public static final String ACCOUNT_STATE_NORMAL = "NORMAL";
    public static final String ACCOUNT_STATE_BAN = "BAN";
    /**
     *
     * 禁止登陆的方式之一，自己申请冻结
     */
    public static final String ACCOUNT_STATE_BAN_SELF = "BAN_SELF";

    public static final String LOGIN_TYPE_ACCOUNT = "ACCOUNT";
    public static final String LOGIN_TYPE_COOKIE = "COOKIE";
    public static final String LOGIN_TYPE_OTHER_LOGIN="OTHER_LOGIN";
}
