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


/*  classes = [MovieReviewResource::class, MovieReviewResourceImp::class,
AddReviewMovieInTheaterUseCases::class, UseCaseExecutorImp::class, JpaReviewRepository::class, DBReviewRepository::class])*/
@ExtendWith(SpringExtension::class)
@RunWith(SpringJUnit4ClassRunner::class)
//@EntityScan(basePackages = ["com.github.clives.dataproviders.db.jpa.entities"])
//@Import(com.github.clives.delivery.config.Module::class)
//@EnableJpaRepositories(basePackages = ["com.github.clives.dataproviders.db.jpa.repositories"])
/*@SpringBootApplication(scanBasePackages = [
    "com.github.clives.delivery.config",
    "com.github.clives.dataproviders.db.jpa.config",
    "com.github.clives.delivery.rest.api.imp",
    "com.github.clives.dataproviders.restclient",
    "com.github.clives.delivery.rest.imp"
])
@TestPropertySource("classpath:test-application.properties")*/
@SpringBootTest(classes = [MovieInTheaterDetailsResource::class])
        class MovieResourceTest {

    @Autowired lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc
/*
    @TestConstructor(autowireMode =  TestConstructor.AutowireMode.ALL)
    internal class LancamentoControllerTest(
            val mockMvc: MockMvc
    ){
*/

    @Before
    fun init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()

    }

    @MockkBean
    lateinit var bankAccountService: MovieInTheaterDetailsResource



    val movieInTheaterDetailsDto: MovieInTheaterDetailsDto   =
            MovieInTheaterDetailsDto("title",
                   "imdb" , emptyList())
    @Test
    fun givenExistingBankAccount_whenGetRequest_thenReturnsBankAccountJsonWithStatus200() {
        every { bankAccountService.getMovieInTheaterDetailsUseCases("tt0232500") } returns CompletableFuture.completedFuture(movieInTheaterDetailsDto)

        println("mockMvc:"+webApplicationContext)
        println("mockMvc:"+mockMvc)
       val result =mockMvc.perform(get("/movie/tt0232500"))
                .andExpect(status().isOk).andReturn()
        val content = result.getResponse().getContentAsString()
        println("content:"+content)
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))

    }



}

