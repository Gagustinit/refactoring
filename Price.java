public abstract class Price {
    public abstract int getPriceCode();
    

    public abstract double getCharge(int daysRented) {
        double thisAmount = 0;

        switch (getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
        
    }
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
    
 }
