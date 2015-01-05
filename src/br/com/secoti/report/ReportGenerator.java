package br.com.secoti.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import br.com.secoti.util.ReportFileUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;

/**
 * 
 * @author Yuri Fialho
 * @since  02/03/2014
 *
 */
public class ReportGenerator {
	
	public static void generate(String reportName, ReportsTypes type,
			Map<String, Object> params, OutputStream out, Connection conn) throws FileNotFoundException, JRException {
		ReportFileUtil rFile = ReportFileUtil.getReport(reportName);
		JasperPrint jPrint = JasperFillManager.fillReport(new FileInputStream(rFile.getRelatorio()), params, conn);
		
		switch (type) {
			case PDF:
				makePdf(jPrint, out);
				break;
			case XLS:
				makeXls(jPrint, out);
				break;
			case HTML:
				makeHtml(jPrint, out);
				break;
			case XML:
				makeXml(jPrint, out);
				break;
			default:
				break;
		}
	}

	private static void makeXml(JasperPrint jPrint, OutputStream out) throws JRException {
		JRXmlExporter exporter = new JRXmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
	}

	private static void makeHtml(JasperPrint jPrint, OutputStream out) throws JRException {
		JRHtmlExporter exporter = new JRHtmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
	}

	private static void makeXls(JasperPrint jPrint, OutputStream out) throws JRException {
		JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
	}

	private static void makePdf(JasperPrint jPrint, OutputStream out) throws JRException {
		JasperExportManager.exportReportToPdfStream(jPrint, out);
	}
	
}
