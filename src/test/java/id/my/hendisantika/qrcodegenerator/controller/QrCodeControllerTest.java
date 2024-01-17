package id.my.hendisantika.qrcodegenerator.controller;

import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import id.my.hendisantika.qrcodegenerator.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 09:19
 * To change this template use File | Settings | File Templates.
 */

@SpringBootTest
class QrCodeControllerTest {
    @Autowired
    private QrCodeController qrCodeController;

    @Test
    public void thatIndexPasses() {
        String expected = "index";
        String actual = this.qrCodeController.index(TestUtils.createModel());
        assertEquals(expected, actual);
    }

    @Test
    public void thatQrCodeUrlPasses() {
        String expected = "qr-code-url";
        BindingAwareModelMap model = TestUtils.createModel();
        String actual = this.qrCodeController.qrCodeUrl(model);
        assertEquals(expected, actual);
        assertNotNull(model.get("qrCodeUrl"));
    }

    @Test
    public void thatProcessQrCodeUrlPasses() {
        String expected = "result";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        String actual = this.qrCodeController.processUrl(model, qrCodeUrl, bindingResult);
        assertEquals(expected, actual);
        assertNotNull(model.get("image"));
        assertNull(model.get("qrCodeUrl"));
    }

    @Test
    public void thatProcessQrCodeUrlFails() {
        String expected = "qr-code-url";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("");
        BindingAwareModelMap model = TestUtils.createModel();
        BindingResult bindingResult = TestUtils.createBindingResult(qrCodeUrl);
        String actual = this.qrCodeController.processUrl(model, qrCodeUrl, bindingResult);
        assertEquals(expected, actual);
        assertNull(model.get("image"));
        assertNull(model.get("qrCodeUrl"));
    }
}
