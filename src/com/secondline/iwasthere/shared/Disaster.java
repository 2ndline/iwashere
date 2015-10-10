package com.secondline.iwasthere.shared;

public enum Disaster {

	NineEleven("9/11", "911.jpg", "New York", "Midtown"),

	OKC("Oklahoma City Bombing", "okc.jpg", "Oklahoma City",
			"the federal building"),

	Katrina("Hurricane Katrina", "katrina.jpg", "New Orleans", "I-10 overpass"),

	BostonMarathon("Boston Marathon Bombing", "boston.jpg", "Boston",
			"a can of beans"),

	Hiroshima("Hiroshima", "hiroshima.jpg", "Hiroshima", "that lotus tree"),

	MoonLanding("Moon Landing", "moonlanding.jpg", "Los Angeles", "sound stage"),

	PLACEHOLDER("---", "", "", ""),

	ObamaTakeover("Obama Takes Our Guns", "911.jpg", "", ""),

	TrumpPres("Donald Trump Presidency", "911.jpg", "", ""),

	;

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

	public String getTitle() {
		return this.title;
	}

	public String getUrl() {
		return this.pictureUrl;
	}

	public static Disaster getDisasterByName(String name) {
		for (Disaster d : values()) {
			if (d.getTitle().equals(name))
				return d;
		}

		return null;
	}

	public String getPlace() {
		return place;
	}

	public String getLandmark() {
		return landmark;
	}

	public String getScript(String activity, String place) {

		String result = "";
		switch (this) {
		case Katrina:
			result = "So there I was, "
					+ activity
					+ " at "
					+ place
					+ ". Da city was empty and had this eerie quiet to it. All of sudden Katrina happened. It was crazy. "
					+ " I snuck into my rich neighbor's backyard to get his boat, then we went over to the I-10 overpass and got a helicopter to pick us up.";
			break;

		case MoonLanding:
			result = "So there I was, a struggling actor in Los Angeles, when my agent gives me a call about working with Stanley Kubrick. "
					+ "I get a side to read for a character named 'Buzz Aldrin'. ";
			break;
		case NineEleven:
			result = "So there I was, doing "
					+ activity
					+ " at "
					+ place
					+ ", when suddenly "
					+ title
					+ " happens. It was crazy. I'm in the second tower and I just feel this jostling all over the place and then the Port Authority "
					+ "came on the loudspeaker and they're like 'things are being taken care of everyone remain where you are stay calm'. So I leave and I'm by "
					+ landmark
					+ " and that's when I realize that it's really bad.";
			break;
		default:
			result = "So there I was, " + activity + " at " + place
					+ ", when suddenly " + title
					+ " happens. It was crazy. I'm in " + place
					+ " and I just feel this jostling. So I leave and I'm by "
					+ landmark
					+ " and that's when I realize that it's really bad.";
		}

		return result;
	}
}
