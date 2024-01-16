package id.my.hendisantika.qrcodegenerator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:51
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@Component
@Getter
@Setter
public class ApplicationProperties {
    private String title;
    private String appInfo;
}
