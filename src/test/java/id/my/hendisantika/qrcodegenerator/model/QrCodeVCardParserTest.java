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
 * Time: 09:08
 * To change this template use File | Settings | File Templates.
 */
class QrCodeVCardParserTest {
    @Test
    public void thatParseVCardCanPasses() {
        String expected = "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                "N:Norris;Chuck;;;\n" +
                "FN:Chuck Norris\n" +
                "TITLE:Mr. Roundhousekick\n" +
                "END:VCARD";
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setTitle("Mr. Roundhousekick");
        String actual = new QrCodeVCardParser(qrCodeVCard).parse();
        assertEquals(expected, actual);
    }
}
