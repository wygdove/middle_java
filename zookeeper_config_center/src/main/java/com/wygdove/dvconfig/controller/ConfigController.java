package com.wygdove.dvconfig.controller;

import com.wygdove.dvconfig.config.ConfigCenter;
import com.wygdove.dvconfig.constants.DvConfigConstants;
import com.wygdove.dvconfig.model.common.AjaxResult;
import com.wygdove.dvconfig.utils.AjaxUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: ConfigController
 * @Description:
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    private static final Logger log=LoggerFactory.getLogger(ConfigController.class);

    @Resource
    private ConfigCenter configCenter;


    @RequestMapping("createConfig")
    public AjaxResult createConfig(HttpServletRequest request) {
        log.info("controller:/config/createConfig");
        String path=DvConfigConstants.BASE_PATH+request.getParameter("path");
        String data=request.getParameter("data");
        String result=configCenter.create(path,data);
        return AjaxUtil.markSuccess(result);
    }

    @RequestMapping("getConfig")
    public AjaxResult getConfig(HttpServletRequest request) {
        log.info("controller:/config/getConfig");
        String path=DvConfigConstants.BASE_PATH+request.getParameter("path");
        String result=configCenter.get(path);
        return AjaxUtil.markSuccess(result);
    }

    @RequestMapping("updateConfig")
    public AjaxResult updateConfig(HttpServletRequest request) {
        log.info("controller:/config/updateConfig");
        String path=DvConfigConstants.BASE_PATH+request.getParameter("path");
        String data=request.getParameter("data");
        Stat result=configCenter.update(path,data);
        return AjaxUtil.markSuccess(result);
    }

    @RequestMapping("deleteConfig")
    public AjaxResult deleteConfig(HttpServletRequest request) {
        log.info("controller:/config/deleteConfig");
        String path=DvConfigConstants.BASE_PATH+request.getParameter("path");
        String result=configCenter.delete(path);
        return AjaxUtil.markSuccess(result);
    }

}
