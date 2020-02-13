package com.dicoding.azureapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var heroes: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       AppCenter.start(getApplication(), "624b84d3-f43d-4a9a-9f21-cac930cb8676",
                  Analytics.class, Crashes.class)

        heroes.addAll(HeroesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_hero.layoutManager = LinearLayoutManager(this)
        rv_hero.adapter = ListHeroAdapter(heroes)
    }
}
