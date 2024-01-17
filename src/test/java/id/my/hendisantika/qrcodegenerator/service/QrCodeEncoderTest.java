package id.my.hendisantika.qrcodegenerator.service;

import id.my.hendisantika.qrcodegenerator.model.QrCodeEmail;
import id.my.hendisantika.qrcodegenerator.model.QrCodePhone;
import id.my.hendisantika.qrcodegenerator.model.QrCodeProcessingResult;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class QrCodeEncoderTest {
    @Autowired
    private QrCodeEncoder qrCodeEncoder;

    @Test
    public void generateQrCodeUrl() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodeEmail() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodeEmailAndSubject() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com", "just a test");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodePhone() {
        QrCodePhone qrCodePhone = new QrCodePhone("+15551234567");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }
}
