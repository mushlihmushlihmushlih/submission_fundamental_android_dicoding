package com.example.submissiongituhubuserapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_detail.*

class UserDetail : AppCompatActivity() {
    companion object {
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        val listData: User = intent.getParcelableExtra(EXTRA_DATA)!!

        detail_img.setImageResource(listData.avatar!!)
        detail_uname.text = getString(R.string.uname, listData.username)
        detail_name.text = listData.name
        detail_location.text = getString(R.string.loc, listData.location)
        detail_repo.text = getString(R.string.repository, listData.repository)
        detail_company.text = getString(R.string.Corp, listData.company)
        detail_followers.text = getString(R.string.followers, listData.followers)
        detail_following.text = getString(R.string.following, listData.following)
    }
}