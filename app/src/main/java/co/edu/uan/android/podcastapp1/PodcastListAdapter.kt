package co.edu.uan.android.podcastapp1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PodcastListAdapter(context: Context, val resource: Int, val data: ArrayList<Podcast>)
    : ArrayAdapter<Podcast>(context, resource, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return createViewFromResource(inflater, position, convertView, parent);
    }

    fun createViewFromResource(inflater: LayoutInflater, position: Int, convertView: View?, parent: ViewGroup): View {
        // 1. lookup the data we want to show
        val podcast = data[position]
        // 2. choose the view components we want to use
        val view: View = convertView ?: inflater.inflate(resource, parent, false)
        val titleView = view.findViewById<TextView>(R.id.textTitlePodcast)
        titleView.text = podcast.title
        val descriptionView = view.findViewById<TextView>(R.id.textDescriptionPodcast)
        descriptionView.text = podcast.description
        val imageView = view.findViewById<ImageView>(R.id.imgPodcast)
        val imageId = context.resources.getIdentifier(podcast.image, "drawable", context.packageName)
        imageView.setImageResource(imageId)
        val episodesView = view.findViewById<TextView>(R.id.textEpisodesPodcast)
        episodesView.text = "${podcast.episodes} episodes"


        // 3. return the new view
        return view

    }

}