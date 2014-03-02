package br.com.secoti.report;

public enum ReportsTypes {
	XML,HTML,PDF,XLS;
	
	public static ReportsTypes getReportType(String type) {
		for(ReportsTypes r : ReportsTypes.values()) {
			if(r.toString().equalsIgnoreCase(type)) {
				return r;
			}
		}
		return null;
	}
	
	
}
