package com.wygdove.multiprovince.model.common;

/**
 * @Title: AjaxResult
 * @Description:
 */
public class AjaxResult {

    private Integer status;
    private Object obj;
    private String msg;
    private String info;


    public static class AjaxStatus {
        public static final Integer SUCCESS=0;
        public static final Integer ERROR=1;
        public static final Integer NOLOGIN=2;
        public static final Integer REFRESH=3;
        public static final Integer REPEAT=4;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status=status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj=obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info=info;
    }
}
