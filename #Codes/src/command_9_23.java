public class command_9_23 {
    private String cmd;
    private String cmdArg;

    public command_9_23(String cmd, String cmdArg) {
        this.cmd = cmd;
        this.cmdArg = cmdArg;
    }

    public String getCmd() {
        return cmd + " " + cmdArg;
    }
    @Override
    public String toString(){
        StringBuilder sm = new StringBuilder();
        sm.append(cmd);
        sm.append(" ");
        sm.append(cmdArg);
        return sm.toString();
    }
}
