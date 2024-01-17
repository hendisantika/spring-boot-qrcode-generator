package id.my.hendisantika.qrcodegenerator.config;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 08:51
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
public class ApplicationPropertiesTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    public void thatTitleIsValid() {
        String actual = this.applicationProperties.getTitle();
        assertNotNull(actual);
        assertTrue(StringUtils.isNotEmpty(actual));
    }
}
