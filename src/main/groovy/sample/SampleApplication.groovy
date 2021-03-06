/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.data.MongoRepositoriesAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.elasticsearch.node.NodeBuilder.nodeBuilder

@Configuration
@EnableAutoConfiguration(exclude = MongoRepositoriesAutoConfiguration)
@RestController
@EnableElasticsearchRepositories(basePackages = "sample.repository")
@EnableMongoRepositories(basePackages = "mongo.repository")
@ComponentScan
class SampleApplication {

	@Bean
    ElasticsearchOperations elasticsearchTemplate(){
        new ElasticsearchTemplate(nodeBuilder().local(true).node().client())
    }

	@RequestMapping("/")
	def helloWorld() {
		[message: "Hello World"]
	}

	static void main(String[] args) throws Exception {
		SpringApplication.run(SampleApplication.class, args)
	}

}
