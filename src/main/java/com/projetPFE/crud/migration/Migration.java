package com.projetPFE.crud.migration;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetPFE.crud.SyncPipe;
@RestController
@RequestMapping("apilogsmigration")

@CrossOrigin(origins = "*")
public class Migration {
	
	
	public String input;
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	
	
	public Migration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Migration(String input) {
		super();
		this.input = input;
	}
	// http://localhost:8383//apilogsmigration/run/{id}
	/*@GetMapping("/run/{id}")
	public void migLog(@PathVariable(value ="id") int id) {
		String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                stdin.println("logstash -f C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf");
		                
		                
		                stdin.close();
		                p.waitFor();
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
	}*/
	///   http://localhost:8383//apilogsmigration/migrate
	@GetMapping("/migrate")
	public void migrationLog() {
		String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                stdin.println("/usr/share/logstash/bin/logstash -f /etc/logstash/logstash.conf");
		                
		                
		                stdin.close();
		                p.waitFor();
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
	}
	
	
	///   http://localhost:8383//apilogsmigration/migratesourceone
		@GetMapping("/migratesourceone")
		public void migrationLogsourceone() {
			String[] command =
			    {
			        "cmd",
			    };
			    Process p;
				try {
					p = Runtime.getRuntime().exec(command);
				        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			                PrintWriter stdin = new PrintWriter(p.getOutputStream());
			                stdin.println("/usr/share/logstash/bin/logstash -f /etc/logstash/sourceone.conf");
			                
			                
			                stdin.close();
			                p.waitFor();
			    	} catch (Exception e) {
			 		e.printStackTrace();
				}
		}
		
		
		///   http://localhost:8383//apilogsmigration/migratesourcetwo
		@GetMapping("/migratesourcetwo")
		public void migrationLogsourcetwo() {
			String[] command =
			    {
			        "cmd",
			    };
			    Process p;
				try {
					p = Runtime.getRuntime().exec(command);
				        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			                PrintWriter stdin = new PrintWriter(p.getOutputStream());
			                stdin.println("/usr/share/logstash/bin/logstash -f /etc/logstash/sourcetwo.conf");
			                
			                
			                stdin.close();
			                p.waitFor();
			    	} catch (Exception e) {
			 		e.printStackTrace();
				}
		}
		
	
	////"C:\elasticsearchtools\logstash-7.11.1\logstash.conf"
	
	///   http://localhost:8383//apilogsmigration/getfile
		@GetMapping("/getfile")
		public void getFileLog() {
			String[] command =
			    {
			        "bash",
			    };
			    Process p;
				try {
					p = Runtime.getRuntime().exec(command);
				        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			                PrintWriter stdin = new PrintWriter(p.getOutputStream());
			                stdin.println("/etc/logstash/logstash.conf");
			                
			                
			                stdin.close();
			                p.waitFor();
			    	} catch (Exception e) {
			 		e.printStackTrace();
				}
		}
		///   http://localhost:8383//apilogsmigration/getfile
				@GetMapping("/getfileOnlyone")
				public void getFileLogOnlyone() {
					String[] command =
					    {
					        "bash",
					    };
					    Process p;
						try {
							p = Runtime.getRuntime().exec(command);
						        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
					                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
					                PrintWriter stdin = new PrintWriter(p.getOutputStream());
					                stdin.println("/etc/logstash/sourceone.conf");
					                
					                
					                stdin.close();
					                p.waitFor();
					    	} catch (Exception e) {
					 		e.printStackTrace();
						}
				}
		/*@GetMapping("/gettttfile")
		public String filing() {
			String line = "nothing" ;
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf"));
			 for (int i = 0 ; i <= 10 ; i++) {
				 line = br.readLine();
				 System.out.println(line);
			 }
			 br.close();
			}
			catch(IOException e) {
				//System.out.println(e);
				System.err.print(" cant load from file");
				System.err.print(e);
				
			}
			return line;
		}*/
	////>more C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf
	/*	@GetMapping("/gettfile")
		public List<String> fillling() {
			String line = "nothing" ;
			List<String> all = new ArrayList<>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf"));
			 for (int i = 0 ; i <= 10 ; i++) {
				 line = br.readLine();
				 all.add(line);
				 System.out.println(line);
			 }
			 br.close();
			}
			catch(IOException e) {
				//System.out.println(e);
				System.err.print(" cant load from file");
				System.err.print(e);
				
			}
			return all;   
		}*/
		
		//http://localhost:8383//apilogsmigration/
		/*@GetMapping("/aa")
	public String gets() throws IOException {
			//List<String> all = new ArrayList<>();
			//String all;
			Migration m = new Migration();
			File file = new File("C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf");
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();

			String str = new String(data);
			m.input = str;
			//all = m.input;
			return m.getInput();
	}*/

}
