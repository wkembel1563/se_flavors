package com.example.flavors_prototype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//this class stores the data from every CountryName node in an array
class DishAdapter(
    private val dataList : ArrayList<Recipe>,
    ) : RecyclerView.Adapter<DishAdapter.MyViewHolder>() {




    // SET UP CLICK LISTENER FOR CARDS
    private lateinit var mListener : OnItemClickListener

    // any class that implements OnItemClickListener
    // must also implement onItemClick
    interface OnItemClickListener{
        // pass the position of the item clicked to method
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //database reference variable and like status tracker
        //lateinit var LikesRef : DatabaseReference


        //layout inflater using the layout from data_item.xml
        val recipeView = LayoutInflater.from(parent.context).inflate(R.layout.data_item,
            parent,false)
        return MyViewHolder(recipeView, mListener, )

    }

    // will store data from each node in currentItem, and populates each card item with text from given place
    // this method is called everytime a card scrolls onto screen
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    //this class binds variables to the textViews in data_item
    // setting the clickListener for the recycler view card in here as well
    class MyViewHolder(itemView : View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

        //val nameOfPlace : TextView = itemView.findViewById(R.id.tvnameOfPlace)



        // set a clickListener on itemview to activate DishView after
        // clicking anywhere on the recyclerview card


        init {





            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }

    }


}