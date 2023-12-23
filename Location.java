public class Location {
    private String city;
    private String country;
    private String street;
    private int number;

    public Location(String city, String country, String street, int number){
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }

    public String getStreet(){
        return this.street;
    }

    public int getNumber(){
        return this.number;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setNumber(int number){
        this.number = number;
    }

}
