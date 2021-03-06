package org.caalpeva.report.csv.opencsv;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.caalpeva.report.csv.CsvReportLine;
import org.caalpeva.report.csv.CsvReportReader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * Clase encargada de facilitar la lectura de los datos de los pedidos en formato CSV  
 * @author Alberto
 */
public class OpenCsvReportReader implements CsvReportReader {

	private CsvToBean<CsvReportLine> csvToBean;
	
	public OpenCsvReportReader(FileReader fileReader) {
		csvToBean = new CsvToBeanBuilder<CsvReportLine>(fileReader)
                .withType(OpenCsvReportLine.class)
                .withIgnoreLeadingWhiteSpace(true)
                //.withKeepCarriageReturn(false)
                .build();
	}
	
	public List<CsvReportLine> parse() {
		return csvToBean.parse();
	}

	@Override
	public Iterator<CsvReportLine> iterator() {
		return csvToBean.iterator();
	}

}
