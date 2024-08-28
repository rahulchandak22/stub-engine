import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    @Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        return kieServices.getKieClasspathContainer();
    }

    @Bean
    public KieSession getKieSession(String productType) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        KieSession kieSession;
        if ("ProductA".equals(productType)) {
            kieSession = kieContainer.newKieSession("ksession-productA");
        } else if ("ProductB".equals(productType)) {
            kieSession = kieContainer.newKieSession("ksession-productB");
        } else {
            throw new IllegalArgumentException("Unknown product type: " + productType);
        }
        return kieSession;
    }
}
