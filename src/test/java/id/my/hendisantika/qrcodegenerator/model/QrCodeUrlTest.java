package id.my.hendisantika.qrcodegenerator.model;

import id.my.hendisantika.qrcodegenerator.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 09:07
 * To change this template use File | Settings | File Templates.
 */
class QrCodeUrlTest {
    @Test
    public void thatQrCodeUrlIsValid() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeUrlIsValidSetter() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl();
        qrCodeUrl.setUrlToBeEncoded("http://www.google.com");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeUrlIsNotValidNull() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        assertTrue(bindingResult.hasErrors());
    }
}
