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
 * Time: 09:03
 * To change this template use File | Settings | File Templates.
 */
class QrCodeSmsParserTest {
    @Test
    public void thatParseSmsPasses() {
        String expected = "sms:+49123456789";
        QrCodeSms qrCodeSms = new QrCodeSms();
        qrCodeSms.setPhoneToBeEncoded("+49123456789");
        assertEquals(new QrCodeSmsParser(qrCodeSms).parse(), expected);
    }
}
