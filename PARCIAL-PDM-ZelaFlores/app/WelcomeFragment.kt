/*
Autor: Gabriel Frank Krisna Zela Flores
Descripcion: Fragmento de bienvenida que muestra las reglas y un botón para iniciar el juego.
Fecha creación: 16/10/2025
Última modificación: 16/10/2025
*/

package com.gabrielfrankkrisnazelaflores.juegodecolores.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabrielfrankkrisnazelaflores.juegodecolores.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    // ViewBinding para este fragment
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        // Mostrar las reglas en un AlertDialog al presionar el botón
        binding.btnRules.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Reglas del Juego ")
                .setMessage(
                    "• Presiona el botón que coincida con el color mostrado.\n" +
                            "• Tienes 30 segundos para sumar la mayor cantidad de puntos.\n" +
                            "• Cada acierto suma 1 punto.\n\n¡Listo para poner a prueba tu reflejo visual!"
                )
                .setPositiveButton("Entendido") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Botón para iniciar el juego
        binding.btnStart.setOnClickListener {
            findNavController().navigate(
                com.gabrielfrankkrisnazelaflores.juegodecolores.R.id.action_welcome_to_game
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
