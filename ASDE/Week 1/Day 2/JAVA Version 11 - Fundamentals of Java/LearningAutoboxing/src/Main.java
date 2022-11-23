public class Main {

    public  static void  main (String[] args){
        int score =20;
        int intValue = 99;

        Integer iScore= new Integer(score);

        Integer i_Value = intValue;

        System.out.println(("iScore = " + iScore.toString()));
        System.out.println(("i_Value = " + i_Value.toString()));

        int scoreValue = iScore.intValue();
        int intValue2 = i_Value;
    }

}
