package mydev.pvr; public class PvrLunch implements HiDen { public PvrLunch() { super();} public void hiden() { System.out.println(HiDen.BEEP+HiDen.EMPTYSTR);} public static void main(String[] args) { java.awt.Frame pfm; PvrLunch pvrLunch=new PvrLunch(); java.awt.Window win=new java.awt.Window(pfm=new java.awt.Frame(pvrLunch !=null ? "" : "A")); java.awt.Dimension ss=win.getToolkit().getDefaultToolkit().getScreenSize(); MyAppCtx ctx=new MyAppCtx(pfm,win); ctx.toogleGridView(); win.setBackground(java.awt.Color.black); win.show(); win.resize(1024,600); java.awt.Rectangle bs=win.bounds(),scr=new java.awt.Rectangle(F,F,ss.width-FF,ss.height-FF); bs.width=1024; bs.height=600; int newx=bs.x,newy=bs.y; if(bs.x < scr.x) newx+=scr.x-bs.x; if(bs.x+bs.width >= scr.width) newx-=bs.x+bs.width-scr.width; if(bs.y < scr.y) newy+=scr.y-bs.y; if(bs.y+bs.height >= scr.height) newy-=bs.y+bs.height-scr.height; win.move(newx,newy); win.reshape(newx,newy,bs.width,bs.height); java.awt.Canvas cs; win.add(cs=new MyCanvas(ctx)); java.awt.Scrollbar scbar; win.add(scbar=new MyScBar(java.awt.Scrollbar.VERTICAL,1,9,1,2,ctx)); int D=4 / 2,SB=scbar.size().width; if(SB < 1) SB=15; int csx=0,csy=0; cs.setBackground(java.awt.Color.white); java.awt.Dimension csdim=cs.size(); csdim.width=bs.width-SB-D-D-D; csdim.height=bs.height-D-D; cs.resize(csdim); csx+=D; csy+=D; cs.move(csx,csy); int srx=0,sry=0; java.awt.Dimension srdim=scbar.size(); srdim.width=SB; srdim.height=bs.height-D-D; scbar.resize(srdim); srx+=csx+csdim.width+D; sry+=D; scbar.move(srx,sry); scbar.setBackground(java.awt.Color.red); scbar.setForeground(java.awt.Color.white); scbar.enable(); scbar.nextFocus(); while(ctx.reps-->= 0) { win.invalidate(); ctx.reps++; try { Thread.sleep(1000);} catch(InterruptedException ex) { ex.getMessage();} cs.repaint(); scbar.setValues(scbar.getValue(),ctx.getMaxVisibleLines(),scbar.getMinimum(),ctx.getLineMax());} ctx.winShutdown();} public void write(String fPath,byte[] bCont) throws java.io.IOException { java.io.File wOpen=new java.io.File(fPath); java.io.FileOutputStream os=new java.io.FileOutputStream(wOpen); os.write(bCont); os.flush(); os.close();}} class MyCanvas extends java.awt.Canvas implements HiDen { MyAppCtx ctx; boolean showed; MyActionsDlg dlg; final int N=8; java.awt.Font upset,numera; int numSize=0; java.awt.Rectangle r; public MyCanvas(MyAppCtx ctx) { super(); this.ctx=ctx; this.showed=false; ctx.setPaneBg(java.awt.Color.white); ctx.setPaneData(java.awt.Color.blue); ctx.setPaneGrid(java.awt.Color.blue); ctx.setPaneGridLine(java.awt.Color.black); ctx.setPaneGridShift(java.awt.Color.red);} String toosse(int line) { String vozvrat=MyCharacter.EMPTYSTR+line; while(vozvrat.length() < 4) vozvrat="0"+vozvrat; return vozvrat;} boolean matchSq(java.awt.Rectangle container,java.awt.Rectangle item) { java.awt.Rectangle r=container; java.awt.Rectangle cr=item; boolean result=cr.x > r.x && cr.y > r.y && cr.x+cr.width < r.x+r.width && cr.y+cr.height < r.y+r.height; return result;} boolean doesNotMatchSq(java.awt.Rectangle container,java.awt.Rectangle item) { java.awt.Rectangle r=container; java.awt.Rectangle cr=item; boolean result=!(cr.x > r.x && cr.y > r.y && cr.x+cr.width < r.x+r.width && cr.y+cr.height < r.y+r.height); return result;} boolean matchBw(java.awt.Rectangle container,java.awt.Rectangle item) { java.awt.Rectangle r=container; java.awt.Rectangle cr=item; boolean result=cr.x > r.x && cr.x+cr.width < r.x+r.width; return result;} boolean doesNotMatchBw(java.awt.Rectangle container,java.awt.Rectangle item) { java.awt.Rectangle r=container; java.awt.Rectangle cr=item; boolean result=!(cr.x > r.x && cr.x+cr.width < r.x+r.width); return result;} public void paint(java.awt.Graphics ics) { super.paint(ics); int lineStart=ctx.getLookEtLine(),lineShowed=0,curLine=1; if(upset==null) { upset=ics.getFont(); numera=new java.awt.Font(upset.getFamily(),java.awt.Font.PLAIN,upset.getSize()-2); upset=new java.awt.Font(upset.getFamily(),java.awt.Font.BOLD,upset.getSize()+2); ics.setFont(upset);} else ics.setFont(upset); MyString text=new MyString(); text.append("Hey, you!"); int sx=100,sy=200; if(!ctx.ready()) { ics.setColor(java.awt.Color.black); ics.drawString(text.easy(),100,100);} else { text=ctx.getText(); sx=N * 3 / 2+numSize; sy=0; ctx.setLineMistake((int)(N * 1.5f));} if(r==null) { r=bounds(); r.x=N / 2; r.y=N / 2; r.width-=N; r.height-=N; ctx.setLineSpace(r.height);} ics.setColor(java.awt.Color.blue); java.awt.FontMetrics fm=ics.getFontMetrics(); boolean prevNoda=false; for(int i=0; i < text.positions(); i++) { MyCharacter c=text.edinicca(i); if(curLine < lineStart) { if(c.noda()) curLine++; continue;} int cw=c.shirina(fm,ctx.isHexView()==false)+1+(ctx.isGridView() ? 1 : 1-1); int che=fm.getHeight()+(ctx.isGridView() ? 1 : 1-1); if(sy==0) { sy=N+che; ctx.setLineHeight(che);} if(prevNoda) { sy+=che; sx=N * 3 / 2+numSize; ics.setColor(ctx.getPaneData()); curLine++;} if(curLine !=lineShowed) { ics.setFont(numera); ics.setColor(java.awt.Color.black); if(sy < r.y+r.height) ics.drawString(toosse(curLine),N,sy); if(numSize==0) numSize=ics.getFontMetrics().charWidth('0') * 4; lineShowed=curLine; ctx.checkLine(curLine); ics.setFont(upset);} prevNoda=c.noda(); if(c.noda()) { ics.setFont(numera); ics.setColor(ctx.getPaneGridLine());} else ics.setColor(c.hot() ? ctx.getPaneGridShift() : ctx.getPaneGrid()); java.awt.Rectangle cr=new java.awt.Rectangle(sx,sy-che+fm.getDescent()+1,cw+1,che); if(doesNotMatchBw(r,cr)) { ctx.checkLayoutLine(curLine); sy+=che; sx=N * 3 / 2+numSize; cr=new java.awt.Rectangle(sx,sy-che+fm.getDescent()+1,cw+1,che);} if(matchSq(r,cr)) { ics.drawRect(cr.x,cr.y,cr.width,cr.height); ics.setColor(c.noda() ? java.awt.Color.black : ctx.getPaneData()); ics.drawString(ctx.isHexView() ? c.custom() : c.easy(),sx+1+(c.noda() ? 10 : 1),sy);} sx+=cw+1;} if(showed) { java.awt.Dimension dim=size(); java.awt.Point loc=location(); ics.setColor(java.awt.Color.yellow); ics.drawLine(loc.x,loc.y,loc.x+dim.width,loc.y+dim.height); ics.drawOval(loc.x+E,loc.y+E,dim.width-E-E,dim.height-E-E);}} public void hiden() { showed=false;} public boolean handleEvent(java.awt.Event et) { switch(et.id) { case java.awt.Event.MOUSE_DOWN : if(!showed) { showed=true; dlg=new MyActionsDlg(ctx,this).create().view();} else if(dlg !=null) { dlg.hide(); dlg.show();}} return super.handleEvent(et);}} interface HiDen { final String EMPTYSTR=new String(""); final String BEEP=new String("\\"); void hiden(); final int E=82; final int F=0x29,FF=2 * F;} class MyActionsDlg extends java.awt.Window { MyAppCtx ctx; java.awt.Button open,grid,prop,hexit; HiDen obj; public MyActionsDlg(MyAppCtx ctx,HiDen obj) { super(ctx.getMainfr()); this.ctx=ctx; this.obj=obj;} public boolean missed(int x,int y) { java.awt.Point loc=location(); java.awt.Dimension dim=size(); if(x < loc.x) return true; if(x > loc.x+dim.width) return true; if(y < loc.y) return true; if(y > loc.y+dim.height) return true; return false;} MyActionsDlg create() { setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER)); setBackground(java.awt.Color.red); open=new java.awt.Button("Read any other file?"); add(open); grid=new java.awt.Button("Enable/Disable grid view?"); add(grid); prop=new java.awt.Button("Hexadecimal viewer?"); add(prop); hexit=new java.awt.Button("about to Exit?"); add(hexit); repaint(); return this;} public void paint(java.awt.Graphics ics) { super.paint(ics); ics.setColor(java.awt.Color.red); java.awt.Point loc=location(); java.awt.Dimension dim=size(); ics.drawRect(loc.x,loc.y,loc.x+dim.width,loc.y+dim.height); ics.drawRect(loc.x+1,loc.y+1,loc.x+dim.width-1-1,loc.y+dim.height-1-1);} MyActionsDlg view() { show(); java.awt.Point loc=ctx.getWinLoc(); java.awt.Rectangle bounds=ctx.getWinBs(); int dx=221,dy=111+3+2+1; int zeta=bounds.width+bounds.height; while(zeta > 12) zeta /= 12; zeta=zeta-zeta / 2 * 2==1 ?-zeta : zeta; reshape(loc.x+(1024-dx) / 2-zeta,loc.y+(600-dy) / 2+zeta,dx,dy); return this;} public boolean handleEvent(java.awt.Event et) { if(et.id==java.awt.Event.WINDOW_DESTROY) { dlgHide(); if(obj !=null) obj.hiden();} if(et.target instanceof java.awt.Button && et.target.equals(hexit)) { dlgHide(); ctx.winShutdown();} if(et.target instanceof java.awt.Button && et.target.equals(open)) { dlgHide(); if(obj !=null) obj.hiden(); new MyExitDlg(ctx).create().view();} if(et.target instanceof java.awt.Button && et.target.equals(grid)) { ctx.toogleGridView(); dlgHide(); if(obj !=null) obj.hiden();} if(et.target instanceof java.awt.Button && et.target.equals(prop)) { ctx.toogleHexView(); dlgHide(); if(obj !=null) obj.hiden();} return super.handleEvent(et);} void dlgHide() { hide(); dispose();}} class MyExitDlg extends java.awt.Window { private MyAppCtx ctx; java.awt.Button yes,no; public MyExitDlg(MyAppCtx ctx) { super(ctx.getMainfr()); this.ctx=ctx;} MyExitDlg create() { setLayout(new java.awt.FlowLayout()); setBackground(java.awt.Color.red); java.awt.Label prop=new java.awt.Label("Are you sure want to Exit?"); add(prop); java.awt.Button yes=new java.awt.Button("Yes"); add(yes); java.awt.Button no=new java.awt.Button("No"); add(no); String[] drives=shows(); for(int i=0; i < drives.length; i++) { Mif dr=new Mif(drives[i],this,drives[i]); add(dr);} setButtons(yes,no); return this;} MyExitDlg view() { show(); java.awt.Point loc=ctx.getWinLoc(); java.awt.Rectangle bounds=ctx.getWinBs(); int dx=400,dy=400; int zeta=bounds.width+bounds.height; while(zeta > 12) zeta /= 12; zeta=zeta-zeta / 2 * 2==1 ?-zeta : zeta; reshape(loc.x+(1024-dx) / 2-zeta,loc.y+(600-dy) / 2+zeta,dx,dy); return this;} String[] shows() { java.util.Vector vt=new java.util.Vector(); String osi=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); try { for(int i=0; i < osi.length(); i++) { char l=osi.charAt(i); String testVol=new String(l+":"+HiDen.BEEP); java.io.File fi=new java.io.File(testVol); if(fi.exists()) vt.addElement(testVol);}} catch(Exception e) { e.getMessage();} String[] drives=new String[vt.size()]; for(int i=0; i < vt.size(); i++) drives[i]=(String) vt.elementAt(i); return drives;} void setButtons(java.awt.Button yes,java.awt.Button no) { this.yes=yes; this.no=no;} public boolean handleEvent(java.awt.Event et) { if(et.id==java.awt.Event.WINDOW_DESTROY) { dlgHide();} if(et.target instanceof java.awt.Button && et.target.equals(yes)) { dlgHide();} if(et.target instanceof java.awt.Button && et.target.equals(no)) { dlgHide();} return super.handleEvent(et);} private void dlgHide() { hide(); dispose();} public void selected(String arg) { ctx.setPath(arg); dlgHide();}} class Mif extends java.awt.Button { private String arg; private MyExitDlg wz; private String lbl; public Mif(String arg0,MyExitDlg wz,String lbl) { super(lbl); this.arg=arg0; this.wz=wz; this.lbl=lbl;} public void paint(java.awt.Graphics cs) { super.paint(cs);} public boolean handleEvent(java.awt.Event et) { if(et.id==java.awt.Event.ACTION_EVENT) { disable(); if(new java.io.File(arg).isFile()) selected(); else recall();} return super.handleEvent(et);} private void recall() { java.io.File it=new java.io.File(arg); String[] items=it.list(); wz.removeAll(); wz.add(new java.awt.Label(arg+HiDen.BEEP)); for(int i=0; i < items.length; i++) { wz.add(new Mif(arg+HiDen.BEEP+items[i],wz,items[i]));} wz.invalidate(); wz.repaint(); wz.show();} private void selected() { wz.selected(arg);} public String toString() { return "Mif [arg="+arg+", lbl="+lbl+"]";}} class MyAppCtx extends Object { int reps; java.awt.Frame mainfr; String path; boolean freshPath; int lineMax,layoutLine; int lineHeight,lineSpace,lineMistake; java.awt.Color paneBg,paneGrid,paneData,paneGridShift,paneGridLine; boolean toogleGridView,toogleHex; java.awt.Window win; private MyTextReader rdr; private int lookEtLine; MyAppCtx() { super(); reps=1; lineMax=0; layoutLine=0; lineHeight=0; lineSpace=0; toogleGridView=true; toogleHex=false; lookEtLine=1; rdr=null;} public MyString getText() { MyString text; if(freshPath) { rdr=new MyTextReader(path); freshPath=false; text=rdr.next(32);} else text=(rdr==null ? rdr=new MyTextReader(path) : rdr).next(32); return text;} public void setPath(String arg) { path=new String(arg); freshPath=true;} public java.awt.Point getWinLoc() { return win.location();} public java.awt.Rectangle getWinBs() { return win.bounds();} public int getLayoutLine() { return layoutLine;} public void checkLayoutLine(int curLine) { layoutLine++;} public void toogleGridView() { this.toogleGridView=!toogleGridView;} public void toogleHexView() { this.toogleHex=!toogleHex;} public boolean isHexView() { return toogleHex;} public boolean isGridView() { return toogleGridView;} public java.awt.Color getPaneGridShift() { return toogleGridView ? paneGridShift : paneBg;} public void setPaneGridShift(java.awt.Color paneGridShift) { this.paneGridShift=paneGridShift;} public java.awt.Color getPaneGridLine() { return toogleGridView ? paneGridLine : paneBg;} public void setPaneGridLine(java.awt.Color paneGridLine) { this.paneGridLine=paneGridLine;} public java.awt.Color getPaneBg() { return paneBg;} public void setPaneBg(java.awt.Color paneBg) { this.paneBg=paneBg;} public java.awt.Color getPaneGrid() { return toogleGridView ? paneGrid : paneBg;} public void setPaneGrid(java.awt.Color paneGrid) { this.paneGrid=paneGrid;} public java.awt.Color getPaneData() { return paneData;} public void setPaneData(java.awt.Color paneData) { this.paneData=paneData;} public void setLineHeight(int che) { this.lineHeight=che;} public void setLineSpace(int height) { this.lineSpace=height;} public void setLineMistake(int mist) { this.lineMistake=mist;} public int getMaxVisibleLines() { return lineHeight > 0 ?(lineSpace-lineMistake) / lineHeight : 1;} MyAppCtx(java.awt.Frame mainfr,java.awt.Window win) { super(); this.mainfr=mainfr; this.win=win;} java.awt.Frame getMainfr() { return mainfr;} void checkLine(int nl) { if(nl > lineMax) lineMax=nl;} public int getLineMax() { return lineMax;} void setMainfr(java.awt.Frame mainfr) { this.mainfr=mainfr;} void mainfrHide() { if(mainfr !=null) { mainfr.hide(); mainfr.dispose(); System.exit(1-1);}} void winShutdown() {--reps; reps--; if(win !=null) { win.hide(); win.dispose(); System.exit(1-1);}} boolean ready() { return path !=null && path.length() > 0;} public void setLookEt(int value) { this.lookEtLine=value;} public int getLookEtLine() { return lookEtLine;} public String toString() { return "MyAppCtx []";}} class MyTextReader extends Object { private MyString ready; private String path; private long pos; public MyTextReader(String path) { super(); this.path=path; ready=new MyString(); pos=0L;} public MyString next(long positions) { try { java.io.FileInputStream is=new java.io.FileInputStream(path); is.skip(pos); MyString tmp=new MyString(); for(int i=0; i < positions; i++) { int data=is.read(); char cc=(char) data; if(Character.isLetter(cc)) tmp.appendOne(new MyCharacter(cc)); else if(Character.isDigit(cc)) tmp.appendOne(new MyCharacter(cc)); else if(MyCharacter.isKnown(cc)) tmp.appendOne(new MyCharacter(cc)); else tmp.appendOne(new MyCharacter(data));} ready.append(tmp); pos+=positions;} catch(java.io.IOException ex) { ex.getMessage();} return ready;} public byte[] read() throws java.io.IOException { java.io.File fOpen=new java.io.File(this.path); java.io.FileInputStream fos=new java.io.FileInputStream(fOpen); java.util.Vector ht=new java.util.Vector(); int vPower=0; int count; byte[] buf=new byte[77]; do { count=fos.read(buf); if(count > 0) vPower+=count; if(count < 1) continue; if(count <= 77) { byte[] zzz=new byte[count]; System.arraycopy(buf,0,zzz,0,count); ht.addElement((Object) zzz);}} while(count > 0); fos.close(); byte[] total=new byte[vPower]; int totalIdx=0; for(int i=0; i < ht.size(); i++) { byte[] cur=(byte[]) ht.elementAt(i); int curLen=cur.length; System.arraycopy(cur,0,total,totalIdx,curLen); totalIdx+=curLen;} return total;} public String toString() { return "MyTextReader []";}} class MyCharacter extends Object implements HiDen { final char ONESPACE=(char)((int)(' ')); final char ONEYE=(char)((int)('e')); final char ONETE=(char)((int)('\t')); final String HEXAPP=new String("0x"); final String ETONOLL=new String("0"); private String cc; private boolean noda; public MyCharacter(char c) { super(); this.cc=new String(EMPTYSTR+c); this.noda=false;} public MyCharacter(int dc) { super(); String tmp=Integer.toHexString(dc).toUpperCase(); if(tmp.length() < 2) tmp=ETONOLL+tmp; this.cc=new String(HEXAPP+tmp); this.noda=MyCharacter.isNoda(dc);} public String custom() { String ret=EMPTYSTR; if(!cc.startsWith(HEXAPP)) for(int i=0; i < cc.length(); i++) ret+=new MyCharacter((int) cc.charAt(i)).easy(); else ret+=cc; return ret;} public String easy() { String ret=EMPTYSTR; if(cc.length()==1) { if(cc.charAt(0)==ONESPACE) ret+=ONESPACE; else if(cc.charAt(0)==ONETE) ret+=ONESPACE; else ret+=cc;} else ret+=cc; return ret;} public static boolean isKnown(char c) { switch(c) { case ' ' : case '\t' : case '.' : case ',' : case ':' : case ';' : case '<' : case '>' : case '(' : case ')' : case '{' : case '}' : case '=' : case '!' : case '+' : case '-' : case '*' : case '/' : case '|' : case 0x26 : case '\\' : case '\'' : case '\"' : case '[' : case ']' : case '?' : return true;} return false;} public static boolean isNoda(int dc) { return dc <= 0x0D;} public int shirina(java.awt.FontMetrics fm,boolean notHex) { String tg=notHex ? new String(cc) : custom(); int sh=0; for(int i=0; i < tg.length(); i++) { char c=tg.charAt(i); if(c==ONESPACE) sh+=fm.charWidth(ONEYE); else if(c==ONETE) sh+=fm.charWidth(ONEYE) * 4-1; else sh+=fm.charWidth(c);} if(noda()) sh+=10; return sh;} public boolean hot() { return cc.length()==1 && cc.charAt(0)==ONETE;} public boolean noda() { return noda;} public void nodapend(MyCharacter nn) { if(noda() && nn.noda()) cc=new String(cc+nn.easy());} public void hiden() { cc=new String(EMPTYSTR);} public String toString() { return "MyCharacter [cc="+cc+", noda="+noda+"]";}} class MyString extends Object { java.util.Vector ss; MyCharacter lastOne; public MyString() { super(); this.ss=new java.util.Vector();} public MyString append(String str) { for(int i=0; i < str.length(); i++) appendOne(new MyCharacter(str.charAt(i))); return this;} public MyString appendOne(MyCharacter c) { if(lastOne !=null && lastOne.noda() && c.noda()) lastOne.nodapend(c); else ss.addElement(c); lastOne=c; return this;} public MyString append(MyString g) { for(int i=0; i < g.ss.size(); i++) appendOne((MyCharacter) g.ss.elementAt(i)); return this;} public String easy() { String ret=MyCharacter.EMPTYSTR; for(int i=0; i < ss.size(); i++) ret+=((MyCharacter) ss.elementAt(i)).easy(); return ret;} public int positions() { return ss.size();} public MyCharacter edinicca(long pos) { MyCharacter retVal=(MyCharacter) ss.elementAt((int) pos); return retVal;} public String toString() { return "MyString [ss="+ss+", lastOne="+lastOne+"]";}} class MyScBar extends java.awt.Scrollbar { MyAppCtx ctx; public MyScBar(int arg0,int arg1,int arg2,int arg3,int arg4,MyAppCtx ct) { super(arg0,arg1,arg2,arg3,arg4); this.ctx=ct;} public boolean handleEvent(java.awt.Event et) { switch(et.id) { case java.awt.Event.SCROLL_ABSOLUTE : case java.awt.Event.SCROLL_LINE_DOWN : case java.awt.Event.SCROLL_LINE_UP : case java.awt.Event.SCROLL_PAGE_DOWN : case java.awt.Event.SCROLL_PAGE_UP : if(et.target instanceof MyScBar) { int value=((MyScBar) et.target).getValue(); ctx.setLookEt(value);} break;} return super.handleEvent(et);}}