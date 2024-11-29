public class Rental {
   private Movie _movie;
   private int _daysRented;

   public Rental(Movie movie, int daysRented) {
      _movie = movie;
      _daysRented = daysRented;
   }

   public Movie getMovie() {
      return _movie;
   }

   public int getDaysRented() {
      return _daysRented;
   }

   public double getCharge(){
      return _movie.getCharge(_daysRented);
   }
  
   // Novo método extraído para calcular os pontos
   public int getFrequentRenterPoints() {
      // Adiciona bônus para nova locação de lançamento por mais de um dia
      if ((_movie.getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1) {
         return 2;  // Bônus de 2 pontos
      }
      return 1;  // Caso padrão: 1 ponto
   }
}
