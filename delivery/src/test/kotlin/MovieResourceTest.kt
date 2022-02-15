import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.dataproviders.db.jpa.config.DBConfig
import com.github.clives.dataproviders.db.jpa.repositories.DBReviewRepository
import com.github.clives.dataproviders.db.jpa.repositories.JpaReviewRepository
import com.github.clives.delivery.rest.api.MovieInTheaterDetailsDto
import com.github.clives.delivery.rest.api.MovieInTheaterDetailsResource
import com.github.clives.delivery.rest.api.MovieReviewResource
import com.github.clives.delivery.rest.api.imp.MovieReviewResourceImp
import com.github.clives.usecases.UseCaseExecutorImp
import com.github.clives.usecases.userreview.AddReviewMovieInTheaterUseCases
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import  org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.ResultActions
import java.util.concurrent.CompletableFuture

@ExtendWith(SpringExtension::class)
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MovieInTheaterDetailsResource::class])
        class MovieResourceTest {

    @Autowired lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()
    }

    @MockkBean
    lateinit var movieInTheaterDetailsResource: MovieInTheaterDetailsResource

    val movieInTheaterDetailsDto: MovieInTheaterDetailsDto   =
            MovieInTheaterDetailsDto("title",
                   "imdb" , emptyList())
    @Test
    fun givenExistingMovie_whenGetRequest_thenReturnsMovieDetailsWithStatus200() {
        val imdb = "tt0232500"
        every { movieInTheaterDetailsResource.getMovieInTheaterDetailsUseCases(imdb) } returns CompletableFuture.completedFuture(movieInTheaterDetailsDto)

       val result =mockMvc.perform(get("/movie/$imdb"))
                .andExpect(status().isOk).andReturn()
    }
}

