package com.vik.assignmentandroiduae.di

import android.content.Context
import androidx.room.Room
import com.vik.assignmentandroiduae.data.local.UniversityDao
import com.vik.assignmentandroiduae.data.local.UniversityDatabase
import com.vik.assignmentandroiduae.data.remote.UniversityApiService
import com.vik.assignmentandroiduae.data.repository.UniversityRepositoryImpl
import com.vik.assignmentandroiduae.domain.repository.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Context): Context {
        return application
    }

    @Provides
    fun provideUniversityRepository(
        apiService: UniversityApiService,
        database: UniversityDatabase,
    ): UniversityRepository {
        return UniversityRepositoryImpl(apiService, database)
    }

    @Provides
    @Singleton
    fun provideUniversityApi(retrofit: Retrofit): UniversityApiService {
        return retrofit.create(UniversityApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUniversityDao(database: UniversityDatabase): UniversityDao {
        return database.universityDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UniversityDatabase {
        return Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            "app_database"
        ).build()
    }
}
