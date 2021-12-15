public class truckManagerObject {

    private int position;
    private int truckID;
    private int zip;
    private int numPackages;

    public truckManagerObject(int position, int truckID, int zip, int numPackages) {
        this.position = position;
        this.truckID = truckID;
        this.zip = zip;
        this.numPackages = numPackages;
    }

    public int getPosition() {
        return position;
    }

    public int getTruckID() {
        return truckID;
    }

    public int getZip() {
        return zip;
    }

    public int getNumPackages() {
        return numPackages;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setNumPackages(int numPackages) {
        this.numPackages = numPackages;
    }

}


