package com.nicname.iyeongjun.dobike.adapter.recycler.theme

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.dobike.api.model.theme.ThemeModel


class ThemeAdapter(themeModel: ThemeModel, val context : Context) : RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder>(){
    val items = themeModel.results?.groupBy { it?.type }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme,parent,false)
        return ThemeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.keys?.size!!
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.apply {
            items?.keys?.toList()!![position].let {
                text.text = it
            }
            items?.values?.toList()!![position].let {
                recyclerView.apply {
                    adapter = ThemeDetailAdapter(it,context)
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }

    inner class ThemeViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val text = view.findViewById<TextView>(R.id.txtThemeType)
        val recyclerView = view.findViewById<RecyclerView>(R.id.themeDeatilRecycler)
    }
}