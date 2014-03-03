class squareRoot {
   public static void main(String[] args) {
      double sq = 22.0;
      double sqrt = getSqrt(sq);
      System.out.println("The original number: " + sq);
      System.out.println("The square root number: " + sqrt);
   }
   
   static double getSqrt(double sq) {
      if (sq < 0) return -1;
      if (sq == 0 || sq == 1) return sq;
      double precision = 0.00000000000001;
      double start = 0;
      double end = sq;
      if (sq < 1) end = 1;
      while (end - start > precision) {
         double mid = (start + end) / 2;
         double midSqr = mid * mid;
         if (midSqr == sq) return mid;
         else if (midSqr < sq) start = mid;
         else end = mid;
      }
      return (start + end) / 2;
   }
}