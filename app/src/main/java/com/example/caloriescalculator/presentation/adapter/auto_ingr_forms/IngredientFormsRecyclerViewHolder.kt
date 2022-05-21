package com.example.caloriescalculator.presentation.adapter.auto_ingr_forms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.caloriescalculator.R
import com.example.caloriescalculator.databinding.CardItemIngredientFormsBinding

class IngredientFormsRecyclerViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.card_item_ingredient_forms, parent, false)) {

    private val mBinding by viewBinding(CardItemIngredientFormsBinding::bind)

    fun bind(form: String) {
        mBinding.tvItemIngredientForm.text = form
    }
}