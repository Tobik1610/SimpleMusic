package logic;

public enum Sounds {

	SNARE("resources/sounds/drum/snare.wav"),
	KICK("resources/sounds/drum/kick.wav"),
	CRASH("resources/sounds/drum/crash.wav"),
	LOW_TOM("resources/sounds/drum/low_tom.wav"),
	MEDIUM_TOM("resources/sounds/drum/medium_tom.wav"),
	HIGH_TOM("resources/sounds/drum/high_tom.wav"),
	OPEN_HIHAT("resources/sounds/drum/open_hihat.wav"),
	CLOSED_HIHAT("resources/sounds/drum/closed_hihat.wav");
	
	private String fileName;
	
	Sounds(String fileName){
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return fileName;
	}
}
