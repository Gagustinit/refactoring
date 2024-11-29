import java.util.Enumeration;
import java.util.Vector;

public class Statement {
    
    private Vector<Rental> _rentals;  // Lista de locações
    
    public Statement(Vector<Rental> rentals) {
        _rentals = rentals;  // Inicializa a lista de locações
    }

    // Método para obter o nome do cliente (presumido)
    public String getName() {
        return "Customer Name";  // Exemplo, substitua pelo método real para obter o nome do cliente
    }

    // Método que gera o statement
    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        // Itera pelas locações e exibe informações sobre cada uma
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            
            // Mostra os valores para esta locação
            result += "\t" + each.getMovie().getTitle() + "\t" +
                      String.valueOf(each.getCharge()) + "\n";
        }

        // Adiciona linhas de rodapé
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                  " frequent renter points";
        return result;
    }

    // Calcula o total a ser pago
    private double getTotalCharge() {
        double totalCharge = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            totalCharge += each.getCharge();
        }
        
        return totalCharge;
    }

    // Calcula o total de pontos de frequent renter
    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            totalPoints += each.getFrequentRenterPoints();
        }
        
        return totalPoints;
    }
}

