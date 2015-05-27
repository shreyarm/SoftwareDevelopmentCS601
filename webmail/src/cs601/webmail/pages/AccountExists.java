package cs601.webmail.pages;

/**
 * Created by shreyarajani on 4/25/15.
 */
import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountExists extends Page {
    public AccountExists(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        return templates.getInstanceOf("accountexists");
    }

    @Override
    public ST getTitle() {
        return new ST("Account Exists");
    }
}
