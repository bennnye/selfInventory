package shelforganiser;

public class item {
    
    private String name;
    private String dateRecived;
    private String usage;

    public item(String name, String dateRecived, String usage) {
        this.name = name;
        this.dateRecived = dateRecived;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public String getDateRecived() {
        return dateRecived;
    }

    public String getUsage() {
        return usage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateRecived(String dateRecived) {
        this.dateRecived = dateRecived;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
    
    public String toString(){
        return name + ", " + dateRecived + ", " + usage;
    }
    
}
