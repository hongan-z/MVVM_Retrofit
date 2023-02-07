package self.tutorial.mvvmrretrofit

import Adapter.TodoListAdapter
import Models.todosModelItem
import ViewModel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import self.tutorial.mvvmrretrofit.databinding.ActivityMainTodosBinding


class MainActivityTodos : AppCompatActivity() {

    lateinit var binding: ActivityMainTodosBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTodosBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        viewModel.getTodoData()
//        viewModel.todoData.observe(this, Observer { list->
//            setAdapter(list)
//        })

        viewModel.get()
        viewModel.allUsersList.observe(this) { list ->
            setAdapter(list)
        }


    }



    private fun setAdapter(todosModelItems: List<todosModelItem>) {
        val adapter = TodoListAdapter(todosModelItems)
        binding.todorecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.todorecyclerview.adapter = adapter

    }



}