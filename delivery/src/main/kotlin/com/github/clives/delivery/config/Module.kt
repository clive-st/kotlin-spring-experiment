package com.github.clives.delivery.config


import com.github.clives.dataproviders.db.jpa.repositories.DBMovieInTheaterRepository
import com.github.clives.dataproviders.db.jpa.repositories.JpaMovieInTheaterRepository
import com.github.clives.dataproviders.db.jpa.repositories.DBShowTimesRepository
import com.github.clives.dataproviders.db.jpa.repositories.JpaShowTimesRepository
import com.github.clives.core.entities.ShowTimes
import com.github.clives.dataproviders.restclient.repositories.RestTemplateMovieDetailsRepository
import com.github.clives.delivery.rest.api.imp.ShowTimesResourceImp
import com.github.clives.usecases.UseCaseExecutor
import com.github.clives.usecases.UseCaseExecutorImp
import com.github.clives.usecases.gateway.MovieDetailsRepository
import com.github.clives.usecases.gateway.MovieInTheaterRepository
import com.github.clives.usecases.gateway.ShowTimesRepository
import com.github.clives.usecases.movieInTheater.GetMovieInTheaterDetailsUseCases
import com.github.clives.usecases.showtimes.FetchShowTimesMovieInTheaterUseCases
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class Module {

    @Bean
    fun showtimesResourceImp(
            useCaseExecutor: UseCaseExecutor,
            fetchShowTimesMovieInTheaterUseCases: FetchShowTimesMovieInTheaterUseCases
    ) = ShowTimesResourceImp(useCaseExecutor, fetchShowTimesMovieInTheaterUseCases)

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun fetchShowTimesMovieInTheaterUseCases(productRepository: ShowTimesRepository) = FetchShowTimesMovieInTheaterUseCases(productRepository)

    @Bean
    fun getMovieInTheaterDetailsUseCases(movieDetailsRepository: MovieDetailsRepository,
                                         movieInTheaterRepository: MovieInTheaterRepository) = GetMovieInTheaterDetailsUseCases(movieInTheaterRepository,movieDetailsRepository)

  //  @Bean
  //  fun createProductUseCase(productRepository: ProductRepository) = CreateProductUseCase(productRepository)

    @Bean
    fun showTimesRepository(dbShowTimesRepository: DBShowTimesRepository) = JpaShowTimesRepository(dbShowTimesRepository)

    @Bean
    fun movieInTheaterRepository(dbMovieInTheaterRepository: DBMovieInTheaterRepository) = JpaMovieInTheaterRepository(dbMovieInTheaterRepository)

    @Bean
    fun getRestTemplate() = RestTemplate()

    @Bean
    fun movieDetailsRepository(restTemplate: RestTemplate) = RestTemplateMovieDetailsRepository(restTemplate)
}