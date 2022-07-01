package com.muktadir.photolist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.muktadir.photolist.databinding.FragmentPhotoListBinding
import com.muktadir.photolist.ui.adapter.PhotoListAdapter
import com.muktadir.photolist.ui.data.PhotoList


class PhotoListFragment : Fragment(),PhotoListAdapter.PhotoItemClickListener {

    private lateinit var binding : FragmentPhotoListBinding
    private lateinit var adapter : PhotoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoListBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : PhotoList
        val myListData: Array<PhotoList> = arrayOf<PhotoList>(
            PhotoList(1,"","","Title1"),
            PhotoList(2,"","","Title2"),
            PhotoList(3,"","","Title3"),
            PhotoList(4,"","","Title4"),
            PhotoList(5,"","","Title5"),
        )
        adapter = PhotoListAdapter(myListData, requireContext(), this)

        val gridLayoutManager = LinearLayoutManager(requireContext())
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvPhoto.layoutManager = gridLayoutManager
        binding.rvPhoto.adapter = adapter

    }

    override fun onPhotoItemClick(data: PhotoList) {

    }

}