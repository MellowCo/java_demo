package WebDown;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WebDowner {

    void down(String url,String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}
