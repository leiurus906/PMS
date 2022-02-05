

public class Person {

    private String Username;
    private String Password;
    private final String Name;

    Person(String name) {
        Name = name;
    }

    public String getName() {
        return this.Name;
    }

    String getUsername() {
        return this.Username;
    }

    String getPassword() {
        return this.Password;
    }

    void setUsername(String username) {
        this.Username = username;
    }

    void setPassword(String password) {
        this.Password = password;
    }


}
