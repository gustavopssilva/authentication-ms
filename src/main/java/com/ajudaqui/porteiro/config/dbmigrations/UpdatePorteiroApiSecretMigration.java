    package com.ajudaqui.porteiro.config.dbmigrations;
    
    import java.time.LocalDateTime;
    
    import com.ajudaqui.porteiro.entity.Applications;
    import org.springframework.data.mongodb.core.MongoTemplate;
    import org.springframework.data.mongodb.core.query.Criteria;
    import org.springframework.data.mongodb.core.query.Query;
    import org.springframework.data.mongodb.core.query.Update;
    
    import io.mongock.api.annotations.ChangeUnit;
    import io.mongock.api.annotations.Execution;
    import io.mongock.api.annotations.RollbackExecution;
    
    @ChangeUnit(id = "update-porteiro-api-secret", order = "004", author = "gustavo")
    public class UpdatePorteiroApiSecretMigration {
    
      private final MongoTemplate mongoTemplate;
    
      public UpdatePorteiroApiSecretMigration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
      }
    
      @Execution
      public void execution() {
        Query query = Query.query(Criteria.where("_id").is("34"));
        Update update = new Update()
            .set("secretId", "ZUr7QywEBwKSHmJ0CRZ+ELFyExfaapAJwkLceCUhOhJ5TjW3ESU76uTuWkayYpQaKFKkqFEyB0lPmeEJpnGvtw==")
            .set("updatedAt", LocalDateTime.now());
    
        mongoTemplate.updateFirst(query, update, Applications.class);
      }
    
      @RollbackExecution
      public void rollback() {
        Query query = Query.query(Criteria.where("_id").is("34"));
        Update update = new Update()
            .set("secretId", "GmL3M1KJFVi7JSHxtrxDKKSNRjjw0NBWHJ3uys6qlxENlCZURgNNxDsN//yGY2die+CnV7MmgeqgzfPKFoo9Gg==")
            .set("updatedAt", LocalDateTime.now());
    
        mongoTemplate.updateFirst(query, update, Applications.class);
      }
    
    }

