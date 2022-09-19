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

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }
}
