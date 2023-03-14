package com.cr1ss.androidmod2.ui.fragmentos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.androidmod2.R
import com.cr1ss.androidmod2.databinding.ActivityFragmentosBinding

class FragmentosActivity : AppCompatActivity() {

    private var switch = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnChange.setOnClickListener {
//            switch = !switch
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.replace(
////                R.id.containerFragment,
////                if (switch) FragmentOne() else FavoriteFragment()
////            )
////            transaction.addToBackStack(null)
////            transaction.commit()
//            supportFragmentManager.commit {
//                replace(R.id.containerFragment, if (switch) FragmentOne() else FavoriteFragment())
//                addToBackStack(null)
//            }
//        }


        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.menu_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.menu_favorite -> Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
                R.id.menu_profile -> Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }
}