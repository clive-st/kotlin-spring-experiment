import com.fasterxml.jackson.annotation.JsonProperty
import com.github.clives.delivery.App
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@ExtendWith(SpringExtension::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class],  webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    data class ResponseMovieDetailsImdb(
            @JsonProperty("imdbID")
            val imdbID: String,
            @JsonProperty("title")
            val Title: String
    )

    @Test
    fun whenGetMovieDetailsCalled_thenShouldReturnMovieDetail() {
        val result = restTemplate.getForEntity("/movie/tt0232500", ResponseMovieDetailsImdb::class.java);
        println(result.body)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertEquals(result.body.imdbID,"tt0232500" )
    }
}