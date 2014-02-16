package sample

import org.junit.Before
import org.junit.Test
import sample.domain.Sample
import sample.repository.SampleElasticsearchRepository

class SampleRepositoryTest extends BaseTest {

    static SampleElasticsearchRepository sampleElasticsearchRepository

    @Before
    public void emptyData(){
        sampleElasticsearchRepository = context.getBean(SampleElasticsearchRepository.class)
        sampleElasticsearchRepository.deleteAll()
    }


    @Test
    public void testIndexing(){
        Sample sample = new Sample(id: "123", name:  "Lucy Lu", email: "lucylu@me.com")

        //should index
        sampleElasticsearchRepository.save(sample)

        //try search
        def indexedSample = sampleElasticsearchRepository.findOne(sample.id)
        indexedSample.email == sample.email
        indexedSample.name == sample.name
    }


}
