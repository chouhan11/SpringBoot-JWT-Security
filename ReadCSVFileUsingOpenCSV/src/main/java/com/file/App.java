package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.file.model.StateDetails;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class App {
	public static void main(String[] args) {

		// Hashmap to map CSV data to Bean attributes.
		// read CSV file with specific column name
		Map<String, String> mapping = new HashMap<String, String>();

		mapping.put("street", "street");
		mapping.put("city", "city");
		mapping.put("zip", "zip");
		mapping.put("state", "state");
		mapping.put("beds", "beds");
		mapping.put("baths", "baths");
		mapping.put("sq_ft", "sq_ft");
		mapping.put("type", "type");
		mapping.put("sale", "sale");
		mapping.put("date", "date");
		mapping.put("price", "price");
		mapping.put("latitude", "latitude");
		mapping.put("longitude", "longitude");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<StateDetails> strategy = new HeaderColumnNameTranslateMappingStrategy<StateDetails>();
		strategy.setType(StateDetails.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("statedetails.csv"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<StateDetails> list = csvToBean.parse(strategy, csvReader);

		// print details of Bean object
		for (StateDetails e : list) {
			System.out.println(e.getPrice());
		}
	}
}
