package com.tools.core.threads;

import lombok.Data;

@Data
public class ThreadsRuntimeConfig {
    private int scrollRetryCount = 3;
    private int scrollRetryInterval = 1000; 
    private int timeOut = 10000; 
    private String inputUsernameXpath;
    private String inputPasswordXpath;
    private String loginButtonXpath;
    private String postCssSelector;
    private String postContentCssSelector;
    private String postImageTagnameSelector;
    private String postVideoCssSelector;

}
