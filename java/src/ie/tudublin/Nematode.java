package ie.tudublin;

public class Nematode {

    NematodeVisualiser viz;
    String name, limbs, gender, eyes;
    int len;

    
    public Nematode(String name, int len, String limbs, String gender, String eyes, NematodeVisualiser viz){
        this.name = name;
        this.len = len;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
        this.viz = viz;
    }

    @Override
    public String toString() {
        return "Name - " + name + "\nLength - " + len + "\nLimbs - " + limbs + "\nGender - " + gender + "\nEyes - " + eyes;
    }

}
