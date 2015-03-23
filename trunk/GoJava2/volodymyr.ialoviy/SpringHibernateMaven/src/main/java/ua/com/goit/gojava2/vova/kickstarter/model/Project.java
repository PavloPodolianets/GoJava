package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROJECTS")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProject;
	
	@NotNull
	@Id
	@Column(name = "ID_CATEGORY")
	private String idCategory;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Size(min = 15, max = 250)
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
	@Size(min = 30, max = 500)
	@Column(name = "FULL_DESCRIPTION")
	private String fullDescription;
	
	@Column(name = "FOTO")
	private String foto;
	
	@Column(name = "LINK")
	private String link;
	
	@NotNull
	@Column(name = "HOW_MUCH_NEEDED")
	private int howMuchNeeded;
	
	@NotNull
	@Column(name = "HOW_MUCH_COLLECTED")
	private int howMuchCollected;
	
	@NotNull
	@Column(name = "HOW_MUCH_REMAINING")
	private int howMuchRemaining;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATE_CLOSE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateClose;
	
	private ArrayList<String> faq;
	
	public int getId() {
		return idProject;
	}

	public void setId(int id) {
		this.idProject = id;
	}

	public String getIdCategpry() {
		return idCategory;
	}

	public void setIdCategpry(String idCategpry) {
		this.idCategory = idCategpry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getHowMuchNeeded() {
		return howMuchNeeded;
	}

	public void setHowMuchNeeded(int howMuchNeeded) {
		this.howMuchNeeded = howMuchNeeded;
	}

	public int getHowMuchCollected() {
		return howMuchCollected;
	}

	public void setHowMuchCollected(int howMuchCollected) {
		this.howMuchCollected = howMuchCollected;
	}

	public int getHowMuchRemaining() {
		return howMuchRemaining;
	}

	public void setHowMuchRemaining(int howMuchRemaining) {
		this.howMuchRemaining = howMuchRemaining;
	}

	public LocalDate getDateClose() {
		return dateClose;
	}

	public void setDateClose(LocalDate dateClose) {
		this.dateClose = dateClose;
	}

	public ArrayList<String> getFaq() {
		return faq;
	}

	public void setFaq(ArrayList<String> faq) {
		this.faq = faq;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (idProject != other.idProject)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [idProject=" + idProject + ", name=" + name + ", dateClose="
				+ dateClose + "]";
	}

}