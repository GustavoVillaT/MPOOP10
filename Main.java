/**
* @author Brigada 4
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.StringTokenizer;
public class Main {
  public static void main(String[] args) {
    System.out.println("########FILE######");
    File archivo=new File("archivo.txt");
    System.out.println(archivo.exists());
    if(!archivo.exists()){
      try{
        boolean seCreo = archivo.createNewFile();
        System.out.println(seCreo);
        System.out.println(archivo.exists());
      }catch(IOException ex){
        System.out.println(ex.getMessage());
      }
    }
    System.out.println("########FILEWRITER######");
    try{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Escriba texto para el archivo");
      String texto = br.readLine();
      String texto2="Hola mundo";
      FileWriter fw=new FileWriter("fw.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida= new PrintWriter(bw);
      salida.println(texto);
      salida.println(texto2);
      salida.println("Texto de la linea 3");
      for(int i=0;i<10;i++){
        salida.println("Texto de la linea "+(i+4)+" del for");
      }
      String[] arrayVocales={"a","e","i","o","u"};
      for(int i=0;i<arrayVocales.length;i++){
        salida.println(arrayVocales[i]);
      }
      for(int i=0;i<10;i++){
        salida.println("Gustavo,Villa,Calvo,317044636,20,80");
      }
      salida.close();
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    System.out.println("########FILEREADER######");
    try{
      FileReader fr=new FileReader ("fw.csv");
      BufferedReader br=new BufferedReader(fr);
      String linea=br.readLine();
      while(linea!=null){
        System.out.println(linea);
        linea=br.readLine();
      }
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    System.out.println("########StringTokenizer######");
    String linea="Gustavo,Villa,Calvo,317044636,20,80";
    StringTokenizer tokenizador =new StringTokenizer(linea,",");
    int count=0;
    String nombre=null,aPaterno=null,aMaterno=null;
    int numerocuenta=0,edad=0;
    float creditos=0;
    while(tokenizador.hasMoreTokens()){  
      String aux = tokenizador.nextToken();
      System.out.println(aux);
      if(count==0){
        nombre = aux;
        count++;
      }else if(count==1){
        aPaterno=aux;
        count++;
      }else if(count==2){
        aMaterno=aux;
        count++;
      }else if(count==3){
        numerocuenta=Integer.parseInt(aux);
        count++;
      }else if(count==4){
        edad=Integer.parseInt(aux);
        count++;
      }else if(count==5){
        creditos=Float.parseFloat(aux);
      }
    }
    System.out.println("El alumno es "+ nombre+" "+aPaterno+" "+aMaterno+" "+" "+numerocuenta+" "+edad+" "+creditos);
    count=0;
  }
}