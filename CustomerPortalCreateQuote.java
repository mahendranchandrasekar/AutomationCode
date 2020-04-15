package co.uk.directlinegroup.tt.utils.common;

import co.uk.directlinegroup.tt.pages.CustomerPortalQuotePage;
import co.uk.directlinegroup.tt.utils.QuotesDetails;

import java.util.List;

public class CustomerPortalCreateQuote {

    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private QuotesDetails quotesDetailsObj = new QuotesDetails();

    public void createQuote(List<List<String>> parameters) throws Throwable {
        customerPortalQuotePageObj.getAQuoteLink();
        customerPortalQuotePageObj.getAQuoteLink().click();
        customerPortalQuotePageObj.nextbtn_GetAQuote();
        customerPortalQuotePageObj.nextbtn_GetAQuote().click();
        this.QuestioneriesInQuote(parameters);
    }

    public void QuestioneriesInQuote(List<List<String>> parameters) throws Throwable {
        for (int row = 1; row < parameters.size(); row++) {
            // boolean bClickSearchButton = true;
            for (int column = 0; column < parameters.get(0).size(); column++) {
                quotesDetailsObj.AnswerQuestioneries(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }
}