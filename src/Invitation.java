package src;
public class Invitation {
    private boolean accept;
    //private User guest;
    //private Community community;
    private Notification notification;

    /* 
    public Invitation(User user, Notification notification){
        this.accept = false;
        this.guest = user;
        this.notification = notification;
    }

    public Invitation(Community community, NOtification notification){
        this.accept = false;
        this.guest = community;
        this.notification = notification;
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

    public Notification getNotification(){
        return this.notification;
    }

    public void setAccept(boolean value){
        this.accept = value;
    }

    public void setNotification(Notification notification){
        this.notification = notification;
    }

    /*
    public void acceptInvitation(User user){
        setAccept(true);
        user.getNotificationList().addNotification(notification);

    }

    public void acceptInvitation(Community community){
        setAccept(true);
        community.getNotificationList().addNotification(notification);

    }
     */
}