public class ConvertRational {

   public static void main(String[] args) {
      System.out.println(GetRational(0.1125));
      System.out.println(GetRational(0.11125));
      System.out.println(GetRational(0.3125));
      System.out.println(GetRational(0.125));
      System.out.println(GetRational(0.25));
   }
   
   public static String GetRational(double a) {
      int tenPoly = 1;
      while (a * tenPoly - (int)(a * tenPoly) != 0) {
         tenPoly *= 10;
      }
      int divident = (int) (a * tenPoly);
      int divisor = tenPoly;
      
      int gcd = 0;
      if (divident > divisor) gcd = GCD(divident, divisor);
      else gcd = GCD(divisor, divident);
      
      divident /= gcd;
      divisor /= gcd;
      
      String output = a + " = ";
      output += divident + "/" + divisor;
      return output;
   }
   
   private static int GCD(int a, int b) {
      int remainder = a % b;
      if (remainder == 0) return b;
      else return GCD(b, remainder);
   }
}