package com.mistation.pro

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val context: android.content.Context,
    private val games: List<Game>
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gameIcon: ImageView = view.findViewById(R.id.gameIcon)
        val gameName: TextView = view.findViewById(R.id.gameName)
        val gameGenre: TextView = view.findViewById(R.id.gameGenre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_adapter, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        
        holder.gameName.text = game.name
        holder.gameGenre.text = game.genre
        
        // Заглушка для иконки (в реальном приложении здесь будет загрузка изображения)
        holder.gameIcon.setImageResource(game.icon)
        
        holder.itemView.setOnClickListener {
            // Запуск симуляции игры
            simulateGameLaunch(game.name)
        }
    }

    override fun getItemCount() = games.size

    private fun simulateGameLaunch(gameName: String) {
        Toast.makeText(context, "Запуск: \$gameName", Toast.LENGTH_SHORT).show()
        
        // Здесь будет логика симуляции запуска игры
        when (gameName) {
            "MiSide" -> simulateMiSideLaunch()
            "Hello Charlotte" -> simulateCharlotteLaunch()
            "Doki Doki Literature Club" -> simulateDokiDokiLaunch()
        }
    }

    private fun simulateMiSideLaunch() {
        // Симуляция запуска MiSide
        Toast.makeText(context, "MiSide: FPS 85-95 (DX12)", Toast.LENGTH_LONG).show()
    }

    private fun simulateCharlotteLaunch() {
        // Симуляция запуска Hello Charlotte  
        Toast.makeText(context, "Hello Charlotte: FPS 140-155 (DX12)", Toast.LENGTH_LONG).show()
    }

    private fun simulateDokiDokiLaunch() {
        // Симуляция запуска DDLC
        Toast.makeText(context, "DDLC: FPS 170-190 (DX12)", Toast.LENGTH_LONG).show()
    }
}
