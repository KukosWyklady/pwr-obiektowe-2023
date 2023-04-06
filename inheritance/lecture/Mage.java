public class Mage extends ACharacter implements IMagician
{
    protected int energy;

    public Mage(String name)
    {
        // constructor
        // super(name, "Mage", "Innos");

        // decorator
        // super(name, "Mage");
        // description.setReligion("Innos");

        super(new CharacterDescription(name, "Mage", "Innos"));
        energy = 100;
    }

    public Mage(CharacterDescription description)
    {
        super(description);
    }

    @Override
    public void castSpell()
    {
        System.out.println(description.getName() + " cast spell with energy = " + energy);
        energy -= 10;
    }

    @Override
    public void attack()
    {
        System.out.println(description.getName() + " attacked with the wand");
    }

    @Override
    public void move(double x, double y)
    {

    }

    @Override
    public void coop(ACharacter friend)
    {
        if (!(friend instanceof Paladin))
            return; // throw will be better

        hello();

        Paladin paladin = (Paladin)friend;
        paladin.hello();
        paladin.castHollySpell();
    }
}
