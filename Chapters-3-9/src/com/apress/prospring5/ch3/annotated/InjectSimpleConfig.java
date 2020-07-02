package com.apress.prospring5.ch3.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {

    private String name = "John Mayer";
    private int age = 39;
    private float height = 1.92f;
    private boolean programmer = false;
    private Long ageInSeconds = 1_241_401_112L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
