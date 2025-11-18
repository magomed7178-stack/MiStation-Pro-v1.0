package com.mistation.pro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var gameGrid: GridView
    private lateinit var fpsMonitor: TextView
    private lateinit var memoryMonitor: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupUI()
        setupGamesList()
        startPerformanceMonitoring()
    }
    
    private fun setupUI() {
        gameGrid = findViewById(R.id.gameGrid)
        fpsMonitor = findViewById(R.id.fpsMonitor)
        memoryMonitor = findViewById(R.id.memoryMonitor)
    }
    
    private fun setupGamesList() {
        val games = listOf(
            Game("MiSide", "Horror", R.drawable.miside_icon),
            Game("Hello Charlotte", "Psychological", R.drawable.charlotte_icon),
            Game("Doki Doki Literature Club", "Visual Novel", R.drawable.doki_icon)
        )
        
        gameGrid.adapter = GameAdapter(this, games)
    }
    
    private fun startPerformanceMonitoring() {
        // FPS и мониторинг памяти будет здесь
        fpsMonitor.text = "FPS: 144"
        memoryMonitor.text = "Memory: 1.2GB/12GB"
    }
}

data class Game(val name: String, val genre: String, val icon: Int)
