package user;

import content.TaskList;

import java.util.ArrayList;

import content.Event;

public class Community {
    private static final int MAXCAP = 20;
    private String name;
    private String owner;
    private ArrayList<User> members;
    private ArrayList<TaskList> lists;
    private ArrayList<Event> events;
    
    public Community(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public static int getMaxcap() {
        return MAXCAP;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<TaskList> getLists() {
        return lists;
    }

    public void setLists(ArrayList<TaskList> lists) {
        this.lists = lists;
    }

    public ArrayList<Event> getEvents() {
         return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public boolean addMember(User member) {
        if (searchMember(member.getName()) == null) {
            if (members.size() < MAXCAP) {
                members.add(member);
                return true;
            }
        }
        return false;
    }

    public User searchMember(String name) {
        for(User member : members) {
            if(member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public boolean removeMember(String name) {
        User memberToRemove = searchMember(name);
        
        if (memberToRemove != null) {
            members.remove(memberToRemove);
            return true;
        }
        return false;
    }

    public boolean addList(TaskList list) {
        if (searchList(list.getName()) == null) {
            lists.add(list);
            return true;
        }
        return false;
    }

    public TaskList searchList(String name) {
        for(TaskList list : lists) {
            if(list.getName().equals(name)) {
                return list;
            }
        }
        return null;
    }

    public boolean removeList(String name) {
        TaskList listToRemove = searchList(name);
        
        if (listToRemove != null) {
            lists.remove(listToRemove);
            return true;
        }
        return false;
    }
}