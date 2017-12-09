package com.developers.chukimmuoi.customviewgroup

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developers.chukimmuoi.customviewgroup.data.ListItem
import kotlinx.android.synthetic.main.list_item_simple.view.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : CustomViewGroup
 * Created by chukimmuoi on 09/12/2017.
 */
class ListItemAdapter(val context: Context) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private val mInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setListItem(ListItem.getItem(position))
    }

    override fun getItemCount(): Int {
        return ListItem.itemCount
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(mInflater.inflate(R.layout.list_item_simple, parent, false))
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun setListItem(item: ListItem){
            itemView.icon.setImageResource(item.iconResId)
            itemView.title.setText(item.stringResId)
            itemView.subtitle.setText(item.descResId)
        }
    }
}