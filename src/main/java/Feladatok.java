import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Feladatok {



    public List<String> beolvas(String fajlNev) {
        try {
            return Files.readAllLines(Path.of(fajlNev));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void futtatas(String FajlNev){
        List<String> sorok = beolvas("alap.txt");

        System.out.println("Szavak száma: " + hanySzo(sorok));
        System.out.println("Leghosszabb szó: " + leghosszab(sorok));

        System.out.println("'e'-t tartalmazó szavak száma: " + eSzavakSzama(sorok));

        System.out.println("'e betük össz száma: '" + eSzama(sorok));
        int index = konzolIndex(sorok);
        System.out.println("Csere eredménye: " + csere(sorok, index));
        System.out.println("Van egyforma szó? " + egyforma(sorok));
        System.out.println(betuStatisztika(sorok));
    }

    public int hanySzo(List<String> sorok){

        return sorok.size();
    }

    public String leghosszab(List<String> sorok){
        if (sorok.isEmpty()) return null;

        String leghosszab = sorok.get(0);

        for ( String sor : sorok){
            if (sor.length() > leghosszab.length()){
                leghosszab = sor;
            }
        }
        return leghosszab;
    }


    public int eSzavakSzama(List<String> sorok){
        int db = 0;

        for (String sor :sorok){
            if (sor.contains("e")){
                db++;
            }
        }
        return db;
    }

    public int eSzama(List<String> sorok){
        int db = 0;
        for (String sor : sorok){
            for (char c : sor.toCharArray()){
                if (c == 'e'){
                    db++;
                }
            }
        }
        return db;
    }

    public String csere (List<String> sorok, int index){

        String szo = sorok.get(index);

        if (szo.length() < 2) return szo;

        char[] betuk = szo.toCharArray();
        char temp =  betuk[0];
        betuk[0] = betuk[betuk.length -1];
        betuk[betuk.length -1] = temp;

        return new String(betuk);

    }
    public int konzolIndex(List<String> sorok) {
        Scanner sc = new Scanner(System.in);
        int index;

        while (true) {
            System.out.println("Írd be a kiválasztott szó számát (0-" + (sorok.size() - 1) + "): ");
            index = sc.nextInt();

            if (index >= 0 && index < sorok.size()) break;
            System.out.println("Érvénytelen szám, próbáld újra!");
        }

        return index;
    }


    public boolean egyforma(List<String> sorok){

        Set<String> egyedi = new HashSet<>();


        for (String szo : sorok){
            if (!egyedi.add(szo)){
                return true;
            }
        }
        return false;
    }

    public Map<Character, Integer> betuStatisztika(List<String> sorok){
        Map<Character, Integer> stat = new HashMap<>();

        for (String szo : sorok){
            for (char c : szo.toCharArray()){
                stat.put(c, stat.getOrDefault(c, 0) +1);
            }
        }
        return stat;
    }

}
