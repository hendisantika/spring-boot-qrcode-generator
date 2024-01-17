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
 * Time: 08:52
 * To change this template use File | Settings | File Templates.
 */
class QrCodeEmailParserTest {
    @Test
    public void thatParseEmailPasses() {
        String expected = "mailto:email@email.com";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }

    @Test
    public void thatParseEmailAndSubjectPasses() {
        String expected = "mailto:email@email.com?subject=Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        qrCodeEmail.setSubjectToBeEncoded("Subject");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }
}
