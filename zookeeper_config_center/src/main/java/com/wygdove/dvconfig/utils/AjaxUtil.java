package com.wygdove.dvconfig.utils;

import com.wygdove.dvconfig.model.common.AjaxResult;

/**
 * @Title: AjaxUtil
 * @Description:
 */
public class AjaxUtil {


    public static boolean isSuccess(AjaxResult ajaxResult) {
        return AjaxResult.AjaxStatus.SUCCESS.equals(ajaxResult.getStatus());
    }


    /**
     * 标记成功
     */
    public static AjaxResult markSuccess() {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.SUCCESS);
        return mrv;
    }

    public static AjaxResult markSuccess(Object obj) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.SUCCESS);
        mrv.setObj(obj);
        return mrv;
    }

    public static AjaxResult markSuccess(Object obj,String msg) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.SUCCESS);
        mrv.setObj(obj);
        mrv.setMsg(msg);
        return mrv;
    }

    public static AjaxResult markSuccess(Object obj,String msg,String info) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.SUCCESS);
        mrv.setObj(obj);
        mrv.setMsg(msg);
        mrv.setInfo(info);
        return mrv;
    }


    /**
     * 标记失败
     */
    public static AjaxResult markError() {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.ERROR);
        mrv.setMsg("操作失败");
        return mrv;
    }

    public static AjaxResult markError(String msg) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.ERROR);
        mrv.setMsg(msg);
        return mrv;
    }

    public static AjaxResult markError(String msg,String info) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.ERROR);
        mrv.setMsg(msg);
        mrv.setInfo(info);
        return mrv;
    }


    /**
     * 标记未登录
     */
    public static AjaxResult markNoLogin() {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.NOLOGIN);
        return mrv;
    }


    /**
     * 标记刷新
     */
    public static AjaxResult markRefresh() {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.REFRESH);
        return mrv;
    }


    /**
     * 标记重复提交
     */
    public static AjaxResult markRepeat(String msg) {
        AjaxResult mrv=new AjaxResult();
        mrv.setStatus(AjaxResult.AjaxStatus.REPEAT);
        mrv.setMsg(msg);
        return mrv;
    }

}
