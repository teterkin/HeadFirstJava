public class DogTestDrive
{
    public static void main(String[] args)
    {
        Dog d = new Dog("Бобик");
        d.size = 40; // переменная size не private,
                     // т.е. default и доступна все классам пакета.
        System.out.println("А полаять можешь?");
        d.bark();
        System.out.println("Попробуем поменять имя на Тузик...");
        // d.name = "Тузик"; теперь не сработает т.к. мы защитили с помощью private
        d.setName("Тузик"); // Хотя код корректный. Тузик не пройдёт,
                            // т.к. это имя проверяется в методе и
                            // он запрещает Тузика. :)
        // System.out.println(d.name); теперь не сработает т.к. private
        System.out.println("Имя всё еще " + d.getName() + ".  :)");
    }
}
