package com.example.responsi1mobileh1d023051

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023051.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initLayout()
        initListener()
    }

    private fun initLayout() {
        // Layout Sejarah
        binding.layoutSejarah.let {
            it.imgIcon.setImageResource(R.drawable.ic_sejarah)
            it.tvLayout.setText(R.string.sejarah)
        }

        // Layout Pelatih
        binding.layoutPelatih.let {
            it.imgIcon.setImageResource(R.drawable.ic_pelatih)
            it.tvLayout.setText(R.string.pelatih)
        }

        // Layout Tim
        binding.layoutTim.let {
            it.imgIcon.setImageResource(R.drawable.ic_tim)
            it.tvLayout.setText(R.string.tim)
        }
    }

    private fun initListener(){
        binding.layoutSejarah.root.setOnClickListener {
            val intent = Intent(this, SejarahActivity::class.java)
            startActivity(intent)
        }

        binding.layoutPelatih.root.setOnClickListener {
            val intent = Intent(this, HeadCoachActivity::class.java)
            startActivity(intent)
        }

        binding.layoutTim.root.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }
    }

}
