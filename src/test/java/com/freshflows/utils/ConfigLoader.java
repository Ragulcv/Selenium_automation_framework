package com.freshflows.utils;

import com.freshflows.constants.EnvType;

import java.util.Properties;

public class ConfigLoader   {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.QA));
        switch (EnvType.valueOf(env)){
            case QA ->properties = PropertyUtils.propertyLoader("src/test/resources/QA_config.properties");
            case STAGING -> properties = PropertyUtils.propertyLoader("src/test/resources/staging_config.properties");
            default -> throw new IllegalStateException("Invalid env type:  " + env);
        }

    }
    public static ConfigLoader getInstance(){
        if(configLoader ==null)
        {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    String key;
    public String getbaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null)  return prop;
        else throw new RuntimeException("Property "+key+" is not specified in the staging_config.properties file");
    }

    public String getadminUser(){
        String prop = properties.getProperty("adminUser");
        if(prop != null)  return prop;
        else throw new RuntimeException("Property "+key+" is not specified in the staging_config.properties file");
    }

    public String getadminPwd(){
        String prop = properties.getProperty("adminPwd");
        if(prop != null)  return prop;
        else throw new RuntimeException("Property "+key+" is not specified in the staging_config.properties file");
    }

    public String getdomain(String key){
        String prop = properties.getProperty("domain");
        if(prop != null)  return prop;
        else throw new RuntimeException("Property "+key+" is not specified in the staging_config.properties file");
    }
}
