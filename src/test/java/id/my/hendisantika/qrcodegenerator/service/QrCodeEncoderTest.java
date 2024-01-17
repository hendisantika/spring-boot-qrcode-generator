package id.my.hendisantika.qrcodegenerator.service;

import id.my.hendisantika.qrcodegenerator.model.QrCodeEmail;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEnumType;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEvent;
import id.my.hendisantika.qrcodegenerator.model.QrCodePhone;
import id.my.hendisantika.qrcodegenerator.model.QrCodeProcessingResult;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import id.my.hendisantika.qrcodegenerator.model.QrCodeVCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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

    @Test
    public void generateQrCodeVCard() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setTitle("Mr. Roundhousekick");
        qrCodeVCard.setOrganisation("My Organisation");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeVCard(qrCodeVCard);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    void generateQrCodeEvent() {
        QrCodeEvent qrCodeEvent = new QrCodeEvent();
        qrCodeEvent.setLocation("Konoha");
        qrCodeEvent.setSummary("Hokage");
        qrCodeEvent.setEventStart(LocalDateTime.now());
        qrCodeEvent.setEventEnd(LocalDateTime.now().plusHours(4));
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEvent(qrCodeEvent);
        assertTrue(result.isSuccessfull());
    }

    @Test
    public void generateQrCodeVCardComplete() {
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setTitle("Mr. Roundhousekick");
        qrCodeVCard.setOrganisation("My Organisation");
        qrCodeVCard.setEmail1("chuck@norris.com");
        qrCodeVCard.setEmail2("chuck@gmail.com");
        qrCodeVCard.setAdress1Street("42 Plantation St.");
        qrCodeVCard.setAdress1Locality("Baytown");
        qrCodeVCard.setAdress1Region("LA");
        qrCodeVCard.setAdress1PostalCode("30314");
        qrCodeVCard.setAdress1Country("USA");
        qrCodeVCard.setAdress1Type(QrCodeEnumType.HOME);
        qrCodeVCard.setPhone1("+15551234567");
        qrCodeVCard.setPhone1Type(QrCodeEnumType.WORK);
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeVCard(qrCodeVCard);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }
}
