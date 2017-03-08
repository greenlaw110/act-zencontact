package demo.zencontact.model;

import act.db.morphia.MorphiaAdaptiveRecord;
import org.apache.bval.constraints.Email;
import org.apache.bval.constraints.NotEmpty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

public class Contact extends MorphiaAdaptiveRecord<Contact> {

    @NotEmpty
    public String firstname;

    @NotEmpty
    public String name;

    @NotNull
    public DateTime birthdate;

    @NotEmpty
    @Email
    public String email;

}
