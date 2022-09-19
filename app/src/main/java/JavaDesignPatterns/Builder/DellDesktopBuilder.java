package JavaDesignPatterns.Builder;

public class DellDesktopBuilder implements Builder{

    Desktop desktop = new Desktop();
    @Override
    public void buildMonitor() {
        desktop.setMonitor("Dell monitor");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("Dell keyboard");
    }

    @Override
    public void buildMouse() {
        desktop.setMouse("Dell mouse");
    }

    @Override
    public void buildSpeaker() {
        desktop.setSpeaker("Dell speaker");
    }

    @Override
    public void buildRAM() {
        desktop.setRAM("Dell RAM");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("Dell processor");
    }

    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("Dell motherboard");
    }

    public Desktop getDesktop() {
        return desktop;
    }
}
