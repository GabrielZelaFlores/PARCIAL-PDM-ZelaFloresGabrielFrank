/*
Autor: Gabriel Frank Krisna Zela Flores
Descripción: Este fragmento se encarga de mostrar la pantalla de resultados del juego,
              donde aparece el puntaje final y el récord alcanzado. Además, añadi una animación
              suave para que los textos se vean más atractivos y le da al jugador
              la opción de volver a jugar o regresar al menú principal.
Fecha creación: 17/10/2025
Última modificación: 17/10/2025
*/

package com.gabrielfrankkrisnazelaflores.juegodecolores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabrielfrankkrisnazelaflores.juegodecolores.R
import com.gabrielfrankkrisnazelaflores.juegodecolores.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private var finalScore = 0
    private var highScore = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar el puntaje enviado desde GameFragment
        finalScore = arguments?.getInt("finalScore") ?: 0

        // Aquí podrías guardar y comparar con un récord almacenado (por ahora simulamos)
        highScore = maxOf(finalScore, 10) // Ejemplo de récord base
        binding.txtFinalScore.text = "Tu puntaje final es: $finalScore"
        binding.txtHighScore.text = "Récord actual: $highScore"

        // Animaciones suaves para dar más vida a la pantalla de resultados
        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.txtFinalScore.startAnimation(fadeIn)
        binding.txtHighScore.startAnimation(fadeIn)

        // Botón para volver a jugar
        binding.btnPlayAgain.setOnClickListener {
            val action = ResultFragmentDirections.actionResultToGame()
            findNavController().navigate(action)
        }

        // Botón para volver al inicio
        binding.btnGoHome.setOnClickListener {
            val action = ResultFragmentDirections.actionResultToWelcome()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
