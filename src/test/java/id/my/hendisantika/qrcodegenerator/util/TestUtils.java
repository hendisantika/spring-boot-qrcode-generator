package id.my.hendisantika.qrcodegenerator.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.support.BindingAwareModelMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/17/24
 * Time: 08:55
 * To change this template use File | Settings | File Templates.
 */
public class TestUtils {
    private static final LocalValidatorFactoryBean LOCAL_VALIDATOR_FACTORY_BEAN = createLocalValidatorFactoryBean();

    private TestUtils() {
    }

    private static LocalValidatorFactoryBean createLocalValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    public static BindingResult createBindingResult(Object qrCodeModel) {
        DataBinder dataBinder = new DataBinder(qrCodeModel);
        dataBinder.setValidator(LOCAL_VALIDATOR_FACTORY_BEAN);
        dataBinder.validate();
        return dataBinder.getBindingResult();
    }

    public static BindingAwareModelMap createModel() {
        return new BindingAwareModelMap();
    }
}
