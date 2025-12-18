# 🎵 RBK Music Player

> Un reproductor de música de consola ligero y eficiente desarrollado en Java.

Este proyecto es una aplicación de línea de comandos (CLI) que permite reproducir archivos de audio `.wav` utilizando la librería nativa `javax.sound.sampled` de Java. Fue creado con el objetivo de profundizar en el manejo de **Streams de Audio**, **Manejo de Excepciones** y **Lógica de Control de Flujo** en Java.

## 🚀 Características

* **Reproducción:** Inicia la música desde el principio.
* **Pausa Inteligente:** Detiene la música guardando el micro-segundo exacto.
* **Reanudar (Resume):** Continúa la reproducción exactamente donde la dejaste.
* **Stop:** Detiene y rebobina la pista al inicio.
* **Interfaz de Menú:** Navegación sencilla mediante opciones numéricas en consola.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 8+)
* **Librería de Audio:** `javax.sound.sampled` (API nativa de Java)
* **Entrada de Datos:** `java.util.Scanner`
* **Manejo de Archivos:** `java.io.File`

## 📋 Requisitos Previos

Para ejecutar este proyecto necesitas:
1.  Tener instalado el **JDK (Java Development Kit)**.
2.  Un IDE (IntelliJ IDEA, Eclipse) o una terminal.
3.  Un archivo de audio en formato **.wav** (Java Clip no soporta MP3 nativamente).

## 🔧 Configuración y Uso

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Jsuarez04/rbk-music-player.git
    ```
2.  **Configurar el Audio:**
    * Coloca tu archivo `.wav` en la carpeta `src`.
    * Abre el archivo `Input.java` y asegúrate de que la ruta coincida con el nombre de tu canción:
    ```java
    String filePath = "src/tu_cancion.wav";
    ```
3.  **Ejecutar:**
    Compila y corre la clase `Input.java`. Verás el siguiente menú:

    ```text
    --- RBK MUSIC PLAYER ---
    1. Play (Desde el inicio)
    2. Pause
    3. Resume (Continuar)
    4. Stop (Reiniciar)
    5. Exit
    ```

## 🔮 Futuras Mejoras (Roadmap)

* [ ] Agregar un selector de archivos (JFileChooser) para elegir cualquier canción.
* [ ] Soporte para listas de reproducción (Playlists).
* [ ] Interfaz Gráfica (GUI) usando Swing o JavaFX.
* [ ] Soporte para archivos MP3 (usando librerías externas).

## 👤 Autor

Desarrollado por **[Tu Nombre]**.
*Estudiante de Desarrollo de Software.*

---
*Gracias por usar RBK Music Player 😉*
