package Modelo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class universidad {

    public static void main(String[] args) {
        // Ruta del archivo Excel en formato OLE2 (.xls)
        String archivoExcel = "E:\\MARCELA\\Universidad\\TALLER DE PROGRAMACION\\Documentos\\Carnes_Universitarios_2018.xls";

        try (FileInputStream file = new FileInputStream(archivoExcel)) {
            Workbook workbook = new HSSFWorkbook(file); // Utiliza HSSFWorkbook para archivos .xls
            Sheet sheet = workbook.getSheetAt(0); // Obtén la primera hoja del libro

            // Itera sobre las filas de la hoja
            for (Row row : sheet) {
                // Obtén la celda correspondiente a NOMBRE_UNIVERSIDAD (segunda columna, índice 1)
                Cell cellNombreUniversidad = row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                if (cellNombreUniversidad != null) {
                    // Verifica el tipo de celda
                    switch (cellNombreUniversidad.getCellType()) {
                        case STRING:
                            String nombreUniversidad = cellNombreUniversidad.getStringCellValue();
                            System.out.println("Nombre de Universidad: " + nombreUniversidad);
                            break;
                        case BLANK:
                            System.out.println("Celda vacía encontrada");
                            break;
                        default:
                            System.out.println("Tipo de celda no manejado");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            // Manejo básico de errores, imprime el rastreo de la excepción
            e.printStackTrace();
        }
    }
}