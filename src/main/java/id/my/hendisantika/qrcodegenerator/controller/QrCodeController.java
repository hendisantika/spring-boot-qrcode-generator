package id.my.hendisantika.qrcodegenerator.controller;

import id.my.hendisantika.qrcodegenerator.config.ApplicationProperties;
import id.my.hendisantika.qrcodegenerator.model.QrCodeEmail;
import id.my.hendisantika.qrcodegenerator.model.QrCodeFacetime;
import id.my.hendisantika.qrcodegenerator.model.QrCodePhone;
import id.my.hendisantika.qrcodegenerator.model.QrCodeProcessingResult;
import id.my.hendisantika.qrcodegenerator.model.QrCodeSms;
import id.my.hendisantika.qrcodegenerator.model.QrCodeUrl;
import id.my.hendisantika.qrcodegenerator.service.QrCodeEncoder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/process/url")
    public String processUrl(Model model,
                             @Valid @ModelAttribute("qrCodeUrl") QrCodeUrl qrCodeUrl,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Url {}", qrCodeUrl.getUrlToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_URL;
    }

    @GetMapping("/qr-code-phone")
    public String qrCodePhone(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodePhone", new QrCodePhone());
        return PAGE_QR_CODE_PHONE;
    }

    @GetMapping("/qr-code-facetime")
    public String qrCodeFacetime(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeFacetime", new QrCodeFacetime());
        return PAGE_QR_CODE_FACETIME;
    }

    @PostMapping("/process/phone")
    public String processPhone(Model model,
                               @Valid @ModelAttribute("qrCodePhone") QrCodePhone qrCodePhone,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Phone number {}", qrCodePhone.getPhoneToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_PHONE;
    }

    @PostMapping("/process/facetime")
    public String processFacetime(Model model,
                                  @Valid @ModelAttribute("qrCodeFacetime") QrCodeFacetime qrCodeFacetime,
                                  BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Facetime number {}", qrCodeFacetime.getFacetimeToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeFacetime(qrCodeFacetime);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_FACETIME;
    }

    @GetMapping("/qr-code-email")
    public String qrCodeEmail(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEmail", new QrCodeEmail());
        return PAGE_QR_CODE_EMAIL;
    }

    @PostMapping("/process/email")
    public String processEmail(Model model,
                               @Valid @ModelAttribute("qrCodeEmail") QrCodeEmail qrCodeEmail,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeEmail.getEmailToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_EMAIL;
    }

    @GetMapping("/qr-code-sms")
    public String qrCodeSms(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeSms", new QrCodeSms());
        return PAGE_QR_CODE_SMS;
    }

}
