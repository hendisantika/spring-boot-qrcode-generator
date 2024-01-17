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

    @Test
    public void thatQrCodeMailIsValidSetter() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        qrCodeEmail.setSubjectToBeEncoded("My Subject");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsNotValidNull() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeMailIsNotValidEmpty() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeEmail);
        assertTrue(bindingResult.hasErrors());
    }
}
