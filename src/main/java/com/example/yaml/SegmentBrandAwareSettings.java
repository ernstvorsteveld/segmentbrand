package com.example.yaml;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("test.passwordreset")
public class SegmentBrandAwareSettings {

    private Map<String, Object> settings;

    public void setSettings(Map<String, Object> reason) {
        this.settings = reason;
    }

    public Integer getMyProperty1(String segment, String brand) {
        return getPropertyValue("myproperty1", segment, brand, Integer.class);
    }

    public Integer getMyProperty2(String segment, String brand) {
        return getPropertyValue("myproperty2", segment, brand, Integer.class);
    }

    public Integer getMyProperty3(String segment, String brand) {
        return getPropertyValue("myproperty3", segment, brand, Integer.class);
    }

    public Integer getMyProperty4(String segment, String brand) {
        return getPropertyValue("myproperty4", segment, brand, Integer.class);
    }

    private <T> T getPropertyValue(String name, String segment, String brand, Class<T> clazz) {
        Object value = settings.get(name);
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            return getBySegmentAndBrand(segment, brand, value, clazz);
        } else {
            return clazz.cast(value);
        }
    }

    private <T> T getBySegmentAndBrand(String segment, String brand, Object value, Class<T> clazz) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) value;
            return getByBrand(map.get(segment), brand, clazz);
        } else {
            return clazz.cast(value);
        }
    }

    private <T> T getByBrand(Object value, String brand, Class<T> clazz) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Object brandValue = ((Map<String, Object>) value).get(brand);
            return clazz.cast(brandValue);
        } else {
            return clazz.cast(value);
        }
    }

}
