package id.my.hendisantika.qrcodegenerator.controller;

import id.my.hendisantika.qrcodegenerator.config.ApplicationProperties;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import id.my.hendisantika.qrcodegenerator.service.QrCodeEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 08:05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class QrCodeController {

    private final static String PAGE_INDEX = "index";
    private final static String PAGE_RESULT = "result";
    private final static String PAGE_QR_CODE_URL = "qr-code-url";
    private final static String PAGE_QR_CODE_PHONE = "qr-code-phone";
    private final static String PAGE_QR_CODE_FACETIME = "qr-code-facetime";
    private final static String PAGE_QR_CODE_VCARD = "qr-code-vcard";
    private final static String PAGE_QR_CODE_EMAIL = "qr-code-email";
    private final static String PAGE_QR_CODE_SMS = "qr-code-sms";
    private final static String PAGE_QR_CODE_EVENT = "qr-code-event";

    private final static String QR_CODE = "image";
    private final static String TEXT_TO_BE_ENCODED = "text";
    private final static String SUCCESS_MESSAGE = "successMessage";
    private final static String ERROR_MESSAGE = "errorMessage";

    private final ApplicationProperties applicationProperties;
    private final QrCodeEncoder qrCodeEncoder;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        return PAGE_INDEX;
    }

    @GetMapping("/qr-code-url")
    public String qrCodeUrl(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeUrl", new QrCodeUrl());
        return PAGE_QR_CODE_URL;
    }
}
