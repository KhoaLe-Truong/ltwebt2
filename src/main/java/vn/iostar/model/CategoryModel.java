package vn.iostar.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryModel implements Serializable {
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
	
	private Boolean isEdit = false;

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	public boolean getIsEdit() {
		// TODO Auto-generated method stub
		return false;
	}
}