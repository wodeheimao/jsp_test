package com.hu.proper;
import java.io.IOException;
import java.io.InputStream;
import	java.util.Properties;

public class BeanFactory {
    private static  Properties props;

    static {
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        System.out.println("beanPath = " + beanPath);
        try {
            bean = Class.forName(beanPath).newInstance();
            System.out.println("bean = " + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
