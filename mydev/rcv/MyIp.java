package mydev.rcv; import java.io.FileInputStream; import java.io.InputStream; import java.io.OutputStream; import java.net.InetAddress; import java.net.Socket; public class MyIp { static final String FILE_NAME="files.tree"; static String dstAddress="localhost"; static int dstPort=6012; static String ftPath=null; public static void main(String[] args) { for(int i=0; i < args.length; i++) { String e=args[i]; if(e.indexOf("MyIp") >= 0) continue; int port=-1; try { port=Integer.parseInt(e);} catch(Throwable th) { th.getMessage(); port=-1;} finally { if(port > 0) dstPort=port;} if(port < 0) dstAddress=""+e;} String s1=""; Socket e1; long total=0L; OutputStream os; InputStream is; int em,num; byte[] buf=new byte[8]; buf[0]='1'; buf[1]='2'; buf[2]='3'; buf[3]='d'; buf[4]='i'; buf[5]='s'; buf[6]='\0'; em=((int) buf[0]+buf[1]+buf[2]+buf[3]+buf[4]+buf[5]+buf[6]); buf[7]=(byte)(em-em / 127 * 127); try { s1+=InetAddress.getLocalHost(); e1=new Socket(dstAddress,dstPort); System.out.println(""+e1+" "+e1.getInetAddress()); os=e1.getOutputStream(); is=new FileInputStream(ftPath !=null ? ftPath : FILE_NAME); if(is !=null) { do { buf=new byte[8192]; num=is.read(buf); if(num > 0) { if(num==buf.length) os.write(buf); else { for(int i=0; i < num; i++) os.write(buf[i]);} total+=num;}} while(num > 0); is.close(); System.out.println(""+total+" bytes sent");} else { os.write(buf); System.out.println("std sent");} os.close(); e1.close();} catch(Throwable ex1) { System.out.println("ER:"+ex1.getMessage());} System.out.println("Hello Wind World!"+s1);}}