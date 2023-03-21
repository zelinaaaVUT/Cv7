import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Databaze {
    public Databaze(int pocetPrvku)
    {
        prvkyDatabaze=new HashMap<>();
        sc=new Scanner(System.in);
    }

    public void setStudent()
    {
        System.out.println("Zadejte jmeno studenta, rok narozeni");
        String jmeno=sc.next();
        int rok=Test.pouzeCelaCisla(sc);
        prvkyDatabaze.put(jmeno, new Student(jmeno, rok));
    }

    public boolean getStudent(String jmeno) throws prumerException
    {
        if (prvkyDatabaze.containsKey(jmeno)){
            System.out.println("Jmeno: " + prvkyDatabaze.get(jmeno).getJmeno() + " rok narozeni: " + prvkyDatabaze.get(jmeno).getRocnik() + " prumer: " + prvkyDatabaze.get(jmeno).getStudijniPrumer());
            return true;
        }
        else {
            System.out.println("Student neexistuje");
            return false;
        }
    }

    public boolean setPrumer(String jmeno, float prumer) throws prumerException
    {
        if (prvkyDatabaze.containsKey(jmeno)){
            prvkyDatabaze.get(jmeno).setStudijniPrumer(prumer);
            return true;
        }
        else {
            System.out.println("Student neexistuje");
            return false;
        }
    }

    public void VypisVsech() throws prumerException
    {
        prvkyDatabaze.forEach((k, v) -> {
            try {
                System.out.println("Jmeno: " + k + " Rok: " + v.getRocnik() + " Prumer: " + v.getStudijniPrumer());
            } catch (prumerException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void VymazaniStudenta(String jmeno){
        prvkyDatabaze.remove(jmeno);
    }


    private Scanner sc;
    private Map<String, Student> prvkyDatabaze;
}