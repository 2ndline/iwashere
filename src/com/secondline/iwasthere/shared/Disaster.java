package com.secondline.iwasthere.shared;

public enum Disaster {

	NineEleven("9/11", "911.png", "New York", "Midtown"), OKC("Oklahoma City", "okc.png", "Oklahoma City", "That place"), Katrina(
			"Hurricane Katrina", "katrina.png", "New Orleans", "I-10 overpass"), Hiroshima("Hiroshima",
			"hiroshima.png", "Hiroshima", "that jap place"), BostonMarathon("Boston Marathon", "boston.png", "Boston", "a can of beans");
	String title;
	String pictureUrl;
	private String place;
	private String landmark;

	Disaster(String title, String url, String location, String lm) {
		this.title = title;
		this.pictureUrl = url;
		place = location;
		landmark = lm;
	}

	public String getTitle(){
		return this.title;
	}
	
	public String getUrl(){
		return this.pictureUrl;
	}

	public static Disaster getDisasterByName(String name){
		for(Disaster d : values()){
			if(d.getTitle().equals(name))
				return d;
		}
		
		return null;
	}

	public String getPlace() {
		return place;
	}

	public String getLandmark(){
		return landmark;
	}
}
