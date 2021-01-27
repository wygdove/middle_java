package com.wygdove.dvconfig.controller;

import com.wygdove.dvconfig.config.ConfigCenter;
import com.wygdove.dvconfig.model.common.AjaxResult;
import com.wygdove.dvconfig.utils.AjaxUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: TestController
 * @Description:
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    private static final Logger log=LoggerFactory.getLogger(ConfigController.class);

    @Resource
    private ConfigCenter configCenter;

    @RequestMapping("getConfig")
    public AjaxResult getConfig(HttpServletRequest request) {
        log.info("controller:/config/getConfig");
        String path="/"+request.getParameter("path");
        String result=configCenter.get(path);
        return AjaxUtil.markSuccess(result);
    }

}
