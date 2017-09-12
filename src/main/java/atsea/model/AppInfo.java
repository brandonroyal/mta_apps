package atsea.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="appinfo")
public class AppInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="label")
	private String label;
	
	@Column (name="value")
	private String value;
	
	public String getLabel() {
		return label;
	}
	
	public String getValue() {
		return value;
	}

}
