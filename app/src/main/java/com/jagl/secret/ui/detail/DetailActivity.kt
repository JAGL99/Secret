package com.jagl.secret.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.jagl.secret.R
import com.jagl.secret.databinding.ActivityDetailBinding
import com.jagl.secret.model.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            title = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780/${ movie.backdrop_path }")
                .into(binding.backdrop)
            binding.summary.text = movie.overview + movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview +movie.overview
            bindDetailInfo(binding.detailInfo,movie)

            binding.fab.setOnClickListener{
                Toast.makeText(this,"Añadido a favorito", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun bindDetailInfo(detailInfo: TextView, movie: Movie) {
        detailInfo.text = buildSpannedString {

            appendInfo(this, R.string.original_language,movie.original_language)
            appendInfo(this, R.string.original_title,movie.original_title)
            appendInfo(this, R.string.release_date,movie.release_date)
            appendInfo(this, R.string.popularity,movie.popularity.toString())
            appendInfo(this, R.string.vote_average,movie.vote_average.toString())
        }
    }

    private fun appendInfo(builder: SpannableStringBuilder, stringRes: Int, value: String){
        builder.bold {
            append(getString(stringRes))
            append(": ")
        }
        builder.appendLine(value)
    }
}