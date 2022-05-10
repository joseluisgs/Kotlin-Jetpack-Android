package es.joseluisgs.jetpacktutorial.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.joseluisgs.jetpacktutorial.apis.FilmsApiClient
import es.joseluisgs.jetpacktutorial.apis.FilmsRest
import es.joseluisgs.jetpacktutorial.database.FilmsDao
import es.joseluisgs.jetpacktutorial.database.FilmsDb
import javax.inject.Singleton

/**
 * Module for providing dependencies at the application level.
 */
@Module
@InstallIn(SingletonComponent::class) // El alcance de la dependencia es de una sola instancia
class AppModule {
    // Los servicios serán singleton porque se instancian una sola vez en la aplicación

    @Singleton
    @Provides
    fun provideApiServiceClient(): FilmsRest =
        FilmsApiClient.getInstance()

    @Singleton
    @Provides
    fun provideDbClient(application: Application): FilmsDao =
        Room
            .databaseBuilder(application, FilmsDb::class.java, "films")
            .build()
            .filmDao()
}
