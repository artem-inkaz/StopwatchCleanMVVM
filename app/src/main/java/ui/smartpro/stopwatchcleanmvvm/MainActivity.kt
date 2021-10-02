package ui.smartpro.stopwatchcleanmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ui.smartpro.stopwatchcleanmvvm.databinding.ActivityMainBinding
import ui.smartpro.stopwatchcleanmvvm.viewmodel.StopwatchViewModel

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding()
    private val vm by viewModel<StopwatchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observerData()
        viewBinding.buttonStart.setOnClickListener {
            vm.start()
        }
        viewBinding.buttonPause.setOnClickListener {
            vm.pause()
        }
        viewBinding.buttonStop.setOnClickListener {
            vm.stop()
        }
    }

    private fun observerData() {
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        ).launch {
            vm.ticker.collect {
                viewBinding.textTime.text = it
            }
        }
    }
}