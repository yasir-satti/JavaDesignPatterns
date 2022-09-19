package JavaDesignPatterns.Builder;

public class DesktopSpecsApp {

    public static void main(String[] args){

        Director director = new Director();
        DellDesktopBuilder dellBuilder = new DellDesktopBuilder();
        director.buildDellDesktop(dellBuilder);
        Desktop dellDesktop = dellBuilder.getDesktop();
        dellDesktop.showSpecs();

        HPDesktopBuilder hpBuilder = new HPDesktopBuilder();
        director.buildHPDesktop(hpBuilder);
        Desktop hpDesktop = hpBuilder.getDesktop();
        hpDesktop.showSpecs();


    }
}
