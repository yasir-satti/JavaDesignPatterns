package JavaDesignPatterns.Builder;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderJUnit5SysLambdaTest {

    String dellSpecs = "--------------- Desktop specifications ----------------------------------\n" +
            "Monitor     : Dell monitor\n" +
            "\n" +
            "Keyboard    : Dell keyboard\n" +
            "\n" +
            "Mouse       : Dell mouse\n" +
            "\n" +
            "Speaker     : Dell speaker\n" +
            "\n" +
            "RAM         : Dell RAM\n" +
            "\n" +
            "Processor   : Dell processor\n" +
            "\n" +
            "Motherboard : Dell motherboard";

    String hpSpecs = "--------------- Desktop specifications ----------------------------------\n" +
            "Monitor     : HP monitor\n" +
            "\n" +
            "Keyboard    : HP keyboard\n" +
            "\n" +
            "Mouse       : HP mouse\n" +
            "\n" +
            "Speaker     : HP speaker\n" +
            "\n" +
            "RAM         : HP RAM\n" +
            "\n" +
            "Processor   : HP processor\n" +
            "\n" +
            "Motherboard : HP motherboard";

    @Test
    public void buildHPDesktop() throws Exception{
        Director director = new Director();
        DellDesktopBuilder dellBuilder = new DellDesktopBuilder();
        director.buildDellDesktop(dellBuilder);
        Desktop dellDesktop = dellBuilder.getDesktop();
        String builderOutputText = (
                tapSystemOut(() -> {
                    dellDesktop.showSpecs();
                })
        )
                .trim();
        assertEquals(dellSpecs, builderOutputText);
    }

    @Test
    public void buildDellDesktop() throws Exception{
        Director director = new Director();
        HPDesktopBuilder hpBuilder = new HPDesktopBuilder();
        director.buildHPDesktop(hpBuilder);
        Desktop hpDesktop = hpBuilder.getDesktop();
        String builderOutputText = (
                tapSystemOut(() -> {
                    hpDesktop.showSpecs();
                })
            )
                .trim();
        assertEquals(hpSpecs, builderOutputText);
    }
}
