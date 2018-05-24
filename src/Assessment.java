
public class Assessment {
	private String assesmentId;
	private String AssesmentFormat;
	private String AssesmentLastDate;
	private String TypeOfAssesment;
	private String AssesmentTopic;
	private boolean graded;
	public String getAssesmentId() {
		return assesmentId;
	}
	public void setAssesmentId(String assesmentId) {
		this.assesmentId = assesmentId;
	}
	public String getAssesmentFormat() {
		return AssesmentFormat;
	}
	public void setAssesmentFormat(String assesmentFormat) {
		AssesmentFormat = assesmentFormat;
	}
	public String getAssesmentLastDate() {
		return AssesmentLastDate;
	}
	public void setAssesmentLastDate(String assesmentLastDate) {
		AssesmentLastDate = assesmentLastDate;
	}
	public String getTypeOfAssesment() {
		return TypeOfAssesment;
	}
	public void setTypeOfAssesment(String typeOfAssesment) {
		TypeOfAssesment = typeOfAssesment;
	}
	public String getAssesmentTopic() {
		return AssesmentTopic;
	}
	public void setAssesmentTopic(String assesmentTopic) {
		AssesmentTopic = assesmentTopic;
	}
	public boolean isGraded() {
		return graded;
	}
	public void setGraded(boolean graded) {
		this.graded = graded;
	}
	

}
