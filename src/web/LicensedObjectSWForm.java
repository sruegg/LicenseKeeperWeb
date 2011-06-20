package web;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import persistance.Category;

public class LicensedObjectSWForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String publisher;
	private String name;
	private String description;
	private int activationsLimit;
	private int category;
	private List<Category> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActivationsLimit() {
		return activationsLimit;
	}

	public void setActivationsLimit(int activationsLimit) {
		this.activationsLimit = activationsLimit;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		publisher = "";
		name = "";
		description = "";
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		if ((publisher == null) || (publisher.length() < 3)) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"erreur.publisher"));
		}
		return errors;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCategory() {
		return category;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Collection<Category> getCategories() {
		return categories;
	}
}