package za.co.varsitycollege.mainscreen

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {

    private lateinit var playlistTextView: TextView
    private lateinit var ratingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)

        playlistTextView = findViewById(R.id.textPlaylist)
        ratingTextView = findViewById(R.id.textRating)

        //
        val songsButton = findViewById<Button>(R.id.buttonSongs)
        songsButton.setOnClickListener {
            val songList = StringBuilder()
            for (i in MainActivity.songs.indices) {
                songList.append("Song: ${MainActivity.songs[i]}\n")
                songList.append("Artist: ${MainActivity.artists[i]}\n")
                songList.append("Rating: ${MainActivity.artists[i]}\n")

            }
            playlistTextView.text = songList.toString()
        }

        //
        val ratingButton = findViewById<Button>(R.id.buttonRating)
        ratingButton.setOnClickListener {
            val total = MainActivity.ratings.sum()
            val avarage = total.toString()
            MainActivity.ratings.size
            ratingTextView.text = "Average rating: %.3f".format(avarage)
        }

        //
        val returnButton = findViewById<Button>(R.id.buttonReturn)
        returnButton.setOnClickListener {
            finish()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun Any.sum() {

}







