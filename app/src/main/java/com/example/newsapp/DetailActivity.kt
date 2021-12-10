package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_IMG_HEADLINE = "image"
        const val EXTRA_TITLE_HEADLINE = "title"
        const val  EXTRA_DATE_HEADLINE = "date"
        const val EXTRA_AUTHOR_HEADLINE = "author"
        const val EXTRA_CONTENT_HEADLINE = "desc"
        const val NEWS_DATA = "data"
    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "News Detail"
        }
        //Menerima data dari intent parcelable\
        val news = intent.getParcelableExtra<News>(NEWS_DATA)

        val photoHeadline = intent.getIntExtra(EXTRA_IMG_HEADLINE, 0)
        val titleHeadline = intent.getStringExtra(EXTRA_TITLE_HEADLINE)
        val contentHeadline = intent.getStringExtra(EXTRA_CONTENT_HEADLINE)
        val dateHeadline = intent.getStringExtra(EXTRA_DATE_HEADLINE)
        val AuthorHeadline = intent.getStringExtra(EXTRA_AUTHOR_HEADLINE)

        if (news != null) {
            binding.imgNewsDetail.setImageResource(news.photo)
            binding.tvTitleDetail.text = news.title
            binding.tvTitleDetail.text = news.date
            binding.tvContentDetail.text = news.content
            binding.tvAuthorDetail.text = news.author
        }else{
            binding.imgNewsDetail.setImageResource(photoHeadline)
            binding.tvTitleDetail.text = titleHeadline
            binding.tvTitleDetail.text = dateHeadline
            binding.tvContentDetail.text = contentHeadline
            binding.tvAuthorDetail.text = AuthorHeadline
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}