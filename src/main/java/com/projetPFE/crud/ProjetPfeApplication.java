package com.projetPFE.crud;

import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;






@SpringBootApplication
public class ProjetPfeApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProjetPfeApplication.class);
    }

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProjetPfeApplication.class, args);
		
		
		
		/*File dir = new File("C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf");
        String[] cmdArray = {"logstash","-f logstash.conf", "C:\\elasticsearchtools\\logstash-7.11.1\\logstash.conf"};
        
        Process proc = Runtime.getRuntime().exec(cmdArray, null, dir);
        
        PrintWriter out = new PrintWriter("C:/Product/projetPfetest_out.txt");
        Scanner scOut = new Scanner(proc.getInputStream());
        while (scOut.hasNextLine())
        {
            String line = scOut.nextLine();
            out.println(line);
            System.out.println(line);
        }
        out.close();
        scOut.close();
        
        PrintWriter err = new PrintWriter("C:/Product/projetPfe/test_err.txt");
        Scanner scErr = new Scanner(proc.getErrorStream());
        while (scErr.hasNextLine())
        {
            String line = scErr.nextLine();
            err.println(line);
            System.err.println(line);
        }
        err.close();
        scErr.close();
        
        System.out.println("Exit Status : " + proc.waitFor());
  
        
      /* 
         try {
       

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "logstash","-f","C:/elasticsearchtools/logstash-7.11.1/logstash.conf");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line1;
            while (true) {
                line1 = r.readLine();
                if (line1 == null) { break; }
                System.out.println(line1);
            }

            }catch(Exception e) {
                    e.printStackTrace();
            }
        */
        
      /*  try
        {
                String s = "";
                String[] cmd = new String[]{"logstash -f logstash.conf","C:\\elasticsearchtools\\logstash-7.11.1"};
                Process processes = Runtime.getRuntime().exec(cmd);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(processes.getInputStream()));
                while ((s = stdInput.readLine()) != null)
                {
                        System.out.println(s);
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
        
		
		
		
		//ProcessBuilder processBuilder = new ProcessBuilder();
		// Windows
       //processBuilder.command("cmd.exe", "C:\\elasticsearchtools\\logstash-7.11.1", "logstash -f logstash.conf");

       /* try {

        	Process process = Runtime.getRuntime().exec(
                    "cmd C:\\elasticsearchtools\\kibana-7.11.1-windows-x86_64\\bin kibana.bat", null, new File("C:\\elasticsearchtools\\kibana-7.11.1-windows-x86_64\\bin"));

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
		
		
		
		
		///////// test solution amine 
		
		/*try {
            List<String> commands = new ArrayList<>();
            commands.add("CMD");
            commands.add("C://elasticsearchtools//logstash-7.11.1//"); 
            commands.add("logstash");
            commands.add("-f");  
            commands.add("C://elasticsearchtools//logstash-7.11.1//logstash.conf");
            ProcessBuilder pb = new ProcessBuilder(commands);
             try {
                    Process p = pb.start();
                    int j = p.waitFor();
                    int exitValue = p.exitValue();
                    System.out.println("Finished with code: " + j);
                    System.out.println("Finished with exitValue: " + exitValue);
                } catch (Exception e) {
                    System.out.println("exception: " + e);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		
		// this is the best solution 
		
		/*String[] command =
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
        */
        
		
	}}
	/*public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
    }*/

	/*@Bean
	public boolean createTestIndex(RestHighLevelClient restHighLevelClient) throws Exception {
		try {
			DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("projet-pfe");
			restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT); // 1
		} catch (Exception ignored) {
		}

		CreateIndexRequest createIndexRequest = new CreateIndexRequest("projet-pfe");
		createIndexRequest.settings(
				Settings.builder().put("index.number_of_shards", 1)
						.put("index.number_of_replicas", 0));
		restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT); // 2

		return true;
	}


}
		
		/*RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http")));
		
		
		
		
		SearchRequest searchRequest = new SearchRequest();
	    searchRequest.indices("tesla_employees");
	    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
	    searchRequest.source(searchSourceBuilder);
	    Map<String, Object> map=null;
	     
	    try {
	        SearchResponse searchResponse = null;
	        searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
	        if (searchResponse.getHits().getTotalHits().value > 0) {
	            SearchHit[] searchHit = searchResponse.getHits().getHits();
	            for (SearchHit hit : searchHit) {
	                map = hit.getSourceAsMap();
	                  System.out.println("map:"+Arrays.toString(map.entrySet().toArray()));
	                    
	                
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
	}*/


