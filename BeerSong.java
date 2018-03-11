public class BeerSong
{
    public static void main(String[] args)
    {
        int beerNum = 99;
        String word = "bottles";
        
        while (beerNum > 0)
        {
            if (beerNum == 1)
            {
                word = "bottle";
            }
            System.out.println();
            System.out.print(beerNum + " " + word + " of beer on the wall, ");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.print("Take one down. ");
            System.out.print("Pass it around. ");
            beerNum--;
            
            if (beerNum == 1)
            {
                System.out.println(beerNum + " bottle of beer on the wall.");
        
            }
            else if (beerNum > 0)
            {
                System.out.println(beerNum + " " + word + " of beer on the wall.");
            }
            else
            {
                System.out.println("No more bottles of beer on the wall.");
            }
        }
    }
}
