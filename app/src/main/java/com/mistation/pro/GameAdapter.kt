package com.mistation.pro

import android.view.*
import android.widget.*

class GameAdapter(
    private val context: android.content.Context,
    private val games: List<Game>
) : BaseAdapter() {

    override fun getCount(): Int = games.size

    override fun getItem(position: Int): Game = games[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Используем стандартный макет Android вместо game_adapter
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        
        val game = getItem(position)
        
        // simple_list_item_2 имеет text1 и text2
        val text1: TextView = view.findViewById(android.R.id.text1)
        val text2: TextView = view.findViewById(android.R.id.text2)
        
        text1.text = game.name
        text2.text = game.genre
        text1.setTextColor(0xFFFFFFFF.toInt())  // Белый текст
        text2.setTextColor(0xFFCCCCCC.toInt())  // Серый текст
        
        view.setOnClickListener {
            simulateGameLaunch(game.name)
        }
        
        return view
    }

    private fun simulateGameLaunch(gameName: String) {
        Toast.makeText(context, "Запуск: $gameName", Toast.LENGTH_SHORT).show()
        
        when (gameName) {
            "MiSide" -> simulateMiSideLaunch()
            "Hello Charlotte" -> simulateCharlotteLaunch()
            "Doki Doki Literature Club" -> simulateDokiDokiLaunch()
        }
    }

    private fun simulateMiSideLaunch() {
        Toast.makeText(context, "MiSide: FPS 85-95 (DX12)", Toast.LENGTH_LONG).show()
    }

    private fun simulateCharlotteLaunch() {
        Toast.makeText(context, "Hello Charlotte: FPS 140-155 (DX12)", Toast.LENGTH_LONG).show()
    }

    private fun simulateDokiDokiLaunch() {
        Toast.makeText(context, "DDLC: FPS 170-190 (DX12)", Toast.LENGTH_LONG).show()
    }
}
