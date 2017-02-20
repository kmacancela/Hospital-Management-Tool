import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Sibrian on 2/20/17.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PatientRecordsAPIApplication {
    private static Log logger = LogFactory.getLog(PatientRecordsAPIApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PatientRecordsAPIApplication.class, args);
    }

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }
        };
    }
}
