package mydev.aaa; import java.lang.Thread; import java.lang.InterruptedException; public class Sleeper { public Sleeper() {} public void sleep(long ms) { try { Thread.sleep(ms);} catch(InterruptedException ex) {}}}