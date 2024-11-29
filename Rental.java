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

   // Método movido e renomeado corretamente
   public double getCharge() {
      double thisAmount = 0;  

      switch (_movie.getPriceCode()) {
         case Movie.REGULAR:
            thisAmount += 2;
            if (_daysRented > 2)
               thisAmount += (_daysRented - 2) * 1.5;
            break;
         case Movie.NEW_RELEASE:
            thisAmount += _daysRented * 3;
            break;
         case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (_daysRented > 3)
               thisAmount += (_daysRented - 3) * 1.5;
            break;
      }
      return thisAmount;  // Retorna o valor calculado
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
