package id.my.hendisantika.qrcodegenerator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
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
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.util.Base64Utils.encodeToString;

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

    private QrCodeProcessingResult generateImageAsBase64(String textToBeEncoded) {
        QrCodeProcessingResult result = new QrCodeProcessingResult();
        result.setEncodedText(textToBeEncoded);
        String imageText = "";
        int size = 250;
        String fileType = "png";
        try {
            Map<EncodeHintType, Object> hintMap = createHintMap();
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(textToBeEncoded, BarcodeFormat.QR_CODE, size, size, hintMap);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            String fileName = UUID.randomUUID().toString();
            File myFile = File.createTempFile(fileName, "." + fileType);
            ImageIO.write(image, fileType, myFile);
            byte[] bytes = FileUtils.readFileToByteArray(myFile);
            imageText = "data:image/png;base64," + encodeToString(bytes);
            result.setImage(imageText);
        } catch (WriterException | IOException e) {
            String msg = "Processing QR code failed.";
            log.error(msg, e);
            result.setErrorMessage(msg);
        }
        log.info("QR Code for text {} was successfully created.", textToBeEncoded);
        result.setSuccessMessage("QR Code was successfully created.");
        return result;
    }

    @NotNull
    private Map<EncodeHintType, Object> createHintMap() {
        Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintMap.put(EncodeHintType.MARGIN, 1);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        return hintMap;
    }
}
