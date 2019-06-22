package nl.zwennesm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

@Configuration
public class CassandraConfiguration extends AbstractReactiveCassandraConfiguration {

    @Value("${cassandra.keyspace}")
    private String keyspace;

    @Value("${cassandra.hostname}")
    private String hostname;

    @Value("${cassandra.username}")
    private String username;

    @Value("${cassandra.password}")
    private String password;

    @Value("${cassandra.port}")
    private Integer port;

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(hostname);
        cluster.setPort(port);
        cluster.setUsername(username);
        cluster.setPassword(password);
        return cluster;
    }

}
