package IV.Control;

import IV.View.Display;

public class Prev implements Command {

    private final Display display;

    public Prev(Display display) {
        this.display = display;
    }
    @Override
    public void execute() {
        display.show(display.image().prev());
    }
}
