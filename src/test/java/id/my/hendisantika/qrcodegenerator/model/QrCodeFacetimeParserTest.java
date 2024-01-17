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
 * Time: 08:56
 * To change this template use File | Settings | File Templates.
 */
class QrCodeFacetimeParserTest {
    @Test
    public void thatParseFacetimePasses() {
        String expected = "facetime://+49555123456";
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime("+49555123456");
        assertEquals(expected, new QrCodeFacetimeParser(qrCodeFacetime).parse());
    }
}
