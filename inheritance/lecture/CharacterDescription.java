// Plain of Data
public class CharacterDescription
{
    private String name;
    private String title;
    private String religion;

    public CharacterDescription(String name, String title)
    {
        this.name = name;
        this.title = title;
    }

    public CharacterDescription(String name, String title, String religion)
    {
        this.name = name;
        this.title = title;
        this.religion = religion;
    }

    // decorator
    public void setName(String name)
    {
        this.name = name;
    }

    public void setReligion(String religion)
    {
        this.religion = religion;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public String getReligion()
    {
        return religion;
    }
}
