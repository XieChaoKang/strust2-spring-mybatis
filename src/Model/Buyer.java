package Model;

//采购员
public class Buyer {
    private int id;
    private String password;

    public Buyer() {
    }

    public Buyer(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
