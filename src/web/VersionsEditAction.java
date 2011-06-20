package web;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import session.LicenseKeeper;
import session.PersistException;

import persistance.*;

public class VersionsEditAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			LicensedObjectVersionForm versionForm = (LicensedObjectVersionForm) form;
			Context context = new InitialContext();
			LicenseKeeper licenseKeeper = (LicenseKeeper) context
					.lookup("LicenseKeeper/LicenseKeeperBean/local");
			int id = Integer.parseInt(request.getParameter("licensedObjectId"));
			LicensedObjectVersion licensedObject = licenseKeeper.getLicensedObjectVersion(id);
			versionForm.setId(id);
			versionForm.setMajor(licensedObject.getMajor());
			versionForm.setMinor(licensedObject.getMinor());
			versionForm.setBuild(licensedObject.getBuild());
			versionForm.setLicensedObject(licensedObject.getLicensedObject());
			
			List<LicensedObjectVersion> licensedObjectsVersions = licenseKeeper
					.getLicensedObjectVersions(id);
			request.setAttribute("licensedObjectsVersions", licensedObjectsVersions);
			
		} catch (PersistException ex) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"bd.probleme"));
			ex.printStackTrace();
		} catch (NamingException e) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"bd.probleme"));
			e.printStackTrace();
		}
		return mapping.getInputForward();
	}
}