package com.muktadir.photolist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muktadir.photolist.R
import com.muktadir.photolist.ui.data.PhotoList

class PhotoListAdapter(
    var photoList: Array<PhotoList>,
    var context: Context,
    var photoItemClickListener: PhotoItemClickListener
) : RecyclerView.Adapter<PhotoListAdapter.PhotoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoListViewHolder, position: Int) {
        val data = photoList[position]
        holder.title.text = photoList[position].title

    }


    override fun getItemCount(): Int {
        return photoList.size
    }

    class PhotoListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView2)
        val title: TextView = view.findViewById(R.id.title)
        val subTitle: TextView = view.findViewById(R.id.tvSubtitle)

    }


    interface PhotoItemClickListener {
        fun onPhotoItemClick(data: PhotoList)
    }
}