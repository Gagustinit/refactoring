import java.util.Enumeration;

public class TextStatement extends Statement {
    public String value(Customer aCustomer) {
      Enumeration<Rental> rentals = aCustomer.getRentals();
      String result = "Rental Record for " + aCustomer.getName() +
      "\n";
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += "\t" + each.getMovie().getTitle()+ "\t" +
         String.valueOf(each.getCharge()) + "\n";
      }
      //add footer lines
      result += "Amount owed is " +
      String.valueOf(aCustomer.getTotalCharge()) + "\n";
      result += "You earned " +
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      " frequent renter points";
      return result;
   }
   // Criação do cabeçalho para texto simples
   @Override
   protected String createHeader(Customer aCustomer) {
       return "Rental Record for " + aCustomer.getName() + "\n";
   }

   // Formatação de cada linha de locação para texto simples
   @Override
   protected String createRentalLine(Rental each) {
       return "\t" + each.getMovie().getTitle() + "\t" +
              String.valueOf(each.getCharge()) + "\n";
   }

   // Criação do rodapé para texto simples
   @Override
   protected String createFooter(Customer aCustomer) {
       return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
              "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
              " frequent renter points";
   }
}
