package controllers;

import org.springframework.context.ApplicationContext;

public class AppConfig {

    private static ApplicationContext appConfiguration;
    public static void setApplicationConfig(ApplicationContext appConfig) {
        appConfiguration = appConfig;
    }
    
    public static ApplicationContext getApplicationConfig() {
        return appConfiguration;
    }
    
    public static <A> A getControllerInstance(Class<A> type) throws Exception {
        return appConfiguration.getBean(type);
  }
}
