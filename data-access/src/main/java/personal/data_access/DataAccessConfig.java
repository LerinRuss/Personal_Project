package personal.data_access;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "personal.data_access.dao")
@EnableTransactionManagement
public class DataAccessConfig {
}
