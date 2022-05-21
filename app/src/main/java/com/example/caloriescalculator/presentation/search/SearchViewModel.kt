package com.example.caloriescalculator.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.domain.usecase.GetIngredientAutoUseCase
import com.example.caloriescalculator.domain.usecase.GetIngredientInfoUseCase
import com.spoonacular.client.model.InlineResponse20024
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getIngredientAutoUseCase: GetIngredientAutoUseCase,
    private val getIngredientInfoUseCase: GetIngredientInfoUseCase
): ViewModel() {

    private val _ingredientLiveData: MutableLiveData<InlineResponse20024> = MutableLiveData()
    val ingredientLiveData: LiveData<InlineResponse20024> = _ingredientLiveData

    private val _ingredientInfoLiveData: MutableLiveData<Ingredient> = MutableLiveData()
    val ingredientInfoLiveData: LiveData<Ingredient> = _ingredientInfoLiveData

    fun getIngredientInfoById(id: Int, amount: Int) {
        getIngredientInfoUseCase.getIngredientById(id,amount)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getIngredientInfoByIdObserver())
    }

    fun getIngredientAutoByName(name: String) {
        getIngredientAutoUseCase.get(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getIngredientAutoObserver())
    }

    private fun getIngredientAutoObserver(): Observer<kotlin.Array<InlineResponse20024>> {
        return object : Observer<kotlin.Array<InlineResponse20024>> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: kotlin.Array<InlineResponse20024>) {
                Log.d("search_ingredientAuto_list", "LOADED = $t]")
                for(r in t ){
                    _ingredientLiveData.postValue(r)
                }

            }
            override fun onError(e: Throwable) {
                Log.d("search_list", "$e")
                _ingredientLiveData.postValue(null)
            }
            override fun onComplete() {

            }
        }
    }
    private fun getIngredientInfoByIdObserver(): Observer<Ingredient> {
        return object : Observer<Ingredient> {
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: Ingredient) {
                Log.d("search_ingredientAuto_list", "LOADED = $t]")
                _ingredientInfoLiveData.postValue(t)
            }
            override fun onError(e: Throwable) {
                Log.d("search_list", "$e")
                _ingredientInfoLiveData.postValue(null)
            }
            override fun onComplete() {

            }
        }
    }
}