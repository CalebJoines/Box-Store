public class CleaningSupply extends HouseholdItem {
    private String useMethod;
    private String applicationMethod;
    public CleaningSupply(String name, String description, String brand, double price, String returnPolicy, String useMethod, String applicationMethod) {
        super(name, description, brand, price, returnPolicy);
        this.useMethod = useMethod;
        this.applicationMethod = applicationMethod;
    }
    public CleaningSupply(String name, double price, String useMethod, String applicationMethod) {
        super(name, price);
        this.useMethod = useMethod;
        this.applicationMethod = applicationMethod;
    }

    public String getUseMethod (){
        return this.useMethod;
    }

    public String getApplicationMethod(){
        return this.applicationMethod;
    }

    public void setUseMethod(String useMethod){
        this.useMethod = useMethod;
    }

    public void setApplicationMethod(String applicationMethod){
        this.applicationMethod = applicationMethod;
    }
}
