/**
 * 
 */
package com.arguments.functional.report.html;

import static org.junit.Assert.*;

import com.arguments.functional.datamodel.ArgumentsUser;
import com.arguments.functional.datamodel.MPerspective;
import com.arguments.functional.datamodel.PerspectiveId;
import com.arguments.functional.datamodel.ThesisId;
import com.arguments.functional.report.ThesisFocusData;
import com.arguments.functional.requeststate.ArgsStatefulRequest3;
import com.arguments.functional.requeststate.ProtocolMap;
import com.arguments.functional.store.TheArgsStore;

/**
 * @author mirleau
 *
 */
public class ThesisFocusPage
{
    private final ArgumentsUser theAppUser;
    private final MPerspective thePerspectives = new MPerspective();
    private final ThesisId theThesisId;
    private final UrlContainer theUrlContainer;
    
    // ------------------------------------------------------------------------
    public static String getHtmlBody(
            ArgsStatefulRequest3 aRequest,
            ProtocolMap aProtocolMap)
    {
        final ThesisFocusPage theThesisFocusPage =
                new ThesisFocusPage(aRequest);
        
        return theThesisFocusPage.getHtmlBody(aProtocolMap);
    }

    // ------------------------------------------------------------------------
    static ThesisFocusData getData(ArgsStatefulRequest3 aRequest)
    {
        final ThesisFocusPage theThesisFocusPage =
                new ThesisFocusPage(aRequest);
        
        return theThesisFocusPage.getData();
    }

    // ------------------------------------------------------------------------
    public static String getInternalHtml(
            ArgsStatefulRequest3 aRequest,
            ProtocolMap aProtocolMap)
    {
        final ThesisFocusPage theThesisFocusPage =
                new ThesisFocusPage(aRequest);
        
        return theThesisFocusPage.getInternalHtml(aProtocolMap);
    }

    // ------------------------------------------------------------------------
    private ThesisFocusPage(ArgsStatefulRequest3 aRequest)
    {
        theAppUser = aRequest.getUser();
        theThesisId = aRequest.getState().getThesisId();
        theUrlContainer = aRequest.getUrlContainer();
        thePerspectives.add(aRequest.getState().getPerspective());
        PerspectiveId myPId2 = aRequest.getPerspective2Id();
        if (myPId2 != null)
            thePerspectives.add(TheArgsStore.i().getPerspective(myPId2));
        //Perspective myOther = TheArgsStore.i().getPerspective(new PerspectiveId(6L));
        //thePerspectives.add(myOther);
    }

    // ------------------------------------------------------------------------
    private String getHtmlBody(ProtocolMap aProtocolMap)
    {
        ThesisFocusData myThesisFocusData = getData();
        HtmlThesisPrinter myPrinter = new HtmlThesisPrinter(
                theUrlContainer, aProtocolMap);
        return myPrinter.focusPageToHtmlPage(myThesisFocusData);
    }

    // ------------------------------------------------------------------------
    private String getInternalHtml(ProtocolMap aProtocol)
    {
        ThesisFocusData myData = getData();
        HtmlThesisPrinter myPrinter = new HtmlThesisPrinter(
                theUrlContainer, aProtocol);
        return myPrinter.focusPageToInternalHtml(myData);
    }

    // ------------------------------------------------------------------------
    private ThesisFocusData getData()
    {
        assertNotNull(theThesisId);
        return TheArgsStore.i().getThesisFocusData(
                theThesisId, theAppUser, thePerspectives);
    }
}
