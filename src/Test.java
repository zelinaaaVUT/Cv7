import java.util.Scanner;


public class Test {

    public static int pouzeCelaCisla(Scanner sc)
    {
        int cislo = 0;
        try
        {
            cislo = sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu "+e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }

    public static float pouzeCisla(Scanner sc)
    {
        float cislo = 0;
        try
        {
            cislo = sc.nextFloat();
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu "+e.toString());
            System.out.println("zadejte prosim cislo ");
            sc.nextLine();
            cislo = pouzeCisla(sc);
        }
        return cislo;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Databaze mojeDatabaze=new Databaze(1);
        int idx;
        String jmeno;
        float prumer;
        int volba;
        boolean run=true;
        while(run)
        {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. vypis cele databaze");
            System.out.println("6 .. vymazani studenta");
            System.out.println("7 .. ukonceni aplikace");
            volba=pouzeCelaCisla(sc);
            switch(volba)
            {
                case 1:
                    System.out.println("Zadejte pocet studentu");
                    mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
                    break;
                case 2:
                    try
                    {
                        mojeDatabaze.setStudent();
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Nebylo mozno vytvorit novou polozku, databaze je plna");
                    }
                    break;
                case 3:
                    System.out.println("Zadejte jmeno a prumer studenta");
                    sc.nextLine();
                    jmeno = sc.nextLine();
                    prumer = pouzeCisla(sc);
                    try
                    {
                        mojeDatabaze.setPrumer(jmeno ,prumer);
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Vybrana polozka mimo rozsah databaze");
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Vybrana polozka neexistuje");
                    }
                    catch (prumerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try
                    {
                        System.out.println("Zadejte jmeno studenta");
                        sc.nextLine();
                        jmeno = sc.nextLine();
                        mojeDatabaze.getStudent(jmeno);
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Vybrana polozka mimo rozsah databaze");
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Vybrana polozka neexistuje");
                    } catch (prumerException e) {
                        throw new RuntimeException(e);
                    }
                    catch (Exception e){}
                    break;
                case 5:
                    try {
                        mojeDatabaze.VypisVsech();
                    }
                    catch (Exception e){
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Zadejte jmeno studenta");
                        sc.nextLine();
                        jmeno = sc.nextLine();
                        mojeDatabaze.VymazaniStudenta(jmeno);
                    }
                    catch (Exception e){
                    }
                    break;
                case 7:
                    run=false;
                    break;
            }

        }
    }

}
