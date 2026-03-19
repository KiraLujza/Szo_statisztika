import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FeladatokTest {

    static List<String> szavak;
    Feladatok feladatok;

    @BeforeAll
    static void feltolt(){
        szavak = new ArrayList<>();
        szavak.add("kocsi");
        szavak.add("kalap");
        szavak.add("tekercs");
        szavak.add("alma");
    }

    @BeforeEach
    void setUp() {
        feladatok = new Feladatok();
    }

    @Test
    void szavakSzama() {

        assert feladatok.hanySzo(szavak) == 4: "Szavak száma nem 4";

    }

    @Test
    void leghosszabbSzoIndexe() {
        assert feladatok.leghosszab(szavak).equals("tekercs") : "Leghosszabb szó nem tekercs.";
    }

    @Test
    void betukSzama() {
        assert feladatok.eSzama(szavak) == 2 : "Az 'e' betük száma nem 2";
    }

    @Test
    void csere() {
        assert feladatok.csere(szavak, 2).equals("sekerct") : "Nem jól keveret";
    }

    @Test
    void egyformaSzavak() {
        assert !feladatok.egyforma(szavak) : "Nem kéne lennie";
    }

    @Test
    void betuStatisztika() {
        Map<Character, Integer> stat = feladatok.betuStatisztika(szavak);

        assertEquals(4, stat.get('a'));
        assertEquals(2, stat.get('e'));
        assertEquals(2, stat.get('k'));
        assertEquals(2, stat.get('c'));
        assertEquals(0, stat.getOrDefault('z' ,0));
    }
}