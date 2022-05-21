package com.example.caloriescalculator.di

import android.content.Context
import com.example.caloriescalculator.presentation.stat.FavoriteFragment
import com.example.caloriescalculator.presentation.main.MainActivity
import com.example.caloriescalculator.presentation.statistic.StatisticFragment
import com.example.caloriescalculator.presentation.search.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, DatabaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(searchFragment: SearchFragment)
    fun inject(statisticFragment: StatisticFragment)
    fun inject(favoriteFragment: FavoriteFragment)
}