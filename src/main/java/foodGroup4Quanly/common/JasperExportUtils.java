package foodGroup4Quanly.common;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import org.springframework.stereotype.Component;

@Component
public class JasperExportUtils {

	public void export(String format, HttpServletResponse response, JasperPrint jasperPrint){
		if(format == null)
			format = "html";
		switch (format) {
		case "pdf":
			response.setContentType("application/pdf");
			
			try {
				JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "image":
			response.setContentType("image/png");
			JasperPrintManager printManager = JasperPrintManager.getInstance(DefaultJasperReportsContext.getInstance());
			BufferedImage rendered_image = null;      
	        try {
				rendered_image = (BufferedImage)printManager.printPageToImage(jasperPrint, 0,1.6f);
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	        try {
				ImageIO.write(rendered_image, "png", response.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			break;
		case "xlsx":
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			JRXlsxExporter xlsxExporter = new JRXlsxExporter();
			
			xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	        try {
	        	xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        SimpleXlsxReportConfiguration xlsxReportConfiguration = new SimpleXlsxReportConfiguration();
	        xlsxReportConfiguration.setOnePagePerSheet(false);
	        xlsxReportConfiguration.setShrinkToFit(true);
	        xlsxReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
	        xlsxReportConfiguration.setDetectCellType(false);
	        xlsxReportConfiguration.setWhitePageBackground(false);
	        xlsxExporter.setConfiguration(xlsxReportConfiguration);

	        try {
	        	xlsxExporter.exportReport();
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default://html
			response.setContentType("text/html;charset=UTF-8");
			HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			try {
				exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}
