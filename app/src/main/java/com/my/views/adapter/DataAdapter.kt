package com.my.views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.views.R
import com.my.views.model.UserModel

class DataAdapter(var listener: DataListener) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private var userData: ArrayList<UserModel>? = null

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var imageView: ImageView
        private lateinit var itemText: TextView
        private lateinit var itemTextTwo: TextView

        /*fun bindView(item: PostModel?) {
            imageView = itemView.findViewById(R.id.img_delete)
            itemText = itemView.findViewById(R.id.tv_home_item_title)
            itemTextTwo = itemView.findViewById(R.id.tv_home_item_body)
            itemText.text = item?.title
            itemTextTwo.text = item?.body
        }*/

        fun userBindView(item: UserModel?) {
            imageView = itemView.findViewById(R.id.img_delete)
            itemText = itemView.findViewById(R.id.tv_home_item_title)
            itemTextTwo = itemView.findViewById(R.id.tv_home_item_body)
            itemText.text = item?.name
            itemTextTwo.text = item?.website
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return userData?.size ?: 0
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val userItem = userData?.get(position)
        holder.userBindView(userItem)
        val imageView: ImageView = holder.itemView.findViewById(R.id.img_delete)
        imageView.setOnClickListener {
            userItem?.let {
                listener.onUserItemDeleted(
                    userModel = it,
                    position = position
                )
            }
        }
    }

    interface DataListener {
        fun onUserItemDeleted(
            userModel: UserModel,
            position: Int,
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserData(list: ArrayList<UserModel>) {
        userData = list
        notifyDataSetChanged()
    }
}