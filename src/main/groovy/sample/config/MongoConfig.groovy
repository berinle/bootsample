package sample.config

import com.mongodb.Mongo
import com.mongodb.WriteConcern
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.authentication.UserCredentials
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@ComponentScan("sample")
@Configuration
@EnableMongoRepositories
class MongoConfig extends AbstractMongoConfiguration {

    @Value("\${MDB_HOST}")
    String host
    @Value("\${MDB_PORT}")
    Integer port
    @Value("\${MDB_DBNAME}")
    String databaseName
    @Value("\${MDB_USER}")
    String userName
    @Value("\${MDB_PASS}")
    String password

    @Override
    Mongo mongo() throws Exception {
        def mongo = new Mongo(host, port)
        mongo.writeConcern = WriteConcern.SAFE
        mongo
    }

    @Override
    protected UserCredentials getUserCredentials() {
        new UserCredentials(userName, password)
    }
}
