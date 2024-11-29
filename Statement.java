import java.util.Enumeration;
import java.util.Vector;

public abstract class Statement {
    
    private Vector<Rental> _rentals;  // Lista de locações
    
    public Statement(Vector<Rental> rentals) {
        _rentals = rentals;  // Inicializa a lista de locações
    }

    // Método template para gerar o statement
    public String value(Customer aCustomer) {
        Enumeration<Rental> rentals = aCustomer.getRentals();
        String result = createHeader(aCustomer);  // Cabeçalho

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += createRentalLine(each);  // Linha de locação
        }

        result += createFooter(aCustomer);  // Rodapé
        return result;
    }

    // Método abstrato para criar o cabeçalho
    protected abstract String createHeader(Customer aCustomer);

    // Método abstrato para formatar cada linha de locação
    protected abstract String createRentalLine(Rental each);

    // Método abstrato para criar o rodapé
    protected abstract String createFooter(Customer aCustomer);

    // Métodos de cálculo do total
    protected double getTotalCharge() {
        double totalCharge = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            totalCharge += each.getCharge();
        }
        
        return totalCharge;
    }

    protected int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            totalPoints += each.getFrequentRenterPoints();
        }
        
        return totalPoints;
    }
}
