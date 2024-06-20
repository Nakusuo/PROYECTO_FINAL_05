
package Controlador;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class proyectofinal {
    public static void main(String[] args) {
        String archivoExcel = "E:\\MARCELA\\Universidad\\TALLER DE PROGRAMACION\\Documentos\\Carnes_Universitarios_2018.xls";

        try (FileInputStream file = new FileInputStream(archivoExcel)) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre las filas
            for (Row row : sheet) {
                // Iterar sobre las celdas de cada fila
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
                        default -> {
                        }
                    }
                    // Manejo para otros tipos de celda si es necesario
                                    }
                System.out.println(); // Salto de línea después de cada fila
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción en caso de error
        }
    }
}