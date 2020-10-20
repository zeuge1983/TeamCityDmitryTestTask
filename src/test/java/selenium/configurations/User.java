package selenium.configurations;

public enum User {

    ADMIN_USER(
            "admin",
            "admin"
    );

    private final String email;
    private final String password;

    User(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getUserName() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}