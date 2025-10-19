# Juego de Colores – Gabriel Frank Krisna Zela Flores

**Gabriel Frank Krisna Zela Flores**  
Programacion para Dispositivos Móviles – Examen Parcial 2025

---

## Descripción general

**“Juego de Colores”** es una aplicación Android desarrollada en **Kotlin** con **Android Studio**, que pone a prueba los reflejos y la atención del jugador.  
El usuario debe **elegir el color correcto** que aparece en pantalla antes de que se acabe el tiempo ⏱️.  

El juego incluye **sonidos interactivos**, **animaciones suaves**, un sistema de **puntaje dinámico** y una **pantalla de resultados**.  
El diseño utiliza un fondo colorido, botones llamativos y una interfaz amigable para el usuario.

---


## Flujo del juego

### 1. Pantalla de Bienvenida (`WelcomeFragment`)
- Muestra el título “Juego de Colores – Gabriel Zela”.
- Fondo colorido (`bg_colores.jpg`).
- Botón **“Iniciar juego”** que lleva al jugador al juego principal.

### 2. Pantalla de Juego (`GameFragment`)
- Muestra un cuadro con un color aleatorio.
- El jugador debe presionar el botón del color correcto.
- Cada acierto **suma puntos**.
- Temporizador de **30 segundos**.
- **Sonidos y animación de parpadeo** al acertar o fallar.
- Música de fondo mientras se juega.

### 3. Pantalla de Resultados (`ResultFragment`)
- Muestra el **puntaje final** y el **récord más alto**.
- Animación suave de aparición (`fade_in.xml`).
- Botones:
- **Jugar de nuevo**
- **Volver al inicio**

---

## Funcionalidad adicional implementada: Sonidos

Se añadió soporte de audio con **MediaPlayer**:

| Evento | Archivo | Descripción |
|--------|----------|-------------|
| Acierto | `correct.mp3` | Se reproduce cuando el jugador acierta |
| Error | `wrong.mp3` | Suena al fallar |
| Fondo | `bg_music.mp3` | Música ambiental durante el juego |

---

## Animaciones

- **`blink.xml`** → parpadeo leve al acertar un color.  
- **`fade_in.xml`** → efecto de entrada suave en los resultados.  

Estas animaciones hacen el juego más dinámico sin distraer al jugador.

---

## Conclusión

El **Juego de Colores** es una demostración de:
- Uso de **Navigation Component** con múltiples fragments.  
- Implementación de **animaciones, sonidos y UI interactiva**.  
- Buenas prácticas en la estructura y organización del código.  
- Interfaz visualmente atractiva y funcional.  


### Proyecto desarrollado por:
**Gabriel Frank Krisna Zela Flores**  
*Fecha de entrega:* Octubre 2025  


