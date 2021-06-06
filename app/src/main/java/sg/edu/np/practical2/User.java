package sg.edu.np.practical2;

public class User {
    private String name;
    private String description;
    private static int id;
    private static boolean followed;
    private static int myImageID;

    /*public int getMyImageID() {
        return myImageID;
    }

    public void setMyImageID(int myImageID) {
        this.myImageID = myImageID;
    }

    public String getMyText1() {
        return myText1;
    }

    public void setMyText1(String myText1) {
        this.myText1 = myText1;
    }

    public String getMyText2() {
        return myText2;
    }

    public void setMyText2(String myText2) {
        this.myText2 = myText2;
    }

    private int myImageID;
    private String myText1;
    private String myText2;

    public User(int imageName, String text1, String text2){
        this.myImageID = imageName;
        this.myText1 = text1;
        this.myText2 = text2;
    }*/

    public int getMyImageID() {
        return myImageID;
    }

    public void setMyImageID(int myImageID) {
        this.myImageID = myImageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        User.id = id;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        User.followed = followed;
    }

    public User(){

    }
    /*public User(int imageID, String name, String description, Integer id, Boolean followed) {
        this.myImageID = imageID;
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }*/

    /*public User(int imageID, String name, String description, Boolean followed) {
        this.myImageID = imageID;
        this.name = name;
        this.description = description;
        this.followed = followed;
    }*/

}
