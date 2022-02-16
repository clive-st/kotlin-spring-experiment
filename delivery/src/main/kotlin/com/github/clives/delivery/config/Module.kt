package com.github.clives.delivery.config


import com.github.clives.dataproviders.db.jpa.repositories.*
import com.github.clives.dataproviders.restclient.repositories.ApiKeyInterceptor
import com.github.clives.dataproviders.restclient.repositories.RestTemplateMovieDetailsRepository
import com.github.clives.delivery.rest.api.imp.MovieInTheaterDetailsResourceImp
import com.github.clives.delivery.rest.api.imp.MovieReviewResourceImp
import com.github.clives.delivery.rest.api.imp.ShowTimesResourceImp
import com.github.clives.usecases.UseCaseExecutor
import com.github.clives.usecases.UseCaseExecutorImp
import com.github.clives.usecases.gateway.MovieDetailsRepository
import com.github.clives.usecases.gateway.MovieInTheaterRepository
import com.github.clives.usecases.gateway.ReviewRepository
import com.github.clives.usecases.gateway.ShowTimesRepository
import com.github.clives.usecases.movieInTheater.GetMovieInTheaterDetailsUseCases
import com.github.clives.usecases.showtimes.FetchShowTimesMovieInTheaterUseCases
import com.github.clives.usecases.userreview.AddReviewMovieInTheaterUseCases
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Description
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.util.concurrent.TimeUnit

@Configuration
class Module {

    @Bean
    fun showtimesResourceImp(
            useCaseExecutor: UseCaseExecutor,
            fetchShowTimesMovieInTheaterUseCases: FetchShowTimesMovieInTheaterUseCases
    ) = ShowTimesResourceImp(useCaseExecutor, fetchShowTimesMovieInTheaterUseCases)


    @Bean
    fun movieInTheaterDetailsResourceImp(
            useCaseExecutor: UseCaseExecutor,
            getMovieInTheaterDetailsUseCases: GetMovieInTheaterDetailsUseCases
    ) = MovieInTheaterDetailsResourceImp(useCaseExecutor, getMovieInTheaterDetailsUseCases)

    @Bean
    fun movieReviewResourceImp(
            useCaseExecutor: UseCaseExecutor,
            addReviewMovieInTheaterUseCases: AddReviewMovieInTheaterUseCases
    ) = MovieReviewResourceImp(useCaseExecutor, addReviewMovieInTheaterUseCases)

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun fetchShowTimesMovieInTheaterUseCases(productRepository: ShowTimesRepository) = FetchShowTimesMovieInTheaterUseCases(productRepository)

    @Bean
    fun getMovieInTheaterDetailsUseCases(movieDetailsRepository: MovieDetailsRepository,
                                         movieInTheaterRepository: MovieInTheaterRepository) = GetMovieInTheaterDetailsUseCases(movieInTheaterRepository, movieDetailsRepository)

    @Bean
    fun insertUserReview(reviewRepository: ReviewRepository) = AddReviewMovieInTheaterUseCases(reviewRepository)

    @Bean
    fun showTimesRepository(dbShowTimesRepository: DBShowTimesRepository) = JpaShowTimesRepository(dbShowTimesRepository)

    @Bean
    fun ReviewRepository(dbReviewRepository: DBReviewRepository) = JpaReviewRepository(dbReviewRepository)

    @Bean
    fun movieInTheaterRepository(dbMovieInTheaterRepository: DBMovieInTheaterRepository) = JpaMovieInTheaterRepository(dbMovieInTheaterRepository)

    @Bean
    @Description("RestTemplate connection with predefined auth headers")
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate();

        val HTTP_MAX_IDLE = 20
        val HTTP_KEEP_ALIVE = 20L
        val HTTP_CONNECTION_TIMEOUT = 30L

        val builder = OkHttpClient.Builder();
        val okHttpConnectionPool = ConnectionPool(HTTP_MAX_IDLE, HTTP_KEEP_ALIVE,
                TimeUnit.SECONDS);
        builder.connectionPool(okHttpConnectionPool);
        builder.connectTimeout(HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);

        builder.addInterceptor(ApiKeyInterceptor())

        restTemplate.setRequestFactory(OkHttp3ClientHttpRequestFactory(builder.build()));

        return restTemplate;
    }

    @Bean
    fun movieDetailsRepository(restTemplate: RestTemplate) = RestTemplateMovieDetailsRepository(restTemplate)
}