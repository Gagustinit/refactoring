import java.util.Enumeration;

public class HtmlStatement extends Statement {

    // Criação do cabeçalho para HTML
    @Override
    protected String createHeader(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    // Formatação de cada linha de locação para HTML
    @Override
    protected String createRentalLine(Rental each) {
        return each.getMovie().getTitle() + ": " +
               String.valueOf(each.getCharge()) + "<BR>\n";
    }

    // Criação do rodapé para HTML
    @Override
    protected String createFooter(Customer aCustomer) {
        return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
               "On this rental you earned <EM>" +
               String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
               "</EM> frequent renter points<P>";
    }
}
