package com.example.caloriescalculator.presentation.stat

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.caloriescalculator.R
import com.example.caloriescalculator.app.App
import com.example.caloriescalculator.databinding.FragmentFavoriteBinding
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.presentation.adapter.ingredients.IngredientAutoRecyclerViewAdapter
//import com.example.caloriescalculator.domain.model.Pokemon
//import com.example.caloriescalculator.presentation.adapter.pokemons.OnPokemonCardClickListener
//import com.example.caloriescalculator.presentation.adapter.pokemons.PokemonRecyclerViewAdapter
import javax.inject.Inject

class FavoriteFragment : Fragment() {//, OnPokemonCardClickListener

    private val mBinding by viewBinding(FragmentFavoriteBinding::bind)

    @Inject
    lateinit var mViewModel: FavoriteViewModel

    private lateinit var mAdapter: IngredientAutoRecyclerViewAdapter

    private var rcvState: Parcelable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()

        mViewModel.getStatisticIngredientList()
    }

    private fun initListeners() {

    }

    private fun initObservers() {
        mViewModel.statIngrListLiveData.observe(viewLifecycleOwner) {
            mAdapter = IngredientAutoRecyclerViewAdapter(it, requireActivity(), this)
            mBinding.rcvStatisticIngredient.adapter = mAdapter
            mAdapter.notifyDataSetChanged()


            if (it.isEmpty()) {
                mBinding.rcvStatisticIngredient.visibility = View.GONE
            } else {
                mBinding.rcvStatisticIngredient.visibility = View.VISIBLE
            }
            var caloriesAmount: Double = 0.0
            for (r in it){
                val calories = r.nutrition?.nutrients?.find { it.name == "Calories" }
                caloriesAmount += calories?.amount?.toDouble() ?: 1.0
            }
            mBinding.topAppBar.title = "Total calories - $caloriesAmount"
            mBinding.rcvStatisticIngredient.layoutManager?.onRestoreInstanceState(rcvState)
        }
    }

    fun onRemoveFromFavoriteClicked(ingredient: Ingredient, position: Int) {
        rcvState = mBinding.rcvStatisticIngredient.layoutManager?.onSaveInstanceState()
        mViewModel.removePokemonById(ingredient.id)
        mAdapter.notifyItemRemoved(position)
    }
}
