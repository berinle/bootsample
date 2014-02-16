package sample.domain

import org.springframework.data.elasticsearch.annotations.Document


import groovy.transform.EqualsAndHashCode
import org.springframework.data.annotation.Id

@Document(indexName = "sample", type = "sample")
class Sample {

	@Id
	String id
    String name
    String email
}