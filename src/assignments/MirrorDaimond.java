package assignments;

public class MirrorDaimond {
    public static void main(String[] args) {
        daimond(6);
    }

    private static void daimond(int n){
        for(int i=1;i<=n;i++){
            int star = i;
            int space = (n-i)*2;
            for(int j= 0;j<star;j++) System.out.print("*");
            for(int j= 0;j<space;j++) System.out.print(" ");
            for(int j= 0;j<star;j++) System.out.print("*");
            System.out.println();
        }
        for(int i=0;i<n;i++){
            int star = n-i;
            int space = i*2;
            for(int j= 0;j<star;j++) System.out.print("*");
            for(int j= 0;j<space;j++) System.out.print(" ");
            for(int j= 0;j<star;j++) System.out.print("*");
            System.out.println();
        }



    }
}
