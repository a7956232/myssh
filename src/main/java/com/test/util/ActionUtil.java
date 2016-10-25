package com.test.util;

import com.opensymphony.xwork2.ActionContext;

/**
 * Created by 95 on 2016/10/25.
 */
public class ActionUtil {
    public static final String REDIRECT = "redirect";

    public static void setUrl(String url){
        ActionContext.getContext().put("url",url);
    }
}
