package ViewModel

import Models.modelData
import Models.todosModelItem
import Models.zenModelItem
import Repository.MainRepository
import Retrofit.RetrofitInstance
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel()
{

    val TAG ="Api"
    val mainRespontory : MainRepository = MainRepository()
    val allUsersList : MutableLiveData<List<todosModelItem>> = MutableLiveData()
    val allUsersListFromZenList: MutableLiveData<List<zenModelItem>> = MutableLiveData()

    fun get(){

        viewModelScope.launch {
            mainRespontory.getUsersFromServer().catch {
                Log.e(TAG,"get: + ${it.localizedMessage}")
            }.collect{list->
               allUsersList.value = list
            }

        }

    }


    //
    fun getZen(){
        viewModelScope.launch {
            mainRespontory.getUsersFromZenServer().catch {
                Log.e(TAG,"get: + ${it.localizedMessage}")
            }.collect{list->
                allUsersListFromZenList.value =  list
            }

        }


    }


    //


    val data = MutableLiveData<modelData>()
    val todoData = MutableLiveData<List<todosModelItem>>()

    fun getMemeData(){
        RetrofitInstance.apiInterface.getMemes().enqueue( object : Callback<modelData?> {
            override fun onResponse(call: Call<modelData?>, response: Response<modelData?>) {

                data.value = response.body()
            }

            override fun onFailure(call: Call<modelData?>, t: Throwable) {
                Log.e(TAG,"onFailure" + t.localizedMessage)
            }
        })
    }


    fun getTodoData() {
        RetrofitInstance.apiInterface2.getTodos().enqueue( object : Callback<List<todosModelItem>?> {
            override fun onResponse(
                call: Call<List<todosModelItem>?>,
                response: Response<List<todosModelItem>?>
            ) {
                 todoData.value = response.body()
            }

            override fun onFailure(call: Call<List<todosModelItem>?>, t: Throwable) {
                Log.e(TAG,"onFailure" + t.localizedMessage)
            }
        })


    }


    // using coroutine

    fun getUserFrom(){
        viewModelScope.launch {
            RetrofitInstance.apiInterface2.getTodos().enqueue( object : Callback<List<todosModelItem>?> {
                override fun onResponse(
                    call: Call<List<todosModelItem>?>,
                    response: Response<List<todosModelItem>?>
                ) {
                    todoData.value = response.body()
                }

                override fun onFailure(call: Call<List<todosModelItem>?>, t: Throwable) {
                    Log.e(TAG,"onFailure" + t.localizedMessage)
                }
            })


        }
    }

}


