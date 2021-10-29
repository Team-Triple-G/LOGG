package com.ggg.logg.controller;

import com.ggg.logg.controller.MockMvcFilterConfig.MockMVcFilterConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AutoConfigureMockMvc
@Import({
    MockMVcFilterConfig.class,
})
@interface MockMvcFilterConfig {

  class MockMVcFilterConfig {
    @Bean
    MockMvcBuilderCustomizer utf8Config() {
      return builder ->
          builder.addFilters(new CharacterEncodingFilter("UTF-8", true));
    }
  }

}
