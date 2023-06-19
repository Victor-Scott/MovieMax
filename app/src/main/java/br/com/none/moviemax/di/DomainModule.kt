package br.com.none.moviemax.di

import br.com.none.moviemax.data.DiscoverRepository
import br.com.none.moviemax.data.model.DiscoveryRepositoryImpl
import br.com.none.moviemax.domain.GetMoviesUseCase
import br.com.none.moviemax.domain.GetMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsDiscoverRepository(
        discoveryRepositoryImpl: DiscoveryRepositoryImpl
    ): DiscoverRepository

    @Binds
    abstract fun bindsGetMoviesUseCase(
        getMoviesUseCaseImpl: GetMoviesUseCaseImpl
    ): GetMoviesUseCase
}