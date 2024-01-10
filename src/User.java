import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private ArrayList<String> allergies = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String newPassword) {
        this.password = password;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public void addAllergy(String allergy) {
        String polished = allergy.trim().toLowerCase();
        allergies.add(polished);
    }

    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

    public boolean hasAllergy(String allergy) {
        return allergies.contains(allergy);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", allergies=" + Arrays.toString(allergies.toArray()) +
                '}';
    }
}
