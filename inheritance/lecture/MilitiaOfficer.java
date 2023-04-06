public class MilitiaOfficer extends ACharacter
{
    public MilitiaOfficer(String name)
    {
        super(new CharacterDescription(name, "MilitiaOfficer"));
    }

    public MilitiaOfficer(CharacterDescription description)
    {
        super(description);
    }

    @Override
    public void attack()
    {
        System.out.println(description.getName() + " attacked with the sword");
    }

    @Override
    public void move(double x, double y)
    {

    }
}
