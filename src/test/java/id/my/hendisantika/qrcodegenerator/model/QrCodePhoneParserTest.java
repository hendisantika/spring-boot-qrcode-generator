package id.my.hendisantika.qrcodegenerator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
class QrCodePhoneParserTest {
    @Test
    public void thatParsePhonePasses() {
        String expected = "tel:+495551234567";
        QrCodePhone qrCodePhone = new QrCodePhone("+495551234567");
        assertEquals(expected, new QrCodePhoneParser(qrCodePhone).parse());
    }
}
