package groovyjarjarantlr;

class DefaultToolErrorHandler implements ToolErrorHandler {
    private final Tool DW;
    CharFormatter j6;

    DefaultToolErrorHandler(Tool tool) {
        this.j6 = new JavaCharFormatter();
        this.DW = tool;
    }
}
