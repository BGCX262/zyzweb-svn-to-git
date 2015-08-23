import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String[] a={};
		double[][] data ={};
//		a=new String[5];
//		a[0]="1";
		data=new double[5][1];
		System.out.println(a.length);
		if(true )return;
/*		 DecimalFormat df = new DecimalFormat("0.00%");
		 double r=  993.0/1045.0;
		 String p=df.format(Float.parseFloat("993")/Float.parseFloat("1045.0"));
		 System.out.println(r);
		 System.out.println(p);
		if(1==1)
		return;*/
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File("D:\\projects\\zyzWeb\\doc\\hk1.txt")));
		String file = "D:\\projects\\zyzWeb\\doc\\hk.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		String line = null;
 

		while ((line = br.readLine()) != null) {

			String l[] = line.split(" ");
			String did = l[0];
			String dname = l[1];
			 
				StringBuffer sb = new StringBuffer();
				sb.append("insert t_dictionay(id,name,type) values('")
						.append(did).append("','").append(dname).append("','ZYFL');");
				bw.write(sb.toString()+"\n");
			 
		}
		bw.close();
		br.close();
	}

}
