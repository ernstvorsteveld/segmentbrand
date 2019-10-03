package com.example.yaml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationYamlApplication.class})
public class SegmentBrandAwareSettingsTest {

    @Autowired
    private SegmentBrandAwareSettings settings;

    @Test
    public void should_have_settings() {
        assertThat(settings).isNotNull();
        assertThat(settings.getMyProperty1(null, null)).isEqualTo(10);
        assertThat(settings.getMyProperty1("segment1", null)).isEqualTo(10);
        assertThat(settings.getMyProperty1("segment1", "brand1")).isEqualTo(10);
        assertThat(settings.getMyProperty2("segment1", null)).isEqualTo(100);
        assertThat(settings.getMyProperty2("segment1", "brand1")).isEqualTo(100);
        assertThat(settings.getMyProperty3("segment1", "brand1")).isEqualTo(1000);
        assertThat(settings.getMyProperty4("segment1", null)).isNull();
        assertThat(settings.getMyProperty4("segment1", "brand1")).isNull();

        assertThat(settings.getMypropertys1(null, null)).isEqualTo("a string value");
    }

}