package JavaDesignPatterns.Builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);
    }

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
    public void buildHPDesktop(){
        Director director = new Director();
        DellDesktopBuilder dellBuilder = new DellDesktopBuilder();
        director.buildDellDesktop(dellBuilder);
        Desktop dellDesktop = dellBuilder.getDesktop();
        dellDesktop.showSpecs();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals(dellSpecs, builderOutput);
    }

    @Test
    public void buildDellDesktop(){
        Director director = new Director();
        HPDesktopBuilder hpBuilder = new HPDesktopBuilder();
        director.buildHPDesktop(hpBuilder);
        Desktop hpDesktop = hpBuilder.getDesktop();
        hpDesktop.showSpecs();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals(hpSpecs, builderOutput);
    }

    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }
}
