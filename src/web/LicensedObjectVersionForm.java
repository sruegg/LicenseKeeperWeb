package web;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import persistance.LicensedObject;
import persistance.LicensedObjectKey;

public class LicensedObjectVersionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int major;
	private int minor;
	private int build;
	private LicensedObject licensedObject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	public LicensedObject getLicensedObject() {
		return licensedObject;
	}

	public void setLicensedObject(LicensedObject licensedObject) {
		this.licensedObject = licensedObject;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		licensedObject = null;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		if (major < 1) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"erreur.major"));
		}
		return errors;
	}
}