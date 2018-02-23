package mydev.min; import java.awt.BorderLayout; import java.awt.Button; import java.awt.Canvas; import java.awt.Color; import java.awt.Event; import java.awt.FlowLayout; import java.awt.Frame; import java.awt.Graphics; import java.awt.Panel; import java.awt.Point; import java.awt.Rectangle; import java.awt.TextField; import java.util.Vector; public class Select { Vector v1; public Select() { super();} public static void main(String[] args) { Select dis=new Select(); MainFrame fm=new MainFrame("Morning"); fm.prepare(); fm.show(); while(!fm.isStopped()) { dis.doSome(fm); try { Thread.sleep(1000);} catch(InterruptedException e) { e.getMessage();}} fm.stop(); dis.stop();} private void stop() { System.exit(1-1);} private void doSome(MainFrame fm) { int number; boolean ready; if(v1==null) { v1=new Vector(); v1.addElement(new Integer(1+1));} number=((Integer) v1.elementAt(v1.size()-1)).intValue(); do { ready=true; number+=1; for(int i=0; i < v1.size() && ready; i++) if(number-number /((Integer) v1.elementAt(i)).intValue() *((Integer) v1.elementAt(i)).intValue()==0) ready=false;} while(!ready); v1.addElement(new Integer(number)); fm.translate(v1.elementAt(v1.size()-1));}} class MainFrame extends Frame { boolean stopped; CenterItem er; LeftItem lp; public MainFrame(String nms) { super(nms); this.stopped=false;} public void translate(Object number) { lp.ack(""+((Integer) number).intValue()); er.translate(((Integer) number).intValue()); er.repaint();} public boolean handleEvent(Event evt) { if(evt.id==Event.WINDOW_DESTROY) stopped=true; if(evt.id==Event.ACTION_EVENT && evt.target==lp.start) er.init(); return super.handleEvent(evt);} public void stop() { hide(); dispose();} public boolean isStopped() { return stopped;} public void prepare() { setLayout(new FlowLayout()); add(lp=new LeftItem()); add(er=new CenterItem()); pack();}} class CenterItem extends Canvas { Rectangle r1; int startx; int dc1; int dc2; int dc11; int dc22; int starty; public CenterItem() { super(); resize(400,300); this.r1=null; init();} void init() { this.dc1=10; this.dc2=20; this.startx=0; this.starty=0; this.dc11=-10; this.dc22=-20;} public void translate(int number) { if(dc1 > dc2) { dc2=dc1+number; dc22=dc11-number;} else { dc1=dc2+number; dc11=dc22-number;}} public void paint(Graphics cs) { super.paint(cs); if(r1==null) r1=bounds(); cs.setColor(Color.black); Point br=Extract.start(startx,dc2 > dc1 ? dc2 : dc1); cs.drawArc(100,100,200,200,br.x,br.y); cs.setColor(Color.gray); cs.fillArc(100,100,200,200,br.x,br.y); cs.setColor(Color.black); Point pcm=Extract.tm(starty,dc22 < dc11 ? dc22 : dc11); cs.drawArc(100,100,200,200,pcm.x,pcm.y); cs.setColor(Color.darkGray); cs.fillArc(100,100,200,200,pcm.x,pcm.y); cs.setColor(Color.black); startx=dc2 > dc1 ? dc2 : dc1; starty=dc22 < dc11 ? dc22 : dc11; int xy=startx-starty; int dln; int lines; xy=xy < 0 ? 0-xy : xy; dln=r1.width+r1.height+r1.width+r1.height; xy=xy >= dln ? xy-xy / dln * dln : xy; lines=0; for(int i=xy; i < xy+dc1-dc11; i++) { if(i-i / 10 * 10==0 && lines <= 12) { lines++; if(i < dln / 2) { Point p1=Extract.from(i); Point p2=Extract.where(i); cs.drawLine(p1.x,p1.y,p2.x,p2.y);} else { Point p1=Extract.where(i-dln / 2); Point p2=Extract.from(i-dln / 2); cs.drawLine(p1.x,p1.y,p2.x,p2.y);}}}}} class Extract { static Point start(int min,int max) { Point px=new Point(min,max); max=max-min; min=min-min / 360 * 360; max=min+max; max=max-max / 360 * 360; px.x=min < max ? min : max; px.y=max > min ? max : min; return px;} public static Point tm(int min,int max) { Point pr=new Point(min,max); min=min-min / 360 * 360; max=max-max / 360 * 360; min=min < max ? min : max; max=max > min ? max : min; min+=360 / 2; max+=360 / 2; pr.x=min < max ? min : max; pr.y=max > min ? max : min; return pr;} static Point from(int xy) { if(xy > 0 && xy < 300) return new Point(xy,0); if(xy >= 300 && xy < 400) return new Point(xy,0); if(xy >= 400 && xy < 700) return new Point(400,xy-400); return new Point(0,0);} static Point where(int xy) { if(xy > 0 && xy < 300) return new Point(0,xy); if(xy >= 300 && xy < 400) return new Point(xy-300,300); if(xy >= 400 && xy < 700) return new Point(xy-300,300); return new Point(0,0);}} class LeftItem extends Panel { Button start; TextField tf; public LeftItem() { super(); setLayout(new BorderLayout()); add("North",start=new Button("Start")); add("South",tf=new TextField(10)); tf.enable(false);} public void ack(String string) { tf.setText(""+string);}}