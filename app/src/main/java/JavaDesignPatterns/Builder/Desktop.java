package JavaDesignPatterns.Builder;

public class Desktop {
    private String monitor;
    private String keyboard;
    private String mouse;
    private String speaker;
    private String ram;
    private String processor;
    private String motherboard;

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void showSpecs(){
        System.out.println("--------------- Desktop specifications ----------------------------------");
        System.out.println("Monitor     : " + monitor + "\n");
        System.out.println("Keyboard    : " + keyboard + "\n");
        System.out.println("Mouse       : " + mouse + "\n");
        System.out.println("Speaker     : " + speaker + "\n");
        System.out.println("RAM         : " + ram + "\n");
        System.out.println("Processor   : " + processor + "\n");
        System.out.println("Motherboard : " + motherboard + "\n");
    }
}
