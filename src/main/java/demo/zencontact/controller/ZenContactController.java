package demo.zencontact.controller;

import act.app.ActionContext;
import act.controller.Controller;
import act.db.DbBind;
import act.db.morphia.MorphiaDao;
import demo.zencontact.model.Contact;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.annotation.PutAction;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static act.controller.Controller.Util.*;

/**
 * The ZenContact Controller
 */
@Controller("/contacts")
public class ZenContactController {

    @Inject
    private MorphiaDao<Contact> dao;

    @GetAction
    public void list() {
        List<Contact> contacts = dao.q().orderBy("name, firstName").asList();
        render(contacts);
    }

    @GetAction("{id}")
    public void form(String id) {
        Contact contact = "new".equals(id) ? null : dao.findById(id);
        render(contact);
    }

    @PutAction("{id}")
    public void update(@DbBind("id") Contact contact, Map<String, Object> data) {
        notFoundIfNull(contact);
        dao.save(contact.mergeValues(data));
    }

    @PostAction
    public void save(@Valid Contact contact, ActionContext context) {
        if (context.hasViolation()) {
            render("form", contact);
        }
        dao.save(contact);
        redirect("/contacts");
    }


}
