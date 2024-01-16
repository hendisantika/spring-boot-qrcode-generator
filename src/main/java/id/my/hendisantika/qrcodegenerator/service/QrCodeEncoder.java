package id.my.hendisantika.qrcodegenerator.service;

import id.my.hendisantika.qrcodegenerator.model.QrCodeEmail;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEmailParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEvent;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEventParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodeFacetime;
import id.my.hendisantika.qrcodegenerator.model.QrCodeFacetimeParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodePhone;
import id.my.hendisantika.qrcodegenerator.model.QrCodePhoneParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodeProcessingResult;
import id.my.hendisantika.qrcodegenerator.model.QrCodeSms;
import id.my.hendisantika.qrcodegenerator.model.QrCodeSmsParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrlParser;
import id.my.hendisantika.qrcodegenerator.model.QrCodeVCard;
import id.my.hendisantika.qrcodegenerator.model.QrCodeVCardParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:59
 * To change this template use File | Settings | File Templates.
 */
@Component
@Slf4j
public class QrCodeEncoder {
    public QrCodeProcessingResult generateQrCodeUrl(QrCodeUrl qrCodeUrl) {
        String extracted = new QrCodeUrlParser(qrCodeUrl).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeEmail(QrCodeEmail qrCodeEmail) {
        String extracted = new QrCodeEmailParser(qrCodeEmail).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeSms(QrCodeSms qrCodeSms) {
        String extracted = new QrCodeSmsParser(qrCodeSms).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodePhone(QrCodePhone qrCodePhone) {
        String extracted = new QrCodePhoneParser(qrCodePhone).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeEvent(QrCodeEvent qrCodeEvent) {
        String extracted = new QrCodeEventParser(qrCodeEvent).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeFacetime(QrCodeFacetime qrCodeFacetime) {
        String extracted = new QrCodeFacetimeParser(qrCodeFacetime).parse();
        return this.generateImageAsBase64(extracted);
    }

    public QrCodeProcessingResult generateQrCodeVCard(QrCodeVCard qrCodeVCard) {
        String extracted = new QrCodeVCardParser(qrCodeVCard).parse();
        return this.generateImageAsBase64(extracted);
    }
}
