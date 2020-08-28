package co.edu.uan.android.podcastapp1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_main)

        // 1. create the data array
        val podcastNames = arrayListOf(
            Podcast("The Economists","The Economists uses the tools of economics to shine a light on ...",43, "img_economist"),
            Podcast("Australian Investors Podcast","Welcome to Rask Australia's Australian Investors Podcast. The Australian Invest...",49, "img_economist"),
            Podcast("The Economists","The Economists uses the tools of economics to shine a light on ...",43, "img_economist"),
            Podcast("Australian Investors Podcast","Welcome to Rask Australia's Australian Investors Podcast. The Australian Invest...",49, "img_economist")
        )
        // 2. create an adapter
        val adapter = PodcastListAdapter(this, R.layout.list_podcast, podcastNames)
        // 3. connect the list with the adapter
        podcastList.adapter = adapter

    }
}