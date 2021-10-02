package ui.smartpro.stopwatchcleanmvvm.di

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ui.smartpro.stopwatchcleanmvvm.repository.*
import ui.smartpro.stopwatchcleanmvvm.viewmodel.StopwatchViewModel

val appModule = module {

    single { StopwatchStateHolder(get(), get(), get()) }
    single { StopwatchStateCalculator(get(), get()) }
    single { ElapsedTimeCalculator(get()) }
    single<TimestampProvider> { TimestampProviderImpl() }
    single { TimestampMillisecondsFormatter() }
    viewModel { StopwatchViewModel(get()) }
}