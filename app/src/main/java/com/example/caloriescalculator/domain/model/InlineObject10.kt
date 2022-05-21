/**
* spoonacular API
* The spoonacular Nutrition, Recipe, and Food API allows you to access over 380,000 recipes, thousands of ingredients, 800,000 food products, and 100,000 menu items. Our food ontology and semantic recipe search engine makes it possible to search for recipes using natural language queries, such as \"gluten free brownies without sugar\" or \"low fat vegan cupcakes.\" You can automatically calculate the nutritional information for any recipe, analyze recipe costs, visualize ingredient lists, find recipes for what's in your fridge, find recipes based on special diets, nutritional requirements, or favorite ingredients, classify recipes into types and cuisines, convert ingredient amounts, or even compute an entire meal plan. With our powerful API, you can create many kinds of food and especially nutrition apps.  Special diets/dietary requirements currently available include: vegan, vegetarian, pescetarian, gluten free, grain free, dairy free, high protein, whole 30, low sodium, low carb, Paleo, ketogenic, FODMAP, and Primal.
*
* The version of the OpenAPI document: 1.0
* Contact: mail@spoonacular.com
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.spoonacular.client.model


import com.squareup.moshi.Json
/**
 * 
 * @param username The username.
 * @param id The shopping list item id.
 * @param hash The private hash for the username.
 */
data class InlineObject10 (
    /* The username. */
    @Json(name = "username")
    val username: kotlin.String,
    /* The shopping list item id. */
    @Json(name = "id")
    val id: java.math.BigDecimal,
    /* The private hash for the username. */
    @Json(name = "hash")
    val hash: kotlin.String
) {

}

