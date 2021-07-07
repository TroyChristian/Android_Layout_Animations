package com.lambdaschool.sprint2_challenge

import com.lambdaschool.sprint2_challenge.ShoppingItemConstants.ICON_IDS
import com.lambdaschool.sprint2_challenge.ShoppingItemConstants.ITEM_NAMES_RAW

class GroceryRepository {
    companion object{
        val groceryList = mutableListOf<GroceryItem>()
        fun createGroceryList(){
            for(i in 0 until ITEM_NAMES_RAW.size) { groceryList.add(GroceryItem(ITEM_NAMES_RAW[i],
                    ICON_IDS[i], isSelected = false))
        }
    }
}}