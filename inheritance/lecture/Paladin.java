public class Paladin extends MilitiaOfficer implements IMagician
{
    public Paladin(String name)
    {
        // super(name);
        // description.setTitle("Paladin");

        super(new CharacterDescription(name, "Paladin"));
    }

    public Paladin(CharacterDescription description)
    {
        super(description);
    }

    public void castHollySpell()
    {
        System.out.println(description.getName() + " cast the holly spell");
    }

    @Override
    public void castSpell()
    {
        castHollySpell();
    }

}
