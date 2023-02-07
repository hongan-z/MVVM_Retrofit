package self.tutorial.mvvmrretrofit

import ViewModel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import self.tutorial.mvvmrretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMemeData()
        viewModel.data.observe(this, Observer { list->
            Glide.with(this).load(list.url).into(binding.loadToimageView)
        })

        binding.refreshbtn.setOnClickListener{
            viewModel.getMemeData()
        }
    }
}


