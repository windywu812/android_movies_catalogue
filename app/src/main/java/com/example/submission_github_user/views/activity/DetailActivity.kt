package com.example.submission_github_user.views.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission_github_user.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

//        val user: User? = intent.getParcelableExtra(DETAIL_USER)
//        setupView(user)
    }

//    private fun setupView(user: User?) {
//        val res = this.resources.getDrawable(this.resources.getIdentifier(user?.avatar, "drawable", this.packageName))
//        binding.name.text = user?.name
//        binding.avatar.setImageDrawable(res)
//        binding.username.text = user?.username
//        binding.company.text = user?.company
//        binding.location.text = user?.location
//        binding.repository.text = "${user?.repository}"
//        binding.follower.text = "${user?.follower}"
//        binding.following.text = "${user?.following}"
//    }

}