package id.my.hendisantika.qrcodegenerator.model;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 08:53
 * To change this template use File | Settings | File Templates.
 */
class QrCodeEmailTest {
    @Test
    public void thatQrCodeMailIsValid() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertFalse(bindingResult.hasErrors());
    }
}
