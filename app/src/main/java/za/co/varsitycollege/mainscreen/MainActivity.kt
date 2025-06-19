package za.co.varsitycollege.mainscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //
    companion object {
        val songs = arrayOf("One time","Love me now","Favourite girl","Hello")
        val artists = arrayOf("Justin bieber","John legend","Justin bieber","Adele")
        val ratings = arrayOf("5,3,4,5")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //
        val addToPlaylistButton = findViewById<Button>(R.id.buttonAdd)
        addToPlaylistButton.setOnClickListener {

        }

        //
        val viewPlaylistButton = findViewById<Button>(R.id.buttonViewPlaylist)
        viewPlaylistButton.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            startActivity(intent)
        }

        //
        val exitButton = findViewById<Button>(R.id.buttonExit)
        exitButton.setOnClickListener{
            finishAffinity()
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}