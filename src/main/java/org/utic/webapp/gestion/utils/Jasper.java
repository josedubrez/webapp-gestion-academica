package org.utic.webapp.gestion.utils;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.utic.webapp.gestion.entities.EntityWithId;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jasper {
    public static void generateReport(List<? extends EntityWithId> dataList, String jasperFile) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        try {
            // Ruta del archivo .jasper dentro de resources
            InputStream reportStream = Jasper.class.getClassLoader().getResourceAsStream(jasperFile);
            if (reportStream == null) {
                System.err.println("El archivo " + jasperFile + " no se encontró en la ruta especificada.");
                return;
            }

            // Parámetros para el reporte
            Map<String, Object> parameters = new HashMap<>();

            // Crea el JRBeanCollectionDataSource con la lista
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

            // Llenado del reporte con el DataSource basado en la lista
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, dataSource);

            // Configuración del PDF en la respuesta HTTP
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=\"reporte.pdf\"");

            // Exportar a PDF
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            exporter.exportReport();

            facesContext.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
