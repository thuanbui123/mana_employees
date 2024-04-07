/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ExportDataUtils {

    public void exportTable(JTable table) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Excel File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

        // Show the file chooser dialog
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File fileToSave = fileChooser.getSelectedFile();

            // Create a new Excel workbook
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Get row and column counts from JTable
            int rowCount = table.getRowCount();
            int colCount = table.getColumnCount();

            // Iterate through the JTable and write data to Excel
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < colCount; j++) {
                    Object value = table.getValueAt(i, j);
                    if (value != null) {
                        row.createCell(j).setCellValue(value.toString());
                    }
                }
            }
            // Save the workbook to the selected file
            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                workbook.write(fos);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Hủy chọn file");
        }
    }
}
