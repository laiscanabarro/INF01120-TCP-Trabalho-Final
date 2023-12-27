package src;
public class Invitation {
    private boolean accept;
    //private User guest;
    //private Community community;

    /* 
    public Invitation(User user){
        this.accept = false;
        this.invited = guest;
    }

    public Invitation(Community community){
        this.accept = false;
        User owner = community.owner; //owner é um usuário ou só uma string?
        this.invited = owner;
    }
    */

    public boolean getAccept(){
        return this.accept;
    }

    /*
    public User getGuest(){
        return this.guest;
    }

    public GetCommunity(){
        return this.community;
    }
     */

    public void setAccept(boolean value){
        this.accept = value;
    }

    public void acceptInvitation(){
        setAccept(true);

    }

    public void rejectInvatation(){
        setAccept(false);
    }
}