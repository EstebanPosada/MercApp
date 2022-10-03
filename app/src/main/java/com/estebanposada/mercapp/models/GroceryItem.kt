package com.estebanposada.mercapp.models

data class GroceryItem(
    val name: String,
    val category: Category,
    val price: String = "$0"
)

val groceryList = listOf(
    GroceryItem(name = "Tuna", category = Category.CANNED),
    GroceryItem(name = "Fish", category = Category.MEAT),
    GroceryItem(name = "Onion", category = Category.CANNED),
    GroceryItem(name = "Pasta", category = Category.PRODUCE),
    GroceryItem(name = "Bread", category = Category.BAKERY),
    GroceryItem(name = "Milk", category = Category.BEVERAGES),
    GroceryItem(name = "Eggs", category = Category.DAIRY),
    GroceryItem(name = "Soups", category = Category.OTHER),
    GroceryItem(name = "Salt", category = Category.PRODUCE),
)