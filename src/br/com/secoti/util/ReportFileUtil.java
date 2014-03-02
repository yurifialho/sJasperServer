package br.com.secoti.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yuri Fialho
 * @since  01/03/2014
 *
 */
public class ReportFileUtil {
	
	/* -- ATRIBUTOS -- */
	private static List<ReportFileUtil> relatorios = new ArrayList<ReportFileUtil>();
	
	private String cleanName;
	private String name;
	private File   relatorio;
	
	/* -- CONTRUTORES -- */
	
	public ReportFileUtil(File relatorio) {
		this.relatorio = relatorio;
		this.name      = relatorio.getName();
		this.cleanName = this.name.split("/.")[0];
	}
	
	/* -- GETTERS AND SETTERS -- */
	
	public String getCleanName() {
		return cleanName;
	}

	public void setCleanName(String cleanName) {
		this.cleanName = cleanName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(File relatorio) {
		this.relatorio = relatorio;
	}
	
	public static List<ReportFileUtil> getRelatorios() {
		return relatorios;
	}
	
	/* -- OPERACOES  -- */

	public static boolean exists(String reportName) {
		return exists(new File(PropUtil.get("reports-path")), reportName);
	}
	
	public static boolean exists(File path, String reportName) {
		try {
			for(File file : path.listFiles()) {
				if(file.isFile() && file.getName().equals(reportName + ".jasper")) {
					return true;
				}
				if(file.isDirectory()) {
					return exists(file, reportName);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void loadReports() {
		loadReports(new File(PropUtil.get("reports-path")));
	}
	
	public static void loadReports(File path) {
		try {
			for(File file : path.listFiles()) {
				if(file.isFile() && file.getName().endsWith(".jasper")) {
					relatorios.add(new ReportFileUtil(file));
				}
				if(file.isDirectory()) {
					loadReports(file);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return this.cleanName + " - " + this.name + " - " + this.relatorio.getAbsolutePath();
	}
}