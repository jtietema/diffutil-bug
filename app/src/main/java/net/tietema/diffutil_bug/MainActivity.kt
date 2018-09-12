package net.tietema.diffutil_bug

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.fixed_button).setOnClickListener {
            startActivity(Intent(this, Fixed::class.java))
        }
        findViewById<Button>(R.id.broken_button).setOnClickListener {
            startActivity(Intent(this, BrokenDiffUtil::class.java))
        }
    }
}
