package com.nicname.iyeongjun.dobike.adapter.recycler.theme

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.nicname.iyeongjun.dobike.GlideApp
import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.dobike.api.model.theme.Result


class ThemeDetailAdapter(val item : List<Result>,val context : Context) : RecyclerView.Adapter<ThemeDetailAdapter.ThemeDetailViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme_detail,parent,false)
        return ThemeDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ThemeDetailViewHolder, position: Int) {
        holder.apply {
            item[position].let {
                GlideApp
                        .with(context)
                        .load(it.image)
                        .into(img)
            }
        }
    }

    inner class ThemeDetailViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.imgThDe)
    }
}