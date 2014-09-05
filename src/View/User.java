package View;

import java.sql.Date;

public class User {

	private String Username;
	private String Email;
	private String FirstName;
	private String LastName;
	private Date BirthDate;

	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [Username=" + Username + ", Email=" + Email
				+ ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", BirthDate=" + BirthDate + "]";
	}

	
}
