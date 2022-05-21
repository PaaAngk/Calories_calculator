package com.example.caloriescalculator.presentation.adapter.ingredients

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.caloriescalculator.R
import com.example.caloriescalculator.databinding.CardIngredientBinding
import com.example.caloriescalculator.databinding.CardIngredientStatBinding
import com.example.caloriescalculator.databinding.FragmentFavoriteBinding
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.presentation.adapter.auto_ingr_forms.IngredientFormsRecyclerViewAdapter
import com.example.caloriescalculator.presentation.stat.FavoriteFragment
import com.spoonacular.client.model.InlineResponse20024

class IngredientAutoRecyclerViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val activity: Activity,
    private val onIngredientCardClickListener: FavoriteFragment
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.card_ingredient_stat, parent, false)) {

    private lateinit var mAdapterForms: IngredientFormsRecyclerViewAdapter
    private lateinit var mAdapterAbilities: IngredientFormsRecyclerViewAdapter
    private lateinit var mAdapterHeldItems: IngredientFormsRecyclerViewAdapter

    private val mBinding by viewBinding(CardIngredientStatBinding::bind)
    //private val fBinding by viewBinding(FragmentFavoriteBinding::bind)

    fun bind(ingredient: Ingredient) {
        mBinding.tvIngredientName.text = ingredient.name

        mBinding.tvIngrAisle.text = ingredient.name.toString()

        mBinding.btnCardAddInFavorite.setIconResource(R.drawable.ic_baseline_food_bank_24)

        mBinding.btnCardAddInFavorite.text = activity.getString(R.string.card_btn_stat_remove)
        mBinding.btnCardAddInFavorite.setOnClickListener {
            onIngredientCardClickListener.onRemoveFromFavoriteClicked(
                ingredient = ingredient,
                position = absoluteAdapterPosition
            )
        }


        val calories = ingredient.nutrition?.nutrients?.find { it.name == "Calories" }
        mBinding.tvCalories.setText("Calories: "+ calories?.amount.toString()+" kcal")
        //forms
        val ingredientForms = ingredient.nutrition?.nutrients?.map { it.name+": "+it.amount+" "+it.unit }
        mAdapterForms = IngredientFormsRecyclerViewAdapter(
            ingredientForms ?: listOf(activity.getString(R.string.card_pokemon_forms_none))
        )
        mBinding.rcvPokemonForms.adapter = mAdapterForms
        mAdapterForms.notifyDataSetChanged()

        loadPokemonImage(ingredient.image!!)
    }

    private fun loadPokemonImage(url: String) {
        Glide
            .with(activity)
            .load("https://spoonacular.com/cdn/ingredients_500x500/$url")
            .into(mBinding.ivIngredientImage)
    }
}