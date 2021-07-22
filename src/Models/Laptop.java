package Models;
import com.google.gson.annotations.SerializedName;

/**
 * Creating instance of an object
 */
public class Laptop {
    @SerializedName("FIELD1")
    private int id;
    @SerializedName("Company")
    private String company;
    @SerializedName("Product")
    private String product;
    @SerializedName("TypeName")
    private String typeName;
    @SerializedName("ScreenResolution")
    private String screenResolution;
    @SerializedName("Cpu")
    private String cpu;
    @SerializedName("Ram")
    private String ram;
    @SerializedName("Memory")
    private String memory;
    @SerializedName("Gpu")
    private String gpu;
    @SerializedName("OpSys")
    private String opSys;
    @SerializedName("Weight")
    private String  weight;
    @SerializedName("Inches")
    private double inches;
    @SerializedName("Price_euros")
    private double priceError;

    /**
     * Constructor will generate object.
     */
    public Laptop(int id, String company, String product, String typeName, String screenResolution, String cpu, String ram, String memory, String gpu, String opSys, String weight, double inches, double priceError) {
        setId(id);
        setCompany(company);
        setProduct(product);
        setTypeName(typeName);
        setScreenResolution(screenResolution);
        setCpu(cpu);
        setRam(ram);
        setMemory(memory);
        setGpu(gpu);
        setOpSys(opSys);
        setWeight(weight);
        setInches(inches);
        setPriceError(priceError);
    }

    public int getId() {
        return id;
    }

    /**
     * if id is greater than 0 then only than it is considered as valid id
     * @param id
     */
    public void setId(int id) {
        if (id>0)
            this.id = id;
        throw
                new IllegalArgumentException("id must be greater than 0");
    }

    public String getCompany() {
        return company;
    }

    /**
     * company must be alphabetical to be valid
     * @param company
     */
    public void setCompany(String company) {
        if (company.matches("[A-Za-z]*"))
            this.company = company;
        throw
                new IllegalArgumentException("Company name must be alphabet");
    }

    public String getProduct() {
        return product;
    }

    /**
     * \if product has first character alphabet and space and last letter alphabet it is valid product
     * @param product
     */
    public void setProduct(String product) {
        if (product.matches("[A-Za-z]*/s?[A-Za-z]?"))
             this.product = product;
        else
            new IllegalArgumentException("product name must be alphabet");
    }

    public String getTypeName() {
        return typeName;
    }

    /**
     * If typeName only contain alphabets it is valid
     * @param typeName
     */
    public void setTypeName(String typeName) {
        if (typeName.matches("[A-Za-z]*"))
            this.typeName = typeName;
        else
            throw new IllegalArgumentException("name must be alphabetical");
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    /**
     * if screen resolution is not empty it is considered as valid
     * @param screenResolution
     */
    public void setScreenResolution(String screenResolution)  {
        if (!screenResolution.isEmpty())
            this.screenResolution = screenResolution;
        else
            throw new IllegalArgumentException("screen resolution must have a value");
    }

    public String getCpu() {
        return cpu;
    }

    /**
     * if cpu field is not empty it is considered as valid cpu
     * @param cpu
     */
    public void setCpu(String cpu) {
        if (!cpu.isEmpty()){
            this.cpu = cpu;
        }
        else
            throw new IllegalArgumentException("CPu must be a value");

    }

    public String getRam() {
        return ram;
    }

    /**
     * input must be a numbers followed by alphabet to be considered as valid ram
     * @param ram
     */
    public void setRam(String ram) {
        if (ram.matches("[0-9]*[A-Za-z][A-Za-z]"))
                this.ram = ram;
        else
            throw new IllegalArgumentException("must be integer followed by aplhaber");
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getInches() {
        return inches;
    }

    /**
     * if inches is greater than 0 it is valid
     * @param inches
     */
    public void setInches(double inches) {
        if (inches>0)
            this.inches = inches;
        else
            throw
            new IllegalArgumentException("Screen must be grater than 0 inches");
    }

    public double getPriceError() {
        return priceError;
    }

    /**
     * if setPrice is greater than 0 it is valid price
     * @param priceError
     */
    public void setPriceError(double priceError) {
        if (priceError>0)
            this.priceError = priceError;
        else
            throw new IllegalArgumentException("Price must be greater than 0");
    }

    /**
     * toString method will convert our object to string format
     * @return
     */
    public String toString(){
       return String.format("%s: %s, %s, memory: %s %n",getCompany(),getProduct(),getTypeName(),getMemory());
    }
}
