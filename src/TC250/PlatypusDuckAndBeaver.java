package TC250;

public class PlatypusDuckAndBeaver {
    public int minimumAnimals(int webbedFeet, int duckBills, int beaverTails) {
        int ducks = (webbedFeet - (4 * beaverTails)) / 2;
        return ducks + beaverTails;
    }
}
