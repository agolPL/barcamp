package pl.osec.barcamp.registration.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Registration.GET_ALL_REGISTRATIONS_QUERY, query = "from Registration r")})
@Entity
public class Registration {

    public static final String GET_ALL_REGISTRATIONS_QUERY = "GET_ALL_REGISTRATIONS_QUERY";

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String name;
    private String lastName;

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Registration setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Registration setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Registration setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
