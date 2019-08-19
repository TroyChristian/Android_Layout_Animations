package com.lambdaschool.sprint2_challenge



import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.grocery_list_item.view.*

class GroceryListAdapter(val groceryList: MutableList<GroceryItem>) : RecyclerView.Adapter<GroceryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.grocery_list_item, parent, false) as View)

}

override fun getItemCount(): Int {
    return groceryList.size
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val grocery = groceryList[position]
    holder.bindModel(grocery)

    holder.groceryImageView.setOnClickListener {
        grocery.isSelected = !grocery.isSelected
        notifyItemChanged(position)
    }


}
var shopping_list = mutableListOf<String>()
class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val groceryImageView: ImageView = view.grocery_image_view
    val groceryNameView: TextView = view.grocery_name_view
    val groceryItemAncestor: LinearLayout = view.grocery_item_ancestor

    fun bindModel(food: GroceryItem) {
        groceryImageView.setImageResource(food.imageID)
        groceryNameView.text = food.name
        if (food.isSelected)
            groceryItemAncestor.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
        else
            groceryItemAncestor.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorPrimaryDark))
    }
}

}