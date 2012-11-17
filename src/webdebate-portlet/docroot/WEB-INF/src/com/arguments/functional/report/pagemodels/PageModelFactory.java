/**
 * 
 */
package com.arguments.functional.report.pagemodels;

import com.arguments.application.TheContainerBridge;
import com.arguments.functional.requeststate.ArgsJspRenderRequest;
import com.arguments.functional.requeststate.ArgsStatefulRequest3;
import com.arguments.functional.requeststate.ProtocolMap;

/**
 * @author mirleau
 *
 */
public class PageModelFactory
{
    public final static ProtocolMap theProtocol =
            TheContainerBridge.i().getProtocolMap();

    // ------------------------------------------------------------------------
    public static AddOpinionPageModel getAddOpinionPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();

        return new AddOpinionPageModel(myRequest, theProtocol);
    }

    // ------------------------------------------------------------------------
    public static AddPremisePageModel getAddPremisePage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();
        
        return new AddPremisePageModel(myRequest, theProtocol);
    }

    // ------------------------------------------------------------------------
    public static AddThesisPageModel getAddThesisPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        aRenderRequest.storeGet();
        return new AddThesisPageModel(theProtocol);
    }

    // ------------------------------------------------------------------------
    public static ChangePerspectivePageModel getChangePerspectivePage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();

        return new ChangePerspectivePageModel(myRequest, theProtocol);
    }

    // ------------------------------------------------------------------------
    public static EditThesisPageModel getEditThesisPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();
        return new EditThesisPageModel(myRequest, theProtocol);
    }

    // ------------------------------------------------------------------------
    public static GotoThesisPageModel getGotoThesisPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        aRenderRequest.storeGet();
        return new GotoThesisPageModel(theProtocol);
    }
    
    // ------------------------------------------------------------------------
    public static ListThesesPageModel getListThesesPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();

        return new ListThesesPageModel(myRequest, theProtocol, aRenderRequest.getErrorHandler());
    }

    // ------------------------------------------------------------------------
    public static ThesisFocusPageModel getThesisFocusPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();

        return new ThesisFocusPageModel(myRequest, theProtocol, aRenderRequest.getErrorHandler());
    }

    // ------------------------------------------------------------------------
    public static EditLinkPageModel getEditLinkPage(
            ArgsJspRenderRequest aRenderRequest)
    {
        ArgsStatefulRequest3 myRequest = aRenderRequest.storeGet();

        return new EditLinkPageModel(myRequest,  theProtocol);
    }
}
