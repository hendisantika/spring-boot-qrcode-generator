package id.my.hendisantika.qrcodegenerator.model;

import id.my.hendisantika.qrcodegenerator.util.TestUtils;
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
 * Time: 09:05
 * To change this template use File | Settings | File Templates.
 */
class QrCodeSmsTest {
    @Test
    public void thatQrCodeSmsIsValid() {
        QrCodeSms qrCodeSms = new QrCodeSms("+49123456789");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeSms);
        assertFalse(bindingResult.hasErrors());
    }
}
