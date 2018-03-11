public class Dog
{
    int size;       // Размер
    String breed;   // Порода
    private String name;    // Имя
    
    Dog (String myName)
    {
        name = myName;
        System.out.println("Новый пёсик, а зовут его " + myName + ".");
    }
    
    public void setName(String myName)
    {
        if(myName.equals("тузик"))
        {
            name = myName;
        }
        else
        {
            System.out.println("Тузикам нельзя!");
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    void bark()     // Лай!
    {
        System.out.println("Ruff! Ruff!");
        int max = 10;
    }
}
