package vn.iostar.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="categories")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryid")
	private int id;
	@Column(name="categoryname", columnDefinition = "nvarchar(255) not null")
	@NotEmpty(message = "không được bỏ trống")
	private String name;
	@Column(name="images", columnDefinition = "nvarchar(500) null")
	private String images;
	@Column(name="status")
	private int status;
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public CharSequence getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(CharSequence name2) {
		// TODO Auto-generated method stub
		
	}
	
}
