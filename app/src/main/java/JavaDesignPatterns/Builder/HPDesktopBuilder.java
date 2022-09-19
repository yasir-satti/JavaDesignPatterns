package JavaDesignPatterns.Builder;

public class HPDesktopBuilder implements Builder{

    Desktop desktop = new Desktop();
    @Override
    public void buildMonitor() {
        desktop.setMonitor("HP monitor");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("HP keyboard");
    }

    @Override
    public void buildMouse() {
        desktop.setMouse("HP mouse");
    }

    @Override
    public void buildSpeaker() {
        desktop.setSpeaker("HP speaker");
    }

    @Override
    public void buildRAM() {
        desktop.setRAM("HP RAM");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("HP processor");
    }

    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("HP motherboard");
    }

    public Desktop getDesktop() {
        return desktop;
    }
}