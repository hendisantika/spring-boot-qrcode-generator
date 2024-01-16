package id.my.hendisantika.qrcodegenerator.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:53
 * To change this template use File | Settings | File Templates.
 */

@Getter
@Setter
@Validated
public class QrCodeEvent {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventStart = LocalDateTime.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventEnd = LocalDateTime.now();

    @NotEmpty
    private String summary = "";

    private String location = "";

    public QrCodeEvent(LocalDateTime eventStart, LocalDateTime eventEnd, String summary, String location) {
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.summary = summary;
        this.location = location;
    }

    public QrCodeEvent() {
    }
}
