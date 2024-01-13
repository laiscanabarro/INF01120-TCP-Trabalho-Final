package content;

public class Location {
    private String country;
    private String city;
    private String state;
    private String street;
    private int number;

    public Location(){
        this.city = null;
        this.country = null;
        this.state = null;
        this.street = null;
        this.number = 0;
    }

    public Location(String country, String city, String state, String street, int number){
        this.city = city;
        this.country = country;
        this.state = state;
        this.street = street;
        this.number = number;
    }

    public String getCountry(){
        return this.country;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getStreet(){
        return this.street;
    }

    public int getNumber(){
        return this.number;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setNumber(int number){
        this.number = number;
    }
    
    public String displayLocation(){
        String locationString = String.join(", ", country, city, state, street) + ", " + String.valueOf(number);

    return locationString;
    }
    
    public boolean verifyLocation() {
        return isNonEmpty(country) && isNonEmpty(city) && isNonEmpty(state) && isNonEmpty(street) && number > 0;
    }

    public boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
        
}
    
