package com.example.radcooksplash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView

class search : AppCompatActivity() {

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        courseRV = findViewById(R.id.idRVCourses)
        courseList = ArrayList()
        courseRVAdapter = CourseRVAdapter(courseList)
        courseRV.adapter = courseRVAdapter


        courseList.add(CourseRVModal("Pollo", R.drawable.receta1))
        courseList.add(CourseRVModal("Arroz", R.drawable.receta2))
        courseList.add(CourseRVModal("Papas", R.drawable.receta3))
        courseList.add(CourseRVModal("Galleta", R.drawable.receta4))
        courseList.add(CourseRVModal("Jugo", R.drawable.receta5))

        courseRVAdapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.search_menu, menu)

        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        val searchView: SearchView = searchItem.getActionView() as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {

                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {

        val filteredlist: ArrayList<CourseRVModal> = ArrayList()

        for (item in courseList) {

            if (item.courseName.toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {

            courseRVAdapter.filterList(filteredlist)
        }
    }
}
