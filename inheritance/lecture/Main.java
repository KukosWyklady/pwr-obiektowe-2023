public class Main
{
    public static void main(String[] args)
    {
        MilitiaOfficer officer = new MilitiaOfficer("KukosOfficer");
        // officer.hello();
        // officer.attack();

        Paladin paladin = new Paladin("KukosPaladin");
        // paladin.hello();
        // paladin.castHollySpell();
        // paladin.attack();

        MilitiaOfficer offPaladin = new Paladin("KukosOffPaladin"); // polimirfizm
        // offPaladin.hello();
        // offPaladin.attack();

        MilitiaOfficer arr[] = new MilitiaOfficer[3];
        arr[0] = officer;
        arr[1] = paladin;
        arr[2] = offPaladin;

        for (MilitiaOfficer mo : arr)
        {
            mo.hello();
            castSpell(mo);
        }

        IMagician mage = new Paladin("IKukos");
        mage.castSpell();
    }

    public static void castSpell(MilitiaOfficer officer)
    {
        if (!(officer instanceof IMagician))
            return;

        IMagician mage = (IMagician)officer; // downcast
        mage.castSpell();
    }
}

/*
 * abstract class Character
 * interface IMage
 * interface IMelee
 * ....
 *
 * class Mlitilia extend Charcter implementes IMelee, IBlacksmith
 *
 *
 *
 *
 *
 */