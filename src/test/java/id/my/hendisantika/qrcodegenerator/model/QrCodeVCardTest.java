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
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
class QrCodeVCardTest {
    @Test
    public void thatQrCodeVCardIsValid() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertFalse(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidNameNull() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("Norris");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidNameEmpty() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setName("");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidLastNameNull() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname(null);
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }

    @Test
    public void thatQrCodeVCardIsNotValidLastNameEmpty() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setLastname("");
        qrCodeVCard.setName("Chuck");
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeVCard);
        assertTrue(bindingResult.hasErrors());
    }
}
