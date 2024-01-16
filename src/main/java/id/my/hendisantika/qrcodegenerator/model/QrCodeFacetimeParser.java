package id.my.hendisantika.qrcodegenerator.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:54
 * To change this template use File | Settings | File Templates.
 */
public class QrCodeFacetimeParser extends AbstractQrCodeParser {

    private final QrCodeFacetime qrCodeFacetime;

    public QrCodeFacetimeParser(QrCodeFacetime qrCodeFacetime) {
        this.qrCodeFacetime = qrCodeFacetime;
    }

    @Override
    public String parse() {
        return "facetime://" + this.qrCodeFacetime.getFacetimeToBeEncoded();
    }
}
