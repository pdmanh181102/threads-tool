package com.tools;

import com.tools.core.model.ThreadsToolConfig;

import lombok.Data;

@Data
public class AppContext {

    /**
     * Singleton instance of AppContext.
     */
    private static AppContext instance;
    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public ThreadsToolConfig config;
}
