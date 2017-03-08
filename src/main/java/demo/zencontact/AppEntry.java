package demo.zencontact;

import act.Act;
import org.joda.time.DateTime;
import org.osgl.mvc.annotation.GetAction;

import static act.controller.Controller.Util.render;

/**
 * ZenContact application entry
 * <p>Run this app, try to update some of the code, then
 * press F5 in the browser to watch the immediate change
 * in the browser!</p>
 */
@SuppressWarnings("unused")
public class AppEntry {

    @GetAction
    public void index() {
        DateTime now = DateTime.now();
        render(now);
    }

    public static void main(String[] args) throws Exception {
        Act.start("Zen Contact");
    }


}
