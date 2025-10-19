/*
Autor: Gabriel Frank Krisna Zela Flores
Descripción: Esta es la actividad principal del juego, donde se encuentra el NavHostFragment.
              Básicamente se encarga de manejar la navegación entre las diferentes pantallas (fragments)
Fecha creación: 16/10/2025
Última modificación: 16/10/2025
*/


package com.gabrielfrankkrisnazelaflores.juegodecolores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabrielfrankkrisnazelaflores.juegodecolores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding para acceder al layout sin findViewById()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflamos el layout usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
