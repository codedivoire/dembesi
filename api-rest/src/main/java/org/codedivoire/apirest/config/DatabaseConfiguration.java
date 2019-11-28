package org.codedivoire.apirest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configure les convertisseurs de dates pour utiliser le format ISO pour les dates par défaut.
 * @author Christian Amani
 */
@Configuration
@EnableJpaRepositories("org.codedivoire.apirest.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfiguration {

}
