public class WashingMachine {
    boolean isOn;
    int numClothes = 0;
    boolean hasDetergent;

    WashingMachine(boolean isOn, int numClothes, boolean hasDetergent) {
        this.isOn = isOn;
        this.numClothes = numClothes;
        this.hasDetergent = hasDetergent;
    }

    void switchOn() {
        if(!this.hasDetergent || this.numClothes == 0) {
            System.out.println("Please add detergent or clothes before turning on");
        }
        else {
            this.isOn = true;
            System.out.println("Washer is on");
        }
    }
    void switchOff() {
        this.isOn = false;
        System.out.println("Washer is off");
    }

    void acceptClothes(int numClothes) {
        if(this.isOn) {
            System.out.println("Can't accept clothes if machine is on");
        }
        else if(numClothes < 1) {
            System.out.println("Please enter a value greater than 0");
        }
        else {
            this.numClothes += numClothes;
            System.out.println("There are " + this.numClothes + " clothes in the washer");
        }
    }
    void acceptDetergent() {
        if(this.hasDetergent) {
            System.out.println("Already have detergent");
        }
        else if(this.isOn) {
            System.out.println("Cannot add detergent if machine is running");
        }
        else {
            this.hasDetergent = true;
        }
    }

    public static void main(String args[]) { //tester
        WashingMachine w = new WashingMachine(false, 0, false);
        w.switchOn();
        w.acceptClothes(0);
        w.acceptClothes(-1);
        w.acceptClothes(5);
        w.switchOn();
        w.acceptDetergent();
        w.switchOn();
        w.acceptClothes(5);
        w.acceptDetergent();
        w.switchOff();
        w.acceptClothes(5);
    }
}
