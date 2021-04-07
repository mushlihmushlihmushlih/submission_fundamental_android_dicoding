package com.example.submissiongituhubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var users: ArrayList<User>
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        adapter = UserAdapter(this, addItem())
        lv_list.adapter = adapter


        lv_list.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            val listDataUser = User(0,"","", "", "", "", "", "")
            listDataUser.avatar = dataAvatar.getResourceId(position,position)
            listDataUser.username = dataUsername[position]
            listDataUser.name = dataName[position]
            listDataUser.location = dataLocation[position]
            listDataUser.repository = dataRepository[position]
            listDataUser.company = dataCompany[position]
            listDataUser.followers = dataFollowers[position]
            listDataUser.following = dataFollowing[position]

            val intent = Intent(this@MainActivity, UserDetail::class.java)
            intent.putExtra(UserDetail.EXTRA_DATA, listDataUser)

            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() : ArrayList<User> {
        users = ArrayList()
        for (i in dataName.indices) {
            val user = User()
            user.avatar = dataAvatar.getResourceId(i, -1)
            user.name = dataName[i]
            user.username = dataUsername[i]
            user.followers = dataFollowers[i]
            user.following = dataFollowing[i]
            users.add(user)
        }
        return users
    }
}

