    package com.lapots.tree.model.repository.context;

    import org.neo4j.ogm.config.Configuration;
    import org.neo4j.ogm.session.SessionFactory;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.core.env.Environment;
    import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
    import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
    import org.springframework.transaction.annotation.EnableTransactionManagement;


    @EnableTransactionManagement
    @ComponentScan("com.lapots.tree.model")
    @EnableNeo4jRepositories(basePackages = { "com.lapots.tree.model.repository" })
    public class Neo4jPersistenceContext {
        private static final Logger LOGGER = LoggerFactory.getLogger(Neo4jPersistenceContext.class);

        @Autowired
        private Environment env;

        @Bean
        public SessionFactory sessionFactory() {
            LOGGER.info("Creating session factory for remote Neo4J instance.");
            Configuration configuration = new Configuration.Builder()
                    .uri(env.getProperty("spring.data.neo4j.uri"))
                    .credentials(env.getProperty("spring.data.neo4j.username"),
                            env.getProperty("spring.data.neo4j.password"))
                    .build();
            return new SessionFactory(configuration, "com.lapots.tree.model.domain.graph");
        }

        @Bean
        public Neo4jTransactionManager transactionManager() {
            return new Neo4jTransactionManager(sessionFactory());
        }
    }
