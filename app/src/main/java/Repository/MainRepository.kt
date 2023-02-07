package Repository

import Models.todosModelItem
import Models.zenModelItem
import Retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
//import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MainRepository {

    fun getUsersFromServer(): Flow<List<todosModelItem>> = flow {
        emit(RetrofitInstance.apiInterface2.getUserTodos())
    }.flowOn(Dispatchers.Main)



    fun getUsersFromZenServer():Flow<List<zenModelItem>>{
        val flowOfUserZenResponse = flow<List<zenModelItem>>{
            emit(RetrofitInstance.apiInterfaceZen.getUserZen())
        }.flowOn(Dispatchers.Main)
        return flowOfUserZenResponse
    }

//    fun stringExample() :Flow<List<>>{
//        val stringList = flow<List<String>>
//    }

//    fun userResponseList(): Flow<List<userResponseItem>> {
//        val flowOfUserResponse = flow<List<userResponseItem>> {
//            emit(RetrofitInstance.apiInterface.getUser())
//        }
//        return flowOfUserResponse
//    }
//
//    fun userResponseSimply(): Flow<List<userResponseItem>> = flow<List<userResponseItem>> {
//        emit(RetrofitInstance.apiInterface.getUser())
//    }

//    fun stringExample2() :Flow<List<String>>{
//        val stringList = flow<List<String>>{
//            val list = arrayListOf<String>("hongan", "alex")
//            emit(list)
//        }.flowOn(Dispatchers.IO)
//        return stringList
//    }

}