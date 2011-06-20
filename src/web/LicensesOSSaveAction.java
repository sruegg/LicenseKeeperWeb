package web;

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

public class LicensesOSSaveAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			LicensedObjectOSForm OSForm = (LicensedObjectOSForm) form;
			Context context = new InitialContext();
			LicenseKeeper licenseKeeper = (LicenseKeeper) context
					.lookup("LicenseKeeper/LicenseKeeperBean/local");
			LicensedObject licensedObject = new LicensedObjectOperatingSystem(
					OSForm.getId(), OSForm.getPublisher(), OSForm.getName(),
					OSForm.getDescription(), OSForm.getServicePackVersion());
			licenseKeeper.saveLicensedObject(licensedObject);
		} catch (PersistException ex) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"bd.probleme"));
			saveErrors(request, messages);
			System.out.println(ex.getMessage());
			return mapping.getInputForward();
		} catch (NamingException ex) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"bd.probleme"));
			saveErrors(request, messages);
			System.out.println(ex.getMessage());
			return mapping.getInputForward();
		}
		return mapping.findForward("licensesList");
	}
}