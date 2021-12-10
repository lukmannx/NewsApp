package com.example.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.DataNews
import com.example.newsapp.NewsAdapter
import com.example.newsapp.R
import com.example.newsapp.binddingNewsHeadline
import com.example.newsapp.databinding.FragmentAllNewsBinding
import com.example.newsapp.databinding.FragmentPopularBinding

class PopularFragment : Fragment() {

    private lateinit var binding : FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopularBinding.inflate(inflater,container,false)
        binding.rvPopularNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NewsAdapter(DataNews.dataPopular)
        }

        binddingNewsHeadline(binding.newsHeadline, 2)

        return binding.root
    }
}