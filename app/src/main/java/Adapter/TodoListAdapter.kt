package Adapter

import Models.todosModelItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import self.tutorial.mvvmrretrofit.databinding.ActivityMainTodosBinding
import self.tutorial.mvvmrretrofit.databinding.ListRowBinding

class TodoListAdapter(val todoItemlist:List<todosModelItem>):RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {

  inner class MyViewHolder(val itemBinding: ListRowBinding):RecyclerView.ViewHolder(itemBinding.root){
          fun bindItem(todosModelItem: todosModelItem){
               itemBinding.tvTitle.text = todosModelItem.title
               itemBinding.tvId.text = todosModelItem.userId.toString()
          }
        }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val todoitem = todoItemlist[position]
      holder.bindItem(todoitem)
  }

  override fun getItemCount(): Int {
     return todoItemlist.size
  }

}