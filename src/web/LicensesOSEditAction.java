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

public class LicensesOSEditAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			LicensedObjectOSForm OSForm = (LicensedObjectOSForm) form;
			Context context = new InitialContext();
			LicenseKeeper licenseKeeper = (LicenseKeeper) context
					.lookup("LicenseKeeper/LicenseKeeperBean/local");
			if (request.getParameter("licensedObjectId") != null) {
				int id = Integer.parseInt(request
						.getParameter("licensedObjectId"));
				LicensedObjectOperatingSystem licensedObject = licenseKeeper
						.getLicensedObjectOperatingSystem(id);
				OSForm.setId(id);
				OSForm.setPublisher(licensedObject.getPublisher());
				OSForm.setName(licensedObject.getName());
				OSForm.setDescription(licensedObject.getDescription());
				OSForm.setServicePackVersion(licensedObject
						.getServicePackVersion());
				OSForm.setCategory(licensedObject.getCategory().getId());

				List<LicensedObjectVersion> licensedObjectsVersions = licenseKeeper
						.getLicensedObjectVersions(id);
				request.setAttribute("licensedObjectsVersions",
						licensedObjectsVersions);
			}
			OSForm.setCategories(licenseKeeper.getCategories());

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