package IV.Control;

import IV.View.Display;

public class Next implements Command {

    private final Display display;

    public Next(Display display) {
        this.display = display;
    }
    @Override
    public void execute() {
        display.show(display.image().next());
    }
}
