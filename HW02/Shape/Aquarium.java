public class Aquarium {
    public static void main(String[] args) { 
        Fish gongo = new Fish();
        // System.out.println(gongo.formatLength(gongo.length));
        // System.out.println(gongo);
        Catfish golbo = new Catfish();
        Catfish golde = new Catfish("Bold", 12.0, 16.0, 14.0);

        StripedBass gomba = new StripedBass();

        FlyingFish gumba = new FlyingFish();

        System.out.println(golbo);
        System.out.println(golde);
        System.out.println(gomba);
        System.out.println(gumba);




    }
}