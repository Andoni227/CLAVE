import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.*;

public class UNIDAD10{
   private static File archivo = null;
   private static FileReader fr = null;
   private static BufferedReader br = null;
   private static FileWriter fichero =null;
   private static PrintWriter escrive =null;
   private static BufferedReader bra = null;
   private static BufferedReader lee=new BufferedReader(new InputStreamReader(System.in));

   public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      System.out.println("Lista de registros: "); 
      while((cadena = b.readLine())!=null) {
         if(cadena.length()==26){
            System.out.println(cadena);
         }
      }
      b.close();
   }
   
   
   
   public static void papelera(int n){
      Vector lineas=new Vector();
      try { 
         archivo = new File ("registros.txt"); //RUTA DEL ARCHIVO
         fr = new FileReader (archivo);  //LECTOR DE RUTA
         br = new BufferedReader(fr);  //LECTOR DEL BUFFER
         String linea; //GUARDA EL TEXTO DE LA LINEA
         int cont=0; 
         while((linea=br.readLine())!=null){
            cont++;
            if(cont==n){                     //CUANDO EL CONTADOR NO CONTENGA EL NUMERO DE LINEA ESPECIFICADO
               lineas.addElement(linea+" -BOR");    //SE AGREGAN TODAS LAS LINEAS, EXCEPTO LA QUE SE DECIDIÓ ELIMINAR       
            }
            if(cont!=n){
               lineas.addElement(linea); 
            }
         }
         br.close(); 
         fr.close();
        //Se guarda de nuevo el archivo
         GuardarArchivo(lineas);
         lineas.clear();
      } catch (Exception e) { 
         System.out.println(e); 
      } 
   }
   
   
   public static void cambios(int n, String ID2){
      Vector lineas=new Vector();
      try { 
         archivo = new File ("registros.txt"); //RUTA DEL ARCHIVO
         fr = new FileReader (archivo);  //LECTOR DE RUTA
         br = new BufferedReader(fr);  //LECTOR DEL BUFFER
         String linea; //GUARDA EL TEXTO DE LA LINEA
         int cont=0; 
         while((linea=br.readLine())!=null){
            cont++;
            if(cont==n){                     //CUANDO EL CONTADOR NO CONTENGA EL NUMERO DE LINEA ESPECIFICADO
               lineas.addElement(ID2);    //SE AGREGAN TODAS LAS LINEAS, EXCEPTO LA QUE SE DECIDIÓ ELIMINAR       
            }
            if(cont!=n){
               lineas.addElement(linea); 
            }
         }
         br.close(); 
         fr.close();
        //Se guarda de nuevo el archivo
         GuardarArchivo(lineas);
         lineas.clear();
      } catch (Exception e) { 
         System.out.println(e); 
      } 
   }
   
   
   
   
   public static void recuperar(int n){
      Vector lineas=new Vector();
      try { 
         archivo = new File ("registros.txt"); //RUTA DEL ARCHIVO
         fr = new FileReader (archivo);  //LECTOR DE RUTA
         br = new BufferedReader(fr);  //LECTOR DEL BUFFER
         String linea; //GUARDA EL TEXTO DE LA LINEA
         int cont=0; 
         while((linea=br.readLine())!=null){
            cont++;
            if(cont==n){
               if(linea.length()==31){
                  lineas.addElement(linea.substring(0,26));    //SE AGREGAN TODAS LAS LINEAS, EXCEPTO LA QUE SE DECIDIÓ ELIMINAR       
               }
            }
            if(cont!=n){
               lineas.addElement(linea); 
            }
         }
         br.close(); 
         fr.close();
        //Se guarda de nuevo el archivo
         GuardarArchivo(lineas);
         lineas.clear();
      } catch (Exception e) { 
         System.out.println(e); 
      } 
   }
   
   
   

   public static void GuardarArchivo(Vector ln){
      try
      {
         fichero = new FileWriter("registros.txt");
         escrive = new PrintWriter(fichero);
         for(int i=0;i<ln.size();i++){
            escrive.println(ln.elementAt(i));
         }
         fichero.close();
      } catch (Exception e) {
         e.printStackTrace();
      } 
   }



   public static void BorrarLinea(int n){ 
      Vector lineas=new Vector();
      try { 
         archivo = new File ("registros.txt");
         fr = new FileReader (archivo);  
         bra = new BufferedReader(fr);     
         String linea; int cont=0;
         while((linea=bra.readLine())!=null){
            cont++;
            if(cont!=n){
               lineas.addElement(linea);//AGREGAR LINEAS A UN VECTOR
            }
         }
         bra.close(); 
         fr.close();
        //Se guarda de nuevo el archivo
         GuardarArchivo(lineas);
         lineas.clear();
      } catch (Exception e) { 
         System.out.println(e); 
      } 
   }




   public static void main (String[]args) throws IOException
   {
     
   
      BufferedReader  br=new BufferedReader (new InputStreamReader(System.in));
      int salir=0; 
      int folio=0; 
      int pnomb=0; 
      int pap=0; 
      int pam=0; 
      int number=0;
      String []nombre= new String [20];
      String []a_paterno= new String[20]; 
      String []a_materno= new String[20]; 
      String []dia= new String[20]; 
      String []mes= new String[20]; 
      String []year= new String[20]; 
      String []estado = new String[20]; 
      String []genero = new String[20]; 
      String []clave = new String[20]; 
      do{
         String menu=""; 
         String auxnm=""; 
         String auxap=""; 
         String auxam= ""; 
         String nacimiento1=""; 
         String mes2= ""; 
         int nacimiento2=0; 
         int n=0; 
         String estado1=""; 
         String genero2=""; 
         System.out.println("MENU");
         System.out.println("1. Captura");
         System.out.println("2. Consulta por entidad");
         System.out.println("3. Consultas generales");
         System.out.println("4. Cancelaciones"); 
         System.out.println("5. Bajas temporales");
         System.out.println("6. Reinstalaciones"); 
         System.out.println("7. Cambios de informacion"); 
         System.out.println("8. Salida"); 
         menu = br.readLine();
      
         if(menu.equals("1")){
            System.out.println("CAPTURA");
            File file2 = new File("registros.txt");
            if (!file2.exists()) {
               folio=folio+1;
            }else{             
               String cadena;
               String folio3="";
               FileReader f = new FileReader("registros.txt");
               BufferedReader b = new BufferedReader(f);
               while((cadena = b.readLine())!=null) {
                  //System.out.println(cadena);
                  //System.out.println(cadena.length());
                  if(cadena.length()==26){
                     folio3=cadena.substring(0,2);
                     folio=Integer.parseInt(folio3); 
                     folio=folio+1;                 
                  }          
               }              
            }         
            
           
            System.out.println("Folio: "+folio); 
                            
            do {
               auxnm = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su nombre o nombres:");
               for (n = 0; n < auxnm.length(); n++) {
                  pnomb = auxnm.charAt(n);     //Este for detecta si el nombre lleva numeros o no
               }
               if (pnomb < 64 || pnomb > 123) {
                  JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
               }
               if (auxnm.length() < 1) {
                  JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
               }
            } while (auxnm.length() < 1 || pnomb < 64 || pnomb > 123);
            
            do {
               auxap = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su apellido paterno:");
               for (n = 0; n < auxap.length(); n++) {
                  pap = auxap.charAt(n);     //Este for detecta si el nombre lleva numeros o no
               }
               if (pap < 64 || pap > 123) {
                  JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
               }
               if (auxap.length() < 1) {
                  JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
               }
            } while (auxap.length() < 1 || pap < 64 || pap > 123);
            
            do {
               auxam = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su apellido materno:");
               for (n = 0; n < auxam.length(); n++) {
                  pam = auxam.charAt(n);     //Este for detecta si el nombre lleva numeros o no
               }
               if (pam < 64 || pam > 123) {
                  JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
               }
               if (auxam.length() < 1) {
                  JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
               }
            } while (auxam.length() < 1 || pam < 64 || pam > 123);
         
            
            JOptionPane.showMessageDialog(null, "A continuación ingresará su fecha de nacimiento");
            Object dia1 = JOptionPane.showInputDialog(null,"Selecciona día de nacimiento",
                     "Día :3", JOptionPane.QUESTION_MESSAGE, null,
                     new Object[] {"01", "02", "03" , "04", "05","06","07","08","09","10","11","12","13",
                     "14", "15", "16" , "17", "18","19","20","21","22","23","24","25","26","27","28","29","30","31"}," ");
          
            Object mes1 = JOptionPane.showInputDialog(null,"Selecciona mes de nacimiento",
                     "Mes ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                     new Object[] {"Enero", "Febrero", "Marzo" , "Abril", "Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}," ");
              
            if(mes1=="Enero"){
               mes2="01"; 
            }
            if(mes1=="Febrero"){
               mes2="02"; 
            }
            if(mes1=="Marzo"){
               mes2="03"; 
            }
            if(mes1=="Abril"){
               mes2="04"; 
            }
            if(mes1=="Mayo"){
               mes2="05"; 
            }
            if(mes1=="Junio"){
               mes2="06"; 
            }
            if(mes1=="Julio"){
               mes2="07"; 
            }
            if(mes1=="Agosto"){
               mes2="08"; 
            }
            if(mes1=="Septiembre"){
               mes2="09"; 
            }
            if(mes1=="Octubre"){
               mes2="10"; 
            }
            if(mes1=="Noviembre"){
               mes2="11"; 
            }
            if(mes1=="Diciembre"){
               mes2="12"; 
            }
               
              
              
              
              
            do {
               number=0; 
               nacimiento1 = JOptionPane.showInputDialog("Ingrese su año de nacimiento (aaaa) o (aa)");
               if (nacimiento1.length()>=2 &&  nacimiento1.length()<=4 &&   nacimiento1.length()!=3){
                  if(nacimiento1.length()==4){                             
                     try {
                        nacimiento2 = Integer.parseInt(nacimiento1);
                     } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                        number = 1;               
                     }
                     if(number==0){
                        if(nacimiento2>=2000 && nacimiento2<=2100){
                           nacimiento2=nacimiento2-2000; 
                        }else if(nacimiento2>=1900 && nacimiento2<=1999){
                           nacimiento2=nacimiento2-1900; 
                        }else{
                           JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                           number=1; 
                        }
                     }                    
                  }
                  
                  
                  if(nacimiento1.length()==2){
                     try {
                        nacimiento2 = Integer.parseInt(nacimiento1);
                     } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                        number = 1;               
                     }               
                  }
                  
                  
                  
                  System.out.println("Fecha abreviada: "+nacimiento2); 
               }else{
                  JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                  number = 1; 
               }
            } while (number == 1);  
            
            
              
              
            Object estado2 = JOptionPane.showInputDialog(null,"Selecciona tu estado de nacimiento",
                     "Entidad federativa ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                     new Object[] {"Aguascalientes", "Baja California", "Baja California Sur" , "Campeche", "Chiapas","Chihuahua","Coahuila","Colima","CDMX",
                     "Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México (Edo. de)","Michoacan", "Morelos",
                     "Nayarit","Nuevo Leon", "Oaxaca", "Puebla","Queretaro","Quintana Roo", "San Luis Potosí","Sinaloa","Sonora",
                    "Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"}," ");
            
            if(estado2=="Aguascalientes"){
               estado1="AGS";
            }           
            if(estado2=="Baja California"){
               estado1="BCN";
            }  
            if(estado2=="Baja California Sur"){
               estado1="BCS";
            } 
            if(estado2=="Campeche"){
               estado1="CAM";
            } 
            if(estado2=="Chiapas"){
               estado1="CHP";
            } 
            if(estado2=="Chihuahua"){
               estado1="CHH";
            } 
            if(estado2=="Coahuila"){
               estado1="COA";
            } 
            if(estado2=="Colima"){
               estado1="COL";
            } 
            if(estado2=="CDMX"){
               estado1="CMX";
            } 
            if(estado2=="Durango"){
               estado1="DGO";
            } 
            if(estado2=="Guanajuato"){
               estado1="GTO";
            } 
            if(estado2=="Guerrero"){
               estado1="GRO";
            } 
            if(estado2=="Hidalgo"){
               estado1="HGO";
            } 
            if(estado2=="Jalisco"){
               estado1="JAL";
            } 
            if(estado2=="México (Edo. de)"){
               estado1="MEX";
            } 
            if(estado2=="Michoacan"){
               estado1="MIC";
            }              
            if(estado2=="Morelos"){
               estado1="MOR";
            }            
            if(estado2=="Nayarit"){
               estado1="NAY";
            } 
            if(estado2=="Nuevo Leon"){
               estado1="NLE";
            } 
            if(estado2=="Oaxaca"){
               estado1="OAX";
            } 
            if(estado2=="Puebla"){
               estado1="PUE";
            } 
            if(estado2=="Queretaro"){
               estado1="QRO";
            } 
            if(estado2=="Quintana Roo"){
               estado1="ROO";
            } 
            if(estado2=="San Luis Potosí"){
               estado1="SLP";
            }            
            if(estado2=="Sinaloa"){
               estado1="SIN";
            }            
            if(estado2=="Sonora"){
               estado1="SON";
            }            
            if(estado2=="Tabasco"){
               estado1="TAB";
            }
            if(estado2=="Tamaulipas"){
               estado1="TAM";
            }            
            if(estado2=="Tlaxcala"){
               estado1="TLA";
            }            
            if(estado2=="Veracruz"){
               estado1="VER";
            }            
            if(estado2=="Yucatán"){
               estado1="YUC";
            }            
            if(estado2=="Tabasco"){
               estado1="TAB";
            }            
            if(estado2=="Zacatecas"){
               estado1="ZAC";
            } 
             
            Object genero1 = JOptionPane.showInputDialog(null,"Selecciona tu genero",
                     "Entidad federativa ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                     new Object[] {"Femenino", "Masculino"}," ");
            
            if(genero1=="Femenino"){
               genero2="FEM"; 
            }            
            if(genero1=="Masculino"){
               genero2="MAS"; 
            }
             
             
             
            genero[folio]= genero2;  
            estado[folio]= estado1;          
            year[folio] = Integer.toString(nacimiento2);
            if(year[folio].length()==1){
               year[folio]="0"+year[folio]; 
            }
                
            mes[folio]=mes2; 
            dia[folio]= dia1.toString();              
            a_materno[folio]=auxam; 
            a_paterno[folio]=auxap; 
            nombre[folio]= auxnm;                                
           
            clave[folio]="0"+folio+"-"+a_paterno[folio].substring(0,2)+
               a_materno[folio].substring(0,1)+nombre[folio].substring(0,3)+"-"+dia[folio]+"-"+mes[folio]+"-"+
               year[folio]+"-"+genero[folio]+"-"+estado[folio];
           
           
            JOptionPane.showMessageDialog(null, "CLAVE DE IDENTIFICACIÓN GENERADA: \n"+ clave[folio].toUpperCase());
            BufferedWriter bw = null;
            FileWriter fw = null;
         
            try {
               String data = clave[folio].toUpperCase();
               File file = new File("registros.txt");
            // Si el archivo no existe, se crea!
               if (!file.exists()) {
                  file.createNewFile();
               }
            // flag true, indica adjuntar información al archivo.
               fw = new FileWriter(file.getAbsoluteFile(), true);
               bw = new BufferedWriter(fw);
               bw.newLine();
               bw.write(data);
               System.out.println("informacion agregada!");
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               try {
                        //Cierra instancias de FileWriter y BufferedWriter
                  if (bw != null)
                     bw.close();
                  if (fw != null)
                     fw.close();
               } catch (IOException ex) {
                  ex.printStackTrace();
               }
            }
         
            
         }
         
         
         
      
         if(menu.equals("8")){
            System.exit(0);
         }
      
         if(menu.equals("3")){
            File file = new File("registros.txt");
            if (!file.exists()) {
               System.out.println("AUN NO EXISTE NINGUN REGISTRO! :C"); 
            }else{
               muestraContenido("registros.txt");
            }             
         }
         
         if(menu.equals("2")){
            File file = new File("registros.txt");
            if (!file.exists()) {
               System.out.println("AUN NO EXISTE NINGUN REGISTRO! :C"); 
            }else{
               Object estado2 = JOptionPane.showInputDialog(null,"Seleccione",
                     "Busqueda por entidad federativa ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                     new Object[] {"Aguascalientes", "Baja California", "Baja California Sur" , "Campeche", "Chiapas","Chihuahua","Coahuila","Colima","CDMX",
                     "Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México (Edo. de)","Michoacan", "Morelos",
                     "Nayarit","Nuevo Leon", "Oaxaca", "Puebla","Queretaro","Quintana Roo", "San Luis Potosí","Sinaloa","Sonora",
                    "Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"}," ");
               if(estado2=="Aguascalientes"){
                  estado1="AGS";
               }           
               if(estado2=="Baja California"){
                  estado1="BCN";
               }  
               if(estado2=="Baja California Sur"){
                  estado1="BCS";
               } 
               if(estado2=="Campeche"){
                  estado1="CAM";
               } 
               if(estado2=="Chiapas"){
                  estado1="CHP";
               } 
               if(estado2=="Chihuahua"){
                  estado1="CHH";
               } 
               if(estado2=="Coahuila"){
                  estado1="COA";
               } 
               if(estado2=="Colima"){
                  estado1="COL";
               } 
               if(estado2=="CDMX"){
                  estado1="CMX";
               } 
               if(estado2=="Durango"){
                  estado1="DGO";
               } 
               if(estado2=="Guanajuato"){
                  estado1="GTO";
               } 
               if(estado2=="Guerrero"){
                  estado1="GRO";
               } 
               if(estado2=="Hidalgo"){
                  estado1="HGO";
               } 
               if(estado2=="Jalisco"){
                  estado1="JAL";
               } 
               if(estado2=="México (Edo. de)"){
                  estado1="MEX";
               } 
               if(estado2=="Michoacan"){
                  estado1="MIC";
               }              
               if(estado2=="Morelos"){
                  estado1="MOR";
               }            
               if(estado2=="Nayarit"){
                  estado1="NAY";
               } 
               if(estado2=="Nuevo Leon"){
                  estado1="NLE";
               } 
               if(estado2=="Oaxaca"){
                  estado1="OAX";
               } 
               if(estado2=="Puebla"){
                  estado1="PUE";
               } 
               if(estado2=="Queretaro"){
                  estado1="QRO";
               } 
               if(estado2=="Quintana Roo"){
                  estado1="ROO";
               } 
               if(estado2=="San Luis Potosí"){
                  estado1="SLP";
               }            
               if(estado2=="Sinaloa"){
                  estado1="SIN";
               }            
               if(estado2=="Sonora"){
                  estado1="SON";
               }            
               if(estado2=="Tabasco"){
                  estado1="TAB";
               }
               if(estado2=="Tamaulipas"){
                  estado1="TAM";
               }            
               if(estado2=="Tlaxcala"){
                  estado1="TLA";
               }            
               if(estado2=="Veracruz"){
                  estado1="VER";
               }            
               if(estado2=="Yucatán"){
                  estado1="YUC";
               }            
               if(estado2=="Tabasco"){
                  estado1="TAB";
               }            
               if(estado2=="Zacatecas"){
                  estado1="ZAC";
               } 
            
                    
                    
                    
               String cadena;
               String estado3="";
               FileReader f = new FileReader("registros.txt");
               BufferedReader b = new BufferedReader(f);
               while((cadena = b.readLine())!=null) {
                  //System.out.println(cadena);
                  //System.out.println(cadena.length());
                  if(cadena.length()==26){
                     estado3=cadena.substring(23,26);
                     if(estado3.equals(estado1)){
                        System.out.println(cadena); 
                     }
                  }
               }
               b.close();
            
               
            } 
         
         
         
         }
         
         
         
         if(menu.equals("4")){   
            Scanner entrada = null;
            String linea;
            int numeroDeLinea = 1;
            boolean contiene = false;
            Scanner sc = new Scanner(System.in);                         
         //Introducimos el texto a buscar
            System.out.print("Introduce el codigo de identificación que desees eliminar: ");
            String texto = sc.nextLine();
         
            try {
            //guardamos el path del fichero en la variable ruta
               String ruta = "registros.txt";
            //creamos un objeto File asociado al fichero seleccionado
               File f = new File(ruta);
            //creamos un Scanner para leer el fichero
               entrada = new Scanner(f);
            //mostramos el nombre del fichero
               System.out.println("Base de datos: " + f.getName());
            //mostramos el texto a buscar
               System.out.println("Registro a eliminar: " + texto);
               while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                  linea = entrada.nextLine();  //se lee una línea
                  if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                     System.out.println("Ubicado en sector: " + numeroDeLinea + ": " + linea);
                     contiene = true;
                     System.out.println("Eliminacion completada");
                     BorrarLinea(numeroDeLinea);                   
                  }
                  numeroDeLinea++; //se incrementa el contador de líneas
               }
               if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
               
                  System.out.println(texto + " no se ha encontrado en el archivo");
               }
            } catch (FileNotFoundException e) {
               System.out.println(e.toString());
            } catch (NullPointerException e) {
               System.out.println(e.toString() + "Aun no se han creado registros");
            } catch (Exception e) {
               System.out.println(e.toString());
            } finally {
               if (entrada != null) {
                  entrada.close();
               }
            }                        
         }
         
            
         if(menu.equals("5")){   
            Scanner entrada = null;
            String linea;
            int numeroDeLinea = 1;
            boolean contiene = false;
            Scanner sc = new Scanner(System.in);                         
         //Introducimos el texto a buscar
            System.out.print("Introduce el codigo de identificación que desees dar de baja: ");
            String texto = sc.nextLine();
         
            try {
            //guardamos el path del fichero en la variable ruta
               String ruta = "registros.txt";
            //creamos un objeto File asociado al fichero seleccionado
               File f = new File(ruta);
            //creamos un Scanner para leer el fichero
               entrada = new Scanner(f);
            //mostramos el nombre del fichero
               System.out.println("Base de datos: " + f.getName());
            //mostramos el texto a buscar
               System.out.println("Registro que sera dado de baja: " + texto);
               while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                  linea = entrada.nextLine();  //se lee una línea
                  if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                     System.out.println("Ubicado en sector: " + numeroDeLinea + ": " + linea);
                     contiene = true;
                     papelera(numeroDeLinea);    
                     System.out.println("Desinstalacion completada");               
                  }
                  numeroDeLinea++; //se incrementa el contador de líneas
               }
               if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
               
                  System.out.println(texto + " no se ha encontrado en el archivo");
               }
            } catch (FileNotFoundException e) {
               System.out.println(e.toString());
            } catch (NullPointerException e) {
               System.out.println(e.toString() + "Aun no se han creado registros");
            } catch (Exception e) {
               System.out.println(e.toString());
            } finally {
               if (entrada != null) {
                  entrada.close();
               }
            }                        
         }
      
         if(menu.equals("6")){   
            Scanner entrada = null;
            String linea;
            int numeroDeLinea = 1;
            boolean contiene = false;
            Scanner sc = new Scanner(System.in);                         
         //Introducimos el texto a buscar
            System.out.print("Introduce el codigo de identificación que desees restaurar: ");
            String texto = sc.nextLine();
         
            try {
            //guardamos el path del fichero en la variable ruta
               String ruta = "registros.txt";
            //creamos un objeto File asociado al fichero seleccionado
               File f = new File(ruta);
            //creamos un Scanner para leer el fichero
               entrada = new Scanner(f);
            //mostramos el nombre del fichero
               System.out.println("Base de datos: " + f.getName());
            //mostramos el texto a buscar
               System.out.println("Registro que sera restaurado: " + texto);
               while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                  linea = entrada.nextLine();  //se lee una línea
                  if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                     System.out.println("Ubicado en sector: " + numeroDeLinea + ": " + linea);
                     contiene = true;
                     recuperar(numeroDeLinea);  
                     System.out.println("Restauracion completada");                 
                  }
                  numeroDeLinea++; //se incrementa el contador de líneas
               }
               if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
               
                  System.out.println(texto + " no se ha encontrado en el archivo");
               }
            } catch (FileNotFoundException e) {
               System.out.println(e.toString());
            } catch (NullPointerException e) {
               System.out.println(e.toString() + "Aun no se han creado registros");
            } catch (Exception e) {
               System.out.println(e.toString());
            } finally {
               if (entrada != null) {
                  entrada.close();
               }
            }                        
         }
         
         if(menu.equals("7")){   
            Scanner entrada = null;
            String linea;
            int numeroDeLinea = 1;
            boolean contiene = false;
            Scanner sc = new Scanner(System.in);                         
         //Introducimos el texto a buscar
            System.out.print("Introduce el codigo de identificación que desees modificar: ");
            String texto = sc.nextLine();
         
            try {
            //guardamos el path del fichero en la variable ruta
               String ruta = "registros.txt";
            //creamos un objeto File asociado al fichero seleccionado
               File f = new File(ruta);
            //creamos un Scanner para leer el fichero
               entrada = new Scanner(f);
            //mostramos el nombre del fichero
               System.out.println("Base de datos: " + f.getName());
            //mostramos el texto a buscar
               System.out.println("Registro que sera modificado: " + texto);
               while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                  linea = entrada.nextLine();  //se lee una línea
                  if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                     System.out.println("Ubicado en sector: " + numeroDeLinea + ": " + linea);
                     contiene = true;                  
                     System.out.println("Iniciando sistema de modificacion");                 
                     // recuperar(numeroDeLinea);  
                     folio=  Integer.parseInt(linea.substring(0,2));                     
                     do {
                        auxnm = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su nombre o nombres:");
                        for (n = 0; n < auxnm.length(); n++) {
                           pnomb = auxnm.charAt(n);     //Este for detecta si el nombre lleva numeros o no
                        }
                        if (pnomb < 64 || pnomb > 123) {
                           JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        if (auxnm.length() < 1) {
                           JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
                        }
                     } while (auxnm.length() < 1 || pnomb < 64 || pnomb > 123);
                  
                     do {
                        auxap = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su apellido paterno:");
                        for (n = 0; n < auxap.length(); n++) {
                           pap = auxap.charAt(n);     //Este for detecta si el nombre lleva numeros o no
                        }
                        if (pap < 64 || pap > 123) {
                           JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        if (auxap.length() < 1) {
                           JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
                        }
                     } while (auxap.length() < 1 || pap < 64 || pap > 123);
                  
                     do {
                        auxam = JOptionPane.showInputDialog("Registro: " + folio+ "\n Ingrese su apellido materno:");
                        for (n = 0; n < auxam.length(); n++) {
                           pam = auxam.charAt(n);     //Este for detecta si el nombre lleva numeros o no
                        }
                        if (pam < 64 || pam > 123) {
                           JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS :v", //Si el nombre lleva numeros te regresa
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        if (auxam.length() < 1) {
                           JOptionPane.showMessageDialog(null, "¡NO VALIDO! Datos en blanco", "Error OwO", //Este if detecta si el nombre está o no en
                                    JOptionPane.ERROR_MESSAGE);                                                //blanco
                        }
                     } while (auxam.length() < 1 || pam < 64 || pam > 123);
                  
                  
                     JOptionPane.showMessageDialog(null, "A continuación ingresará su fecha de nacimiento");
                     Object dia1 = JOptionPane.showInputDialog(null,"Selecciona día de nacimiento",
                        "Día :3", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] {"01", "02", "03" , "04", "05","06","07","08","09","10","11","12","13",
                        "14", "15", "16" , "17", "18","19","20","21","22","23","24","25","26","27","28","29","30","31"}," ");
                  
                     Object mes1 = JOptionPane.showInputDialog(null,"Selecciona mes de nacimiento",
                        "Mes ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] {"Enero", "Febrero", "Marzo" , "Abril", "Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}," ");
                  
                     if(mes1=="Enero"){
                        mes2="01"; 
                     }
                     if(mes1=="Febrero"){
                        mes2="02"; 
                     }
                     if(mes1=="Marzo"){
                        mes2="03"; 
                     }
                     if(mes1=="Abril"){
                        mes2="04"; 
                     }
                     if(mes1=="Mayo"){
                        mes2="05"; 
                     }
                     if(mes1=="Junio"){
                        mes2="06"; 
                     }
                     if(mes1=="Julio"){
                        mes2="07"; 
                     }
                     if(mes1=="Agosto"){
                        mes2="08"; 
                     }
                     if(mes1=="Septiembre"){
                        mes2="09"; 
                     }
                     if(mes1=="Octubre"){
                        mes2="10"; 
                     }
                     if(mes1=="Noviembre"){
                        mes2="11"; 
                     }
                     if(mes1=="Diciembre"){
                        mes2="12"; 
                     }
                  
                  
                  
                  
                  
                     do {
                        number=0; 
                        nacimiento1 = JOptionPane.showInputDialog("Ingrese su año de nacimiento (aaaa) o (aa)");
                        if (nacimiento1.length()>=2 &&  nacimiento1.length()<=4 &&   nacimiento1.length()!=3){
                           if(nacimiento1.length()==4){                             
                              try {
                                 nacimiento2 = Integer.parseInt(nacimiento1);
                              } catch (NumberFormatException ex) {
                                 JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                                 number = 1;               
                              }
                              if(number==0){
                                 if(nacimiento2>=2000 && nacimiento2<=2100){
                                    nacimiento2=nacimiento2-2000; 
                                 }else if(nacimiento2>=1900 && nacimiento2<=1999){
                                    nacimiento2=nacimiento2-1900; 
                                 }else{
                                    JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                       JOptionPane.ERROR_MESSAGE);
                                    number=1; 
                                 }
                              }                    
                           }
                        
                        
                           if(nacimiento1.length()==2){
                              try {
                                 nacimiento2 = Integer.parseInt(nacimiento1);
                              } catch (NumberFormatException ex) {
                                 JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                                 number = 1;               
                              }               
                           }
                        
                        
                        
                           System.out.println("Fecha abreviada: "+nacimiento2); 
                        }else{
                           JOptionPane.showMessageDialog(null, "¡NO VALIDO!", "Error OwO",
                                    JOptionPane.ERROR_MESSAGE);
                           number = 1; 
                        }
                     } while (number == 1);  
                  
                  
                  
                  
                     Object estado2 = JOptionPane.showInputDialog(null,"Selecciona tu estado de nacimiento",
                        "Entidad federativa ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] {"Aguascalientes", "Baja California", "Baja California Sur" , "Campeche", "Chiapas","Chihuahua","Coahuila","Colima","CDMX",
                        "Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México (Edo. de)","Michoacan", "Morelos",
                        "Nayarit","Nuevo Leon", "Oaxaca", "Puebla","Queretaro","Quintana Roo", "San Luis Potosí","Sinaloa","Sonora",
                        "Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"}," ");
                  
                     if(estado2=="Aguascalientes"){
                        estado1="AGS";
                     }           
                     if(estado2=="Baja California"){
                        estado1="BCN";
                     }  
                     if(estado2=="Baja California Sur"){
                        estado1="BCS";
                     } 
                     if(estado2=="Campeche"){
                        estado1="CAM";
                     } 
                     if(estado2=="Chiapas"){
                        estado1="CHP";
                     } 
                     if(estado2=="Chihuahua"){
                        estado1="CHH";
                     } 
                     if(estado2=="Coahuila"){
                        estado1="COA";
                     } 
                     if(estado2=="Colima"){
                        estado1="COL";
                     } 
                     if(estado2=="CDMX"){
                        estado1="CMX";
                     } 
                     if(estado2=="Durango"){
                        estado1="DGO";
                     } 
                     if(estado2=="Guanajuato"){
                        estado1="GTO";
                     } 
                     if(estado2=="Guerrero"){
                        estado1="GRO";
                     } 
                     if(estado2=="Hidalgo"){
                        estado1="HGO";
                     } 
                     if(estado2=="Jalisco"){
                        estado1="JAL";
                     } 
                     if(estado2=="México (Edo. de)"){
                        estado1="MEX";
                     } 
                     if(estado2=="Michoacan"){
                        estado1="MIC";
                     }              
                     if(estado2=="Morelos"){
                        estado1="MOR";
                     }            
                     if(estado2=="Nayarit"){
                        estado1="NAY";
                     } 
                     if(estado2=="Nuevo Leon"){
                        estado1="NLE";
                     } 
                     if(estado2=="Oaxaca"){
                        estado1="OAX";
                     } 
                     if(estado2=="Puebla"){
                        estado1="PUE";
                     } 
                     if(estado2=="Queretaro"){
                        estado1="QRO";
                     } 
                     if(estado2=="Quintana Roo"){
                        estado1="ROO";
                     } 
                     if(estado2=="San Luis Potosí"){
                        estado1="SLP";
                     }            
                     if(estado2=="Sinaloa"){
                        estado1="SIN";
                     }            
                     if(estado2=="Sonora"){
                        estado1="SON";
                     }            
                     if(estado2=="Tabasco"){
                        estado1="TAB";
                     }
                     if(estado2=="Tamaulipas"){
                        estado1="TAM";
                     }            
                     if(estado2=="Tlaxcala"){
                        estado1="TLA";
                     }            
                     if(estado2=="Veracruz"){
                        estado1="VER";
                     }            
                     if(estado2=="Yucatán"){
                        estado1="YUC";
                     }            
                     if(estado2=="Tabasco"){
                        estado1="TAB";
                     }            
                     if(estado2=="Zacatecas"){
                        estado1="ZAC";
                     } 
                  
                     Object genero1 = JOptionPane.showInputDialog(null,"Selecciona tu genero",
                        "Entidad federativa ^OwO^", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] {"Femenino", "Masculino"}," ");
                  
                     if(genero1=="Femenino"){
                        genero2="FEM"; 
                     }            
                     if(genero1=="Masculino"){
                        genero2="MAS"; 
                     }
                    String ID; 
                    ID="0"+folio+"-"+auxap.substring(0,2)+
                   auxam.substring(0,1)+auxnm.substring(0,3)+"-"+dia1.toString()+"-"+mes2+"-"+
                      Integer.toString(nacimiento2)+"-"+genero2+"-"+estado1;                     
                   JOptionPane.showMessageDialog(null, "CLAVE DE IDENTIFICACIÓN GENERADA: \n"+ ID.toUpperCase());
                  cambios(numeroDeLinea,ID);
                  }
                  numeroDeLinea++; //se incrementa el contador de líneas
               }
               if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo
               
                  System.out.println(texto + " no se ha encontrado en el archivo");
               }
            } catch (FileNotFoundException e) {
               System.out.println(e.toString());
            } catch (NullPointerException e) {
               System.out.println(e.toString() + "Aun no se han creado registros");
            } catch (Exception e) {
               System.out.println(e.toString());
            } finally {
               if (entrada != null) {
                  entrada.close();
               }
            }                        
         }
      
      
      
             
      
      }while(salir==0); 
      
      
   }
}
