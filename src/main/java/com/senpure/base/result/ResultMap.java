package com.senpure.base.result;

import com.alibaba.fastjson.JSON;
import com.senpure.base.util.Assert;

import java.io.File;
import java.util.HashMap;

/**
 * Created by DZ on 2016-07-01 15:00
 */
public class ResultMap extends HashMap<String, Object> {
    private static final long serialVersionUID = -3076981336664920688L;
    public static final String RESULT_KEY = "code";
    public static final String MESSAGE_KEY = "message";
    public static final String FILE_KEY = "file";
    public static final String FILE_NAME_KEY = "fileName";
    public static final String DELETE_FILE_KEY = "deletefile";


    public static ResultMap getSuccessResult() {
        return new ResultMap(Result.SUCCESS);
    }

    public static ResultMap getDimResult() {
        return new ResultMap(Result.ERROR_DIM);
    }

    public static ResultMap getResult(int code) {
        return new ResultMap(code);
    }

    private ResultMap() {
        super();

    }

    public ResultMap(int code) {
        super.put(RESULT_KEY, code);
    }

    public ResultMap put(String key, Object value) {
        if (key.equals(RESULT_KEY)) {
            Assert.error("错误操作");
        }
        super.put(key, value);
        return this;
    }


    public ResultMap remove(String key) {

        super.remove(key);
        return this;
    }

    public boolean isSuccess() {
        Integer code = (Integer) super.get(RESULT_KEY);
        return code.intValue() == Result.SUCCESS;
    }

    public int getCode() {
        Integer code = (Integer) super.get(RESULT_KEY);
        return code == null ? Result.FAILURE : code;
    }

    public String getMessage() {

        return (String) super.get(MESSAGE_KEY);
    }

    public boolean isDelete() {
        Boolean d = (Boolean) get(DELETE_FILE_KEY);
        return d == null ? true : d;
    }

    public File getFile() {
        return (File) get(FILE_KEY);

    }

    public String getFileName() {
        String name = (String) get(FILE_NAME_KEY);
        if (name == null) {
            File file = getFile();
            if (file != null) {
                return file.getName();
            }
        }
        return name;
    }

    public String toJson() {
        String json = JSON.toJSONString(this);
        return json;
    }
}
