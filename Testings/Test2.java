public class Test2 {
    public static void main(String[] args) {
        String[] TA = {"R", "H", "D", "G", "J", "K", "L", "O", "Q", "A"};
        int fistBumps = 0;
        
        for (int k = 0; k < tempTA.length; k++) {
            tempTA[i] = TA[i];
        }
        for (int i = 0; i < TA.length; i++) {
            for (int j = 0; j < TA.length; j++) {
                if (TA[i].equals(TA[j]))
                    continue;
                System.out.printf("%s fistbumped %s\n", TA[i], TA[j]);
                
                fistBumps++;
            }
            String[] tempTA = new String[TA.length - 1];
            for (int k = 1; k < TA.length; k++) {
                tempTA[i-1] = TA[i];
            }
            
        }
        System.out.print(TA.length + " : " + fistBumps);
    }
}

/*
2 > 2   -- 2 * 1
3 > 6   -- 3 * 2
4 > 12  -- 4 * 3
5 > 20  -- 5 * 4
6 > 30  -- 6 * 5
7 > 42  -- 7 * 6
8 > 56  -- 8 * 7
9 > 72  -- 9 * 8
10 > 90 -- 10 * 9

*/