package ui.smartpro.stopwatchcleanmvvm.repository

interface TimestampProvider {
    fun getMilliseconds(): Long
}