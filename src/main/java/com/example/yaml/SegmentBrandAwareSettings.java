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
        return getPropertyValue(Properties.Property1, segment, brand);
    }

    public Integer getMyProperty2(String segment, String brand) {
        return getPropertyValue(Properties.Property2, segment, brand);
    }

    public Integer getMyProperty3(String segment, String brand) {
        return getPropertyValue(Properties.Property3, segment, brand);
    }

    public Integer getMyProperty4(String segment, String brand) {
        return getPropertyValue(Properties.Property4, segment, brand);
    }

    public String getMypropertys1(String segment, String brand) {
        return getPropertyValue(Properties.PropertyS1, segment, brand);
    }

    private <T> T getPropertyValue(Properties propertiy, String segment, String brand) {
        Object value = settings.get(propertiy.getPropertyName());
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            return getBySegmentAndBrand(segment, brand, value);
        } else {
            return (T) value;
        }
    }

    private <T> T getBySegmentAndBrand(String segment, String brand, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) value;
            return getByBrand(map.get(segment), brand);
        } else {
            return (T) value;
        }
    }

    private <T> T getByBrand(Object value, String brand) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Object brandValue = ((Map<String, Object>) value).get(brand);
            return (T) brandValue;
        } else {
            return (T) value;
        }
    }

    private enum Properties {
        Property1("myproperty1"),
        Property2("myproperty2"),
        Property3("myproperty3"),
        Property4("myproperty4"),
        PropertyS1("mypropertys1");

        private String propertyName;

        Properties(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getPropertyName() {
            return propertyName;
        }

    }
}
