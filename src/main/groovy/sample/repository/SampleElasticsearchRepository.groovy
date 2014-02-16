package sample.repository


import sample.domain.Sample
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface SampleElasticsearchRepository extends ElasticsearchRepository<Sample, String>{
}