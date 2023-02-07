package self.tutorial.mvvmrretrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import self.tutorial.mvvmrretrofit.databinding.ActivityCoroutineBinding

class CoroutineActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineBinding

    lateinit var counter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.countButton.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")
            override fun onClick(v: View?) {
                Log.d("Thread", Thread.currentThread().name)
                binding.tvCounter.text = "${Integer.parseInt(binding.tvCounter.text.toString()) + 1}"

            }
        })

        binding.task
    }

    suspend fun fun1() {
        Log.d("Function1", "Function1 Start")
        delay(1000)
        Log.d("Function1", "Function1 Start")
    }

    suspend fun fun2() {
        Log.d("Function2", "Function2 Start")
        delay(3000)
        Log.d("Function2", "Function2 Start")
    }

    fun longRunningTask(view: View) {

        // context (Dispatcher.IO) which thread coroutines will launch
        CoroutineScope(Dispatchers.IO).launch {
            fun1()
            Log.d("thread fun1", Thread.currentThread().name)
        }

        CoroutineScope(Dispatchers.IO).launch {
            fun2()
            Log.d("thread fun2", Thread.currentThread().name)
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("thread main", Thread.currentThread().name)
        }
    }

//    @SuppressLint("SetTextI18n")
//    fun counterOnClick(view: View) {
//        Log.d("Thread", Thread.currentThread().name)
//        binding.tvCounter.text = "${Integer.parseInt(binding.tvCounter.text.toString()) + 1}"
//
//    }


}

//private fun Button.setOnClickListener() {
//   Log.d("Thread", Thread.currentThread().name)
//
//}
