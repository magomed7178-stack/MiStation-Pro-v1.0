package com.mistation.pro

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val context: android.content.Context,
    private val games: List<Game>
) : BaseAdapter() {

    override fun getCount(): Int = games.size

    override fun getItem(position: Int): Game = games[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.game_adapter, parent, false)
        val game = getItem(position)
        
        val gameName: TextView = view.findViewById(R.id.gameName)
        val gameGenre: TextView = view.findViewById(R.id.gameGenre)
        val gameIcon: ImageView = view.findViewById(R.id.gameIcon)
        
        gameName.text = game.name
        gameGenre.text = game.genre
        gameIcon.setImageResource(game.icon)
        
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
