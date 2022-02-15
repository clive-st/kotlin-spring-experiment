import com.github.clives.delivery.rest.api.MovieInTheaterDetailsDto
import com.github.clives.delivery.rest.api.MovieInTheaterDetailsResource
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.concurrent.CompletableFuture

@ExtendWith(SpringExtension::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MovieInTheaterDetailsResource::class])
class MovieResourceTest {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()
    }

    @MockkBean
    lateinit var movieInTheaterDetailsResource: MovieInTheaterDetailsResource

    val movieInTheaterDetailsDto: MovieInTheaterDetailsDto =
            MovieInTheaterDetailsDto("title",
                    "imdb", emptyList())

    @Test
    fun givenExistingMovie_whenGetRequest_thenReturnsMovieDetailsWithStatus200() {
        val imdb = "tt0232500"
        every { movieInTheaterDetailsResource.getMovieInTheaterDetailsUseCases(imdb) } returns CompletableFuture.completedFuture(movieInTheaterDetailsDto)

        val result = mockMvc.perform(get("/movie/$imdb"))
                .andExpect(status().isOk).andReturn()
    }
}

