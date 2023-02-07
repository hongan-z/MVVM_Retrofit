package self.tutorial.mvvmrretrofit

import Models.zenModelItem
import ViewModel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import self.tutorial.mvvmrretrofit.databinding.ActivityZenBinding

class ZenActivity : AppCompatActivity() {
    lateinit var binding: ActivityZenBinding

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getZen()
        viewModel.allUsersListFromZenList.observe(this){list->
            setAapter(list)
        }
    }

    private fun setAapter(zenModelItems: List<zenModelItem>?) {
        TODO("Not yet implemented")
    }


}



