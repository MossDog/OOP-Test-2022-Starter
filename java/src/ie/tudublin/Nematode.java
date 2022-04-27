package ie.tudublin;

public class Nematode {

    NematodeVisualiser viz;
    String name, len, limbs, gender, eyes;

    
    public Nematode(String name, String terms, String terms2, String terms3, String terms4, NematodeVisualiser viz){
        this.name = name;
        this.len = terms;
        this.limbs = terms2;
        this.gender = terms3;
        this.eyes = terms4;
        this.viz = viz;
    }

    @Override
    public String toString() {
        return "Name - " + name + "\nLength - " + len + "\nLimbs - " + limbs + "\nGender - " + gender + "\nEyes - " + eyes;
    }

}
