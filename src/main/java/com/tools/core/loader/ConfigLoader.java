package com.tools.core.loader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tools.core.model.ThreadsToolConfig;

public class ConfigLoader implements IConfigLoader {

    private static ConfigLoader instance;
    private ConfigLoader() {
        // Private constructor to prevent instantiation
    }
    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    @Override
    public ThreadsToolConfig loadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ThreadsToolConfig config = mapper.readValue(new File("config.json"), ThreadsToolConfig.class);
            return config;
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
