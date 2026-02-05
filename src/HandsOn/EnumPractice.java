package HandsOn;

enum Sample{
    Sunday,
    Monday,
    Tuestday;

}

public class EnumPractice {
    public static void main(String[] args) {
        for (Sample sample:Sample.values()){
            System.out.println(sample.toString());
        }
    }
}
