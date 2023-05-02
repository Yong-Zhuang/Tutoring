
public class BasicAuthenticator implements  Authenticator{
	private String realm;
	public BasicAuthenticator() {
		this.realm="Basic";
	}

	 public boolean authenticate (HttpExchange t)	{
		           //need to realise Base64 decode the userpass and then validate it. if pass, return new Authenticator.Success;
		           String uname="test....."; 
		           String pass ="test.....";
		           if (checkCredentials (uname, pass)) {
		               //return new Authenticator.Success (new HttpPrincipal (uname, realm));
		              return true;
		           } else {
//		               Headers map = (Headers) t.getResponseHeaders();
//		               map.set ("WWW-Authenticate", "Basic realm=" + "\""+realm+"\"");
		               //return new Authenticator.Failure(401);
		        	   return false;
		           }
	}
	 private boolean checkCredentials(String uname, String pass)
	 {
		 //need to realise how to check uname and pass;
		 return true;
	 }

}