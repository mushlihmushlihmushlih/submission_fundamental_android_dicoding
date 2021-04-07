package com.example.submissiongituhubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter internal constructor(private val context: Context, private val listUser : ArrayList<User>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_profile, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    override fun getItem(i: Int): Any = listUser[i]

    override fun getItemId(i: Int): Long = i.toLong()


    override fun getCount(): Int {
        return listUser.size
    }


    private inner class ViewHolder internal constructor(view: View) {
        private val txtUser: TextView = view.findViewById(R.id.txt_name)
        private val txtUserName: TextView = view.findViewById(R.id.username)
        private val txtFollowers: TextView = view.findViewById(R.id.followers)
        private val txtFollowing: TextView = view.findViewById(R.id.following)
        //private val txtCorp: TextView = view.findViewById(R.id.txt_corp)
        //private val txtLoc: TextView = view.findViewById(R.id.txt_location)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(user: User) {
            txtUser.text = user.name
            txtUserName.text = user.username
            txtFollowers.text = user.followers
            txtFollowing.text = user.following
            //txtCorp.text = user.company
            //txtLoc.text = user.location
            user.avatar?.let { imgPhoto.setImageResource(it) }
        }
    }
}
