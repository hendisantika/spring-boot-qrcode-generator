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
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
class QrCodePhoneTest {
    @Test
    public void thatQrCodePhoneIsValid() {
        QrCodePhone qrCodePhone = new QrCodePhone("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodePhoneIsValidSetter() {
        QrCodePhone qrCodePhone = new QrCodePhone();
        qrCodePhone.setPhoneToBeEncoded("+1 555 1234567");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodePhone);
        assertFalse(bindingResult.hasErrors());
    }
}
