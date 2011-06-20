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

import session.LicenseKeeper;
import session.PersistException;

import persistance.*;

public class LicensesListAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Context context = new InitialContext();
			LicenseKeeper licenseKeeper = (LicenseKeeper) context
					.lookup("LicenseKeeper/LicenseKeeperBean/local");
			List<LicensedObjectOperatingSystem> licensedObjectsOS = licenseKeeper
					.getLicensedObjectsOperatingSystem();
			request.setAttribute("licensedObjectsOS", licensedObjectsOS);
			List<LicensedObjectSoftware> licensedObjectsSW = licenseKeeper
					.getLicensedObjectsSoftware();
			request.setAttribute("licensedObjectsSW", licensedObjectsSW);
		} catch (PersistException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return mapping.findForward("listing");
	}
}