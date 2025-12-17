package music.player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "Your filepath";
        File file = new File(filePath);

        // Variables de estado
        int userInput = 0;
        long clipPosition = 0; // Para guardar dónde pausamos

        try {
            // 1. Cargar el audio FUERA del bucle
            // Usamos AudioSystem para obtener el stream y el clip
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip audioClip = AudioSystem.getClip();

            // 2. Abrir el clip (CORRECCIÓN DEL ERROR PRINCIPAL)
            audioClip.open(audioStream);

            do {
                System.out.println("\n--- RBK MUSIC PLAYER ---");
                System.out.println("1. Play (Desde el inicio)");
                System.out.println("2. Pause");
                System.out.println("3. Resume (Continuar)");
                System.out.println("4. Stop (Reiniciar)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                // Validación para evitar error si meten letras
                if (scanner.hasNextInt()) {
                    userInput = scanner.nextInt();
                } else {
                    scanner.next(); // Limpiar buffer
                    continue;
                }

                switch (userInput) {
                    case 1: // PLAY (Desde 0)
                        audioClip.setMicrosecondPosition(0);
                        audioClip.start();
                        System.out.println("Status: Playing from start");
                        break; // IMPORTANTE: break para no seguir ejecutando los otros casos

                    case 2: // PAUSE
                        if (audioClip.isRunning()) {
                            clipPosition = audioClip.getMicrosecondPosition(); // Guardar posición
                            audioClip.stop();
                            System.out.println("Status: Paused");
                        }
                        break;

                    case 3: // RESUME
                        if (!audioClip.isRunning()) {
                            // Si ya se había pausado, recuperamos la posición, si no, sigue donde estaba
                            // Nota: clip.start() por defecto continua donde se quedó,
                            // pero es bueno asegurarse.
                            audioClip.setMicrosecondPosition(clipPosition);
                            audioClip.start();
                            System.out.println("Status: Resuming");
                        }
                        break;

                    case 4: // STOP (Detener y rebobinar)
                        audioClip.stop();
                        audioClip.setMicrosecondPosition(0);
                        clipPosition = 0;
                        System.out.println("Status: Stopped");
                        break;

                    case 5: // EXIT
                        System.out.println("Closing player...");
                        audioClip.close(); // Cerrar recursos al final
                        break;

                    default:
                        System.out.println("Invalid option");
                }

            } while (userInput != 5);

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Error: El formato del archivo no es soportado (.wav requerido)");
        } catch (IOException e) {
            System.out.println("Error: No se encuentra el archivo en la ruta: " + filePath);
        } catch (LineUnavailableException e) {
            System.out.println("Error: Audio line no disponible");
        } finally {
            scanner.close();
            System.out.println("Thanks for using rbk music player 😉");
        }
    }
}