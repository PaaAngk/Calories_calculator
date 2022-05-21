package com.example.caloriescalculator.presentation.stat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.domain.usecase.GetIngredientInfoUseCase
import com.example.caloriescalculator.domain.usecase.RemoveIngredientUseCase
import com.example.caloriescalculator.domain.usecase.SaveIngredientUseCase
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val getIngredientInfoUseCase: GetIngredientInfoUseCase,
    private val removeIngredientUseCase: RemoveIngredientUseCase,
    private val saveIngredientUseCase: SaveIngredientUseCase
) : ViewModel() {

    private val _statIngrListLiveData: MutableLiveData<List<Ingredient>> = MutableLiveData()
    val statIngrListLiveData: LiveData<List<Ingredient>> = _statIngrListLiveData

    fun getStatisticIngredientList() {
        getIngredientInfoUseCase.getIngredientList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getStatisticIngredientListObserver())
    }

    fun addIngredientToFavorite(ingredient: Ingredient) {
       // val ingredient: Observable<Ingredient> = getIngredientInfoUseCase.getIngredientById(id,amount)
//id: Int, amount: Int
        val saveIngredientSingleSubscribe = Single.just(ingredient)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                saveIngredientUseCase.saveIngredient(ingredient)
            }, {
                print(it)
            })
    }

    fun removePokemonById(id: Int) {
        Single.just(id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                removeIngredientUseCase.removeIngredientById(it)
            }, {
                print(it)
            })
    }

    private fun getStatisticIngredientListObserver(): Observer<List<Ingredient>> {
        return object : Observer<List<Ingredient>> {
            override fun onSubscribe(d: Disposable) {
            }
            override fun onNext(t: List<Ingredient>) {
                Log.d("Ingredient_stat", "LOADED = $t")
                _statIngrListLiveData.postValue(t)
            }
            override fun onError(e: Throwable) {
                Log.d("Ingredient_stat", "$e")
            }
            override fun onComplete() {
            }
        }
    }
}