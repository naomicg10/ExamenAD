package cesur.examen.core.common;

import cesur.examen.core.worker.Worker;

import java.io.*;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Naomi Camuña González
 * Fecha: 11-12-2023
 *
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */


public class FileUtils {

    public static void toCSV(String fileName, List<Worker> workers) {
        //throw new RuntimeException("Not implemented yet!");

        //Uncomment and implement body method!...
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Worker worker : workers) {
                writer.write(worker.getId() + "," + worker.getName() + "," + worker.getDni() + "," + worker.getFrom() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
        }
    }
}
