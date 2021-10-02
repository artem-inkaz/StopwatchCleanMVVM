package ui.smartpro.stopwatchcleanmvvm.repository

class TimestampProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}