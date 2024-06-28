package com.sakura.sakuraapiclientsdk;

import com.sakura.sakuraapiclientsdk.client.sakuraapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * sakuraapi 客户端配置
 */
@Configuration
@ConfigurationProperties("sakuraapi.client")
@Data
@ComponentScan
public class sakuraapiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public sakuraapiClient sakuraapiClient() {
        return new sakuraapiClient(accessKey, secretKey);
    }

}
