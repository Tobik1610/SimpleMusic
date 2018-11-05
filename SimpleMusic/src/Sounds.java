
public enum Sounds {

	SNARE("resources/sounds/drum/snare.wav"),
	KICK("resources/sounds/drum/kick.wav"),
	CLOSED_HIHAT("resources/sounds/drum/closed_hihat.wav");
	
	private String fileName;
	
	Sounds(String fileName){
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return fileName;
	}
}
