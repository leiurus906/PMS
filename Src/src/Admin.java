public class Admin extends Person {

    private final String ID;
    private Pass_Manager_Admin passwordManagerAdmin;
    public Admin(String name,String ID, String Username, String Password) {
        super(name);
        this.passwordManagerAdmin = new Pass_Manager_Admin();
        this.ID = ID;
        super.setPassword(Password);
        super.setUsername(Username);

    }

    public boolean Log_in(String Username, String Password, String ID){
        if(this.ID.contentEquals(ID))
            return Username.contentEquals(this.getUsername()) && Password.contentEquals(this.getPassword());

        return false;
    }

    public void Sign_Up(String Username, String Password, String ID){
        if(this.ID.contentEquals(ID)){
            this.setPassword(Password);
            this.setUsername(Username);
        }
    }

}
