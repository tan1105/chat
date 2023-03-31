package app;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users1")
public class User {
	//1. khai báo dữ liệu
		@Id
		String texts;
		//2. constructor
		public User() {
			super();
		}	
		//3. getter + setter
		public String getTexts() {
			return texts;
		}
		public void setTexts(String texts) {
			this.texts = texts;
		}
		
}
