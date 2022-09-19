package JavaDesignPatterns.Builder;

public class Director {

    public void buildDellDesktop(DellDesktopBuilder dellDesktopBuilder){
        dellDesktopBuilder.buildMonitor();
        dellDesktopBuilder.buildKeyboard();
        dellDesktopBuilder.buildMouse();
        dellDesktopBuilder.buildSpeaker();
        dellDesktopBuilder.buildRAM();
        dellDesktopBuilder.buildProcessor();
        dellDesktopBuilder.buildMotherboard();
    }

    public void buildHPDesktop(HPDesktopBuilder hpDesktopBuilder){
        hpDesktopBuilder.buildMonitor();
        hpDesktopBuilder.buildKeyboard();
        hpDesktopBuilder.buildMouse();
        hpDesktopBuilder.buildSpeaker();
        hpDesktopBuilder.buildRAM();
        hpDesktopBuilder.buildProcessor();
        hpDesktopBuilder.buildMotherboard();
    }
}
