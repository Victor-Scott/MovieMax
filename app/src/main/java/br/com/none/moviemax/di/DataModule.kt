package br.com.none.moviemax.di

import br.com.none.moviemax.data.api.DiscoverAPI
import br.com.none.moviemax.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesDiscoverAPI(
        serviceProvider: ServiceProvider
    ) : DiscoverAPI{
        return serviceProvider.createService(DiscoverAPI::class.java)
    }
}