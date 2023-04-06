public abstract class ACharacter
{
    protected CharacterDescription description;

    public ACharacter(String name, String title)
    {
        description = new CharacterDescription(name, title);
    }

    public ACharacter(String name, String title, String religion)
    {
        description = new CharacterDescription(name, title, religion);
    }

    public ACharacter(CharacterDescription description)
    {
        this.description = description;
    }

    public void hello()
    {
        System.out.println("Hello: " + description.getTitle() + " " + description.getName());
    }

    public abstract void move(double x, double y);
    public abstract void attack();

    public void coop(ACharacter friend)
    {
        hello();
        friend.hello();
    }
}
