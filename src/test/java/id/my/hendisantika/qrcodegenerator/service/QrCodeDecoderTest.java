package id.my.hendisantika.qrcodegenerator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 09:12
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class QrCodeDecoderTest {
    @Autowired
    private QrCodeDecoder qrCodeDecoder;

    @Test
    public void thatDecodingQrCodeEmailPasses() throws Exception {
        String expected = "mailto:email@email.com?subject=just%20a%20test";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeEmailAndSubject.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

}
