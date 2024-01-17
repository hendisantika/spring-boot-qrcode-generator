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
 * Time: 09:06
 * To change this template use File | Settings | File Templates.
 */
class QrCodeUrlParserTest {
    @Test
    public void thatParseUrlPasses() {
        String expected = "http://www.google.com";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }

    @Test
    public void thatParseUrlWithBlanksPasses() {
        String expected = "http://www.google.com?value=My%20Site";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com?value=My%20Site");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }
}
