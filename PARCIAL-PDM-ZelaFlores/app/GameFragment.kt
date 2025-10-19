/*
Autor: Gabriel Frank Krisna Zela Flores
Descripcion: Fragmento principal del juego. Muestra un color aleatorio, botones de colores para elegir,
temporizador, puntaje en tiempo real, sonidos y animaciones suaves al acertar.
Fecha creación: 17/10/2025
Última modificación: 17/10/2025
*/

package com.gabrielfrankkrisnazelaflores.juegodecolores.ui

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabrielfrankkrisnazelaflores.juegodecolores.R
import com.gabrielfrankkrisnazelaflores.juegodecolores.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    // Lista de colores disponibles
    private val colorList = listOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW)

    private var score = 0 // Puntaje actual
    private var timeLeft = 30 // Tiempo restante (segundos)
    private var correctColor = Color.RED // Color correcto actual
    private var timer: CountDownTimer? = null // Temporizador

    // Para sonidos
    private var mpCorrect: MediaPlayer? = null
    private var mpWrong: MediaPlayer? = null
    private var mpBg: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)

        // Inicializar sonidos
        mpCorrect = MediaPlayer.create(requireContext(), R.raw.correct)
        mpWrong = MediaPlayer.create(requireContext(), R.raw.wrong)
        mpBg = MediaPlayer.create(requireContext(), R.raw.bg_music)
        mpBg?.isLooping = true
        mpBg?.setVolume(0.3f, 0.3f)
        mpBg?.start()

        startNewRound()
        startTimer()

        // Configurar los botones de colores
        binding.btnRed.setOnClickListener { checkAnswer(Color.RED) }
        binding.btnBlue.setOnClickListener { checkAnswer(Color.BLUE) }
        binding.btnGreen.setOnClickListener { checkAnswer(Color.GREEN) }
        binding.btnYellow.setOnClickListener { checkAnswer(Color.YELLOW) }

        return binding.root
    }

    // Inicia una nueva ronda con un color aleatorio
    private fun startNewRound() {
        val randomIndex = Random.nextInt(colorList.size)
        correctColor = colorList[randomIndex]
        binding.viewColorBox.setBackgroundColor(correctColor)
    }

    // Verifica la respuesta del jugador
    private fun checkAnswer(selectedColor: Int) {
        val clickedButton = when (selectedColor) {
            Color.RED -> binding.btnRed
            Color.BLUE -> binding.btnBlue
            Color.GREEN -> binding.btnGreen
            else -> binding.btnYellow
        }

        if (selectedColor == correctColor) {
            // Sonido de acierto
            mpCorrect?.start()
            score++
            binding.tvScore.text = "Puntaje: $score"

            // Animación de parpadeo al acertar
            val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.blink)
            clickedButton.startAnimation(anim)
        } else {
            // Sonido de error
            mpWrong?.start()
        }

        startNewRound()
    }

    // Inicia el temporizador de 30 segundos
    private fun startTimer() {
        timer = object : CountDownTimer(30_000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                binding.tvTimer.text = "Tiempo: ${timeLeft}s"
            }

            override fun onFinish() {
                binding.tvTimer.text = "¡Tiempo agotado!"
                goToResults()
            }
        }.start()
    }

    // Navegar al fragmento de resultados
    private fun goToResults() {
        val action = GameFragmentDirections.actionGameToResult(score)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        mpBg?.stop()
        mpBg?.release()
        mpCorrect?.release()
        mpWrong?.release()
        _binding = null
    }
}
