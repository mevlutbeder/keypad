import java.util.ArrayList;
import java.util.List;

public class AppRun {
    public static void main(String[] args) throws InterruptedException {
        String s = "4564523"; //423692 //658234 //913864
        String keypad = "123456789";
        int[] numbers = Integer.toString(Integer.parseInt(s)).chars().map(c -> c - '0').toArray();
        int[] keypads = Integer.toString(Integer.parseInt(keypad)).chars().map(c -> c - '0').toArray();

        Integer[][] data = new Integer[3][3];
        int p = 0;
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                data[i][y] = keypads[p];
                p++;
            }
        }
        List<Integer> listI = new ArrayList<Integer>();
        List<Integer> listY = new ArrayList<Integer>();
        for (int z : numbers) {
            for (int i = 0; i < 3; i++) {
                for (int y = 0; y < 3; y++) {
                    if (data[i][y] == z) {
                        listI.add(i);
                        listY.add(y);
                    }
                }
            }
        }
        Integer[] listISubstract = new Integer[listI.size()];
        for (int i = 0; i < listI.size() - 1; i++) {
            listISubstract[i] = Math.abs(listI.get(i) - listI.get(i + 1));
        }
        Integer[] listYSubstract = new Integer[listY.size()];
        for (int i = 0; i < listY.size() - 1; i++) {
            listYSubstract[i] = Math.abs(listY.get(i) - listY.get(i + 1));
        }
        int iytopla = 0,iytoplak=0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (listISubstract[i] > listYSubstract[i]) {
                iytoplak=listISubstract[i];
            } else if (listISubstract[i] < listYSubstract[i]) {
                iytoplak=listYSubstract[i];
            } else {
                iytoplak=listYSubstract[i];
            }
            iytopla+=iytoplak;
        }

        System.out.println("sonuc : "+iytopla);
    }
}
