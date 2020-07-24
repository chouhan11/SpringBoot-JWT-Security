package com.file.model;

import lombok.Data;

@Data
public class StateDetails {

	private static final long serialVersionUID = 1L;

	private String street;
	private String city;
	private String zip;
	private String state;
	private String beds;
	private String baths;
	private String sq_ft;
	private String type;
	private String sale;
	private String date;
	private String price;
	private String latitude;
	private String longitude;
}
