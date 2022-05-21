package com.example.caloriescalculator.presentation.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.caloriescalculator.R
import com.example.caloriescalculator.app.App
import com.example.caloriescalculator.databinding.FragmentSearchBinding
import com.example.caloriescalculator.presentation.adapter.auto_ingr_forms.IngredientFormsRecyclerViewAdapter
import com.example.caloriescalculator.presentation.stat.FavoriteViewModel
import com.jakewharton.rxbinding2.widget.RxTextView
import com.spoonacular.client.model.InlineResponse20024
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var mViewModel: SearchViewModel

    @Inject
    lateinit var favoriteViewModel: FavoriteViewModel

    private val mBinding by viewBinding(FragmentSearchBinding::bind)

    private lateinit var mAdapterForms: IngredientFormsRecyclerViewAdapter
    private lateinit var mAdapterAbilities: IngredientFormsRecyclerViewAdapter
    private lateinit var mAdapterHeldItems: IngredientFormsRecyclerViewAdapter

    private lateinit var subscribe: Disposable

    private var currentIngredient: InlineResponse20024? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.inject(this)
    }

    //
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("!!!!!!!!!!!!!!!!!!!!!!!!!search_ingredientAuto_list", "LOADED ")
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        mBinding.searchCardPokemon.btnCardAddInFavorite.setOnClickListener {
            mViewModel.getIngredientInfoById(currentIngredient!!.id, mBinding.searchCardPokemon.textField.editText?.text.toString().toInt())
            mViewModel.ingredientInfoLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    favoriteViewModel.addIngredientToFavorite(it)
                    mBinding.searchCardPokemon.textField.editText?.setText("")
                }
            }

        }

    }

    private fun initObservers() {
        subscribe = RxTextView.textChanges(mBinding.etSearchPokemonName)
            .debounce(200, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mViewModel.getIngredientAutoByName(it.toString().lowercase())
            }, {
                Log.d("list_search", "${it.message}")
            })

        mViewModel.ingredientLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                bindCardView(it)
            } else if (mBinding.etSearchPokemonName.text.toString().isEmpty()) {
                mBinding.textInputLayoutSearchPokemonName.error = ""
                mBinding.searchCardLayout.visibility = View.INVISIBLE
                mBinding.ivSearchNothingFound.visibility = View.VISIBLE
            } else if (mBinding.etSearchPokemonName.text.toString() != currentIngredient?.name) {
                mBinding.searchCardLayout.visibility = View.INVISIBLE
                mBinding.ivSearchNothingFound.visibility = View.VISIBLE
                mBinding.textInputLayoutSearchPokemonName.error =
                    getString(R.string.search_not_found)
            }
        }
    }

    private fun bindCardView(ingredient: InlineResponse20024) {
        currentIngredient = ingredient

        mBinding.textInputLayoutSearchPokemonName.error = ""
        mBinding.ivSearchNothingFound.visibility = View.INVISIBLE
        mBinding.searchCardLayout.visibility = View.VISIBLE

        mBinding.searchCardPokemon.tvIngredientName.text =
            ingredient.name.replaceFirstChar { it.uppercase() }

        mBinding.searchCardPokemon.tvIngrAisle.text = ingredient.aisle.toString()

        loadPokemonImage(ingredient.image)
    }

    private fun loadPokemonImage(url: String) {
        Glide
            .with(requireActivity())
            .load("https://spoonacular.com/cdn/ingredients_500x500/$url")
            .into(mBinding.searchCardPokemon.ivIngredientImage)
    }


    override fun onDestroyView() {
        subscribe.dispose()
        mViewModel.ingredientLiveData.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
    }
}